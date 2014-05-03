package pl.pragmatists;

public class Person {
    String email;

    public static Person NO_ONE = new Person("");

    public Person(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return email;
    }
}
