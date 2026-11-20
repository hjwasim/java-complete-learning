import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("ABC", 21);
        Person p2 = new Person("DEF", 22);
        Person p3 = new Person("ABC", 23);

        // TreeSet internally uses TreeMap
        // 0 - same - equal
        // -ve - curr object comes before the other
        // +ve - curr object comes after the other

        TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);

        /*

        TreeSet uses compareTo() (not equals()) to decide whether two elements are duplicates.
        If compareTo() compares only name and returns 0 when the names match,
        TreeSet treats the second person as a duplicate and drops it—even when age (or another field) differs.
         */
        System.out.println(treeSet);

        Comparator<Person> comparator = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
        TreeSet<Person> personTreeSet = new TreeSet<>(comparator);

        personTreeSet.add(p1);
        personTreeSet.add(p2);
        personTreeSet.add(p3);
        System.out.println(personTreeSet);

        // compareTo() must be consistent with equals().
        // Otherwise, even if equals() returns false (different objects), TreeSet will
        // treat them as duplicates and drop the new element whenever compareTo() returns 0.

        // TreeSet uses Comparator and Comparable to decide whether objects are duplicates, not equals().
    }
}