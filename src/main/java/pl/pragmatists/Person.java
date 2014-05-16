package pl.pragmatists;

public class Person {
    String email;
    int age;

    public static Person NO_ONE = new Person("",0);

    public Person(String email, int age) {
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return email;
    }
}
