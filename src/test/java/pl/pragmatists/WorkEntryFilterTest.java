package pl.pragmatists;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static pl.pragmatists.DataProvider.WORK_ENTRIES;
import static pl.pragmatists.Project.INTERNAL;
import static pl.pragmatists.Project.OPEN_SOURCE;

public class WorkEntryFilterTest {

    @Test
    public void shouldFilterByProjectInternal() {
        WorkEntryFilter filter = new WorkEntryFilter(WORK_ENTRIES);

        List<WorkEntry> filtered = filter.filterByProject(INTERNAL);

        Assertions.assertThat(filtered).hasSize(57);
    }
}