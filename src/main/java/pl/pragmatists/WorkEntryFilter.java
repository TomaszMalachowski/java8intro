package pl.pragmatists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
        return filterBy(predicateForPerson(person));
    }

    public List<Person> peopleWorkingOn(Project project) {
        return workEntries.stream()
                .filter(predicateForProject(project))
                .map(WorkEntry::getPerson)
                .collect(toList());
    }

    public Person firstPersonWorkingOn(Project project) {
        return workEntries.stream()
                .filter(predicateForProject(project))
                .sorted(Comparator.comparing(WorkEntry::getDate).thenComparing(entry -> entry.getPerson().getEmail()))
                .findFirst().orElse(new WorkEntry(null, project, Person.NO_ONE))
                .getPerson();
    }

    public List<Integer> getDaysWorkedOnBy(Project project, Person person) {
        return workEntries.stream()
                .filter(predicateForProject(project).and(predicateForPerson(person)))
                .map(WorkEntry::getDate)
                .map(LocalDate::getDayOfMonth)
                .collect(toList());
    }

    public List<Person> getPeopleWorkingOn(LocalDate localDate) {
        return workEntries.stream()
                .filter(entry -> entry.getDate().equals(localDate))
                .map(WorkEntry::getPerson)
                .collect(toList());
    }

    private Predicate<WorkEntry> predicateForProject(Project project) {
        return entry -> entry.getProject() == project;
    }

    private Predicate<WorkEntry> predicateForPerson(Person person) {
        return entry -> entry.getPerson().equals(person);
    }
}
