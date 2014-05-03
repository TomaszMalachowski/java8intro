package pl.pragmatists;

import org.apache.commons.lang3.Range;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.pragmatists.DataProvider.GREG;
import static pl.pragmatists.DataProvider.JANE;
import static pl.pragmatists.DataProvider.JOHN;
import static pl.pragmatists.DataProvider.PEOPLE;
import static pl.pragmatists.DataProvider.SARA;
import static pl.pragmatists.DataProvider.WORK_ENTRIES;
import static pl.pragmatists.Project.COMMERCIAL;
import static pl.pragmatists.Project.INTERNAL;
import static pl.pragmatists.Project.OPEN_SOURCE;

public class WorkEntryFilterTest {
private WorkEntryFilter filter = new WorkEntryFilter(WORK_ENTRIES);

    @Test
    public void shouldFilterByProjectInternal() {
        List<WorkEntry> filtered = filter.filterByProject(INTERNAL);

        assertThat(filtered).hasSize(57);
    }

    @Test
    public void shouldFilterByPerson() {

        List<WorkEntry> filtered = filter.filterByPerson(JOHN);

        assertThat(filtered).hasSize(22);
    }

    @Test
    public void shouldFindAllPeopleWorkingOnCommercialProject() {
        List<Person> people = filter.peopleWorkingOn(COMMERCIAL);

        assertThat(people).containsOnly(GREG, SARA);
    }

    @Test
    public void shouldFindFirstPersonWorkingOnProject() {
        Person person = filter.firstPersonWorkingOn(INTERNAL);

        assertThat(person).isEqualTo(JANE);
    }

    @Test
    public void shouldFindNooneWorkingForOpenSource() {
        Person person = filter.firstPersonWorkingOn(OPEN_SOURCE);

        assertThat(person).isEqualTo(Person.NO_ONE);
    }

    @Test
    public void shouldGetPeopleWorkingOnDate() {
        List<Person> people = filter.getPeopleWorkingOn(LocalDate.of(2014, 4,11));

         assertThat(people).containsAll(PEOPLE);
    }

    @Test
    public void shouldGetDaysWhenSomeoneWorkedOnInternalProject() {
        List<Integer> days = filter.getDaysWorkedOnBy(COMMERCIAL, SARA);

        assertThat(days).containsOnly(1,2,3,4,7,8,9,10,11);
    }
}