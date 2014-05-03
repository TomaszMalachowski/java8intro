package pl.pragmatists;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.pragmatists.DataProvider.GREG;
import static pl.pragmatists.DataProvider.JOHN;
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
}