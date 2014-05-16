package pl.pragmatists;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.pragmatists.DataProvider.GREG;
import static pl.pragmatists.DataProvider.SARA;

public class GroupByTest {

    private List<WorkEntry> workLogEntries = Arrays.asList(
            new WorkEntry(LocalDate.of(2014,6,1),Project.COMMERCIAL, SARA),
            new WorkEntry(LocalDate.of(2014,6,1),Project.INTERNAL, SARA),
            new WorkEntry(LocalDate.of(2014,6,2),Project.COMMERCIAL, SARA),
            new WorkEntry(LocalDate.of(2014,6,3),Project.COMMERCIAL, SARA),
            new WorkEntry(LocalDate.of(2014,6,1),Project.COMMERCIAL, GREG),
            new WorkEntry(LocalDate.of(2014,6,2),Project.COMMERCIAL, GREG)
        );

    @Test
    public void groupByPerson() throws Exception {
        Map<pl.pragmatists.Person, List<WorkEntry>> personWorkEntries = workLogEntries.stream().collect(Collectors.groupingBy(x -> x.getPerson()));

        Assertions.assertThat(personWorkEntries.get(SARA)).hasSize(4);
        Assertions.assertThat(personWorkEntries.get(GREG)).hasSize(2);
    }

    @Test
    public void countByDate() throws Exception {
        Map<LocalDate, Long> countByDate = workLogEntries.stream().collect(
                Collectors.groupingBy(
                        WorkEntry::getDate,
                        Collectors.counting())
        );

        Assertions.assertThat(countByDate.get(LocalDate.of(2014,6,1))).isEqualTo(3);
        Assertions.assertThat(countByDate.get(LocalDate.of(2014,6,3))).isEqualTo(1);
    }

    @Test
    public void groupUniquePeopleByDate() throws Exception {
        Map<LocalDate, Set<Person>> countByDate = workLogEntries.stream().collect(
                Collectors.groupingBy(
                        WorkEntry::getDate,
                        Collectors.mapping(
                                WorkEntry::getPerson,
                                Collectors.toSet()))
        );

        Assertions.assertThat(countByDate.get(LocalDate.of(2014,6,1))).containsOnly(SARA, GREG).doesNotHaveDuplicates();
        Assertions.assertThat(countByDate.get(LocalDate.of(2014,6,3))).containsOnly(SARA).doesNotHaveDuplicates();
    }

    @Test
    public void averageAge() throws Exception {
        Double averageAge1 = DataProvider.PEOPLE.stream().map(Person::getAge).collect(Collectors.averagingInt(value -> value));
        Double averageAge2 = DataProvider.PEOPLE.stream().collect(Collectors.averagingInt(Person::getAge));

        Assertions.assertThat(averageAge1).isEqualTo(29.5);
        Assertions.assertThat(averageAge2).isEqualTo(29.5);
    }

    @Test
    public void reduceToAgeProduct() throws Exception {
        Integer ageProduct = DataProvider.PEOPLE.stream().map(Person::getAge).reduce(1, GroupByTest::integerProduct);

        Assertions.assertThat(ageProduct).isEqualTo(693000);
    }

    public static int integerProduct(int a, int b) {
        return a*b;
    }

}