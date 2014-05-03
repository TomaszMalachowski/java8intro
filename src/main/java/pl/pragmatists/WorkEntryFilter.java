package pl.pragmatists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class WorkEntryFilter {
    private List<WorkEntry> workEntries;

    public WorkEntryFilter(List<WorkEntry> workEntries) {
        this.workEntries = workEntries;
    }

    public List<WorkEntry> filterByProject(Project project) {
        return filterBy(predicateForProject(project));
    }

    private List<WorkEntry> filterBy(Predicate<WorkEntry> predicate) {
        return workEntries.stream()
                .filter(predicate)
                .collect(toList());
    }

    public List<WorkEntry> filterByPerson(Person person) {
        return filterBy(entry -> entry.getPerson().equals(person));
    }

    public List<Person> peopleWorkingOn(Project project) {
        return workEntries.stream()
                .filter(predicateForProject(project))
                .map(WorkEntry::getPerson)
                .collect(toList());
    }

    private Predicate<WorkEntry> predicateForProject(Project project) {
        return entry -> entry.getProject() == project;
    }

    public Person firstPersonWorkingOn(Project project) {
        return workEntries.stream()
                .filter(predicateForProject(project))
                .sorted((first, second) -> first.getDate().compareTo(second.getDate()))
                .findFirst().orElse(new WorkEntry(null, project, new Person("")))
                .getPerson();
    }
}
