package pl.pragmatists;

public class Person {
    String email;

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
