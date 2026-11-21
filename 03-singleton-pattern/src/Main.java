
public class Main {
    // Creational Design Patterns focus on how objects are created.
    // Most famous patterns are Singleton, Factory and Builder

    // Singleton : Ensures only one instance of class

    public static void main(String[] args) {
        System.out.println(DatabaseConnectionPoolBasic.getInstance());
    }
}