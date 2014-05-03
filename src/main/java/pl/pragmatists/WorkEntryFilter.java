package pl.pragmatists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkEntryFilter {
    private List<WorkEntry> workEntries;

    public WorkEntryFilter(List<WorkEntry> workEntries) {
        this.workEntries = workEntries;
    }

    public List<WorkEntry> filterByProject(Project project) {
        return workEntries.stream()
                .filter(entry -> entry.getProject() == project)
                .collect(Collectors.toList());
    }

    public List<WorkEntry> filterByPerson(Person person) {
        return workEntries.stream()
                .filter(entry -> entry.getPerson().equals(person))
                .collect(Collectors.toList());
    }
}
