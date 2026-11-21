public class DatabaseConnectionPoolBasic {

    // stores the shared object instance
    private static DatabaseConnectionPoolBasic instance;

    // prevents new DatabaseConnectionPool()
    private DatabaseConnectionPoolBasic() {}

    // synchronized - Ensures only one thread execute this method at a time
    public static synchronized DatabaseConnectionPoolBasic getInstance() {
        if (instance == null) {
            return new DatabaseConnectionPoolBasic();
        }
        return instance;
    }

    /*
    This has problem, even after the singleton object is created,
    every call to getInstance() method must acquire the synchronization lock.
     */
}
