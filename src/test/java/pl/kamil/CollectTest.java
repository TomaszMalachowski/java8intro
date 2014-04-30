package pl.kamil;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.kamil.Person.*;

public class CollectTest {
    @Test
    public void testCollect() throws Exception {
        List<Person> peopleOver20 = PEOPLE
                .stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());

        System.out.println(peopleOver20);

        Assertions.assertThat(peopleOver20).containsOnly(JANE, SARA, GREG);
    }

    @Test
    public void testMap() throws Exception {
        List<String> names = PEOPLE.stream().map(Person::getName).collect(Collectors.toList());

        System.out.println(names);

    }

    @Test
    public void testName() throws Exception {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4);

        Integer found = integers.stream().filter(i -> i > 2).findFirst().orElse(-10);

        System.out.println(found);

    }

    @Test
    public void testMemoization() throws Exception {
        Map<String, Person> store = new HashMap<>();
        store.computeIfAbsent()


    }
}
