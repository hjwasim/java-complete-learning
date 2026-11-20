import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        int nameComparison = this.name.compareTo(o.name);
        // even if the name is same, it checks for age also
        if (nameComparison == 0) {
            return Integer.compare(this.age, o.age);
        }
        return nameComparison;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (age != person.age) return false;
        return Objects.equals(name, person.name);
    }
}
