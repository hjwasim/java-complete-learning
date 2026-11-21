public class OptimizedDatabaseConnectionPoolDCL {

    // volatile ensures the visibility of updates across threads.
    private static volatile OptimizedDatabaseConnectionPoolDCL instance;

    // prevent direct public instantiation
    private OptimizedDatabaseConnectionPoolDCL() {}

    public static OptimizedDatabaseConnectionPoolDCL getInstance() {
        // No synchronization needed when the instance is already initialized;
        if (instance == null) {
            synchronized (OptimizedDatabaseConnectionPoolDCL.class) {
                if (instance == null) {
                    instance = new OptimizedDatabaseConnectionPoolDCL();
                }
            }
        }
        return instance;
    }
}
