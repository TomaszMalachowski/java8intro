package pl.kamil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonSearch {
    public List<Person> find(List<Person> personList, Predicate<Person> checker) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (checker.test(person))
                result.add(person);
        }
        return result;
    }

    public void process(List<Person> personList, Predicate<Person> predicate, Function<Person, String> mapper, Consumer<String> consumer) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                consumer.accept(mapper.apply(person));
            }
        }
    }
}
