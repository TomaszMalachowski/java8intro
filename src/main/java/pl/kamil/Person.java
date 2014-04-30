package pl.kamil;


import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    private int age;

    public static List<Person> PEOPLE = new ArrayList<>();

    public static Person JOHN = new Person().name("John").age(20);

    public static Person JANE = new Person().name("Jane").age(21);

    public static Person SARA = new Person().name("Sara").age(21);

    public static Person GREG = new Person().name("Greg").age(35);

    static {
        PEOPLE.add(JOHN);
        PEOPLE.add(JANE);
        PEOPLE.add(SARA);
        PEOPLE.add(GREG);
    }


    public Person age(int age) {
        this.age = age;
        return this;
    }

    public int getAge() {
        return age;
    }


    public Person name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name, age);
    }
}
