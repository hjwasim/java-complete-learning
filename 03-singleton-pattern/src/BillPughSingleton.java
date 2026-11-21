public class BillPughSingleton {

    // This model avoids explicits synchronization altogether


    private BillPughSingleton() {}


    private static class SingletonHelper  {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // The JVM loads and initializes the static inner class lazily only once on
    // first use, so subsequent calls to getInstance() always return the same instance.
    // NO LOCKING mechanisms needed.
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
