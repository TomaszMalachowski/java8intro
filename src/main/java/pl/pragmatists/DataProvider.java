package pl.pragmatists;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.APRIL;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static pl.pragmatists.Project.COMMERCIAL;
import static pl.pragmatists.Project.INTERNAL;

public class DataProvider {
    public static List<Person> PEOPLE = new ArrayList<>();
    public static Person JOHN = new Person("john@company.com");
    public static Person JANE = new Person("jane@company.com");
    public static Person SARA = new Person("sara@company.com");
    public static Person GREG = new Person("greg@company.com");

    static {
        DataProvider.PEOPLE.add(DataProvider.JOHN);
        DataProvider.PEOPLE.add(DataProvider.JANE);
        DataProvider.PEOPLE.add(DataProvider.SARA);
        DataProvider.PEOPLE.add(DataProvider.GREG);

        DataProvider.WORK_ENTRIES.addAll(DataProvider.createWorkLogFor(rangeClosed(1, APRIL.maxLength()), INTERNAL, JOHN, JANE));
        DataProvider.WORK_ENTRIES.addAll(DataProvider.createWorkLogFor(rangeClosed(1, APRIL.maxLength()), COMMERCIAL, GREG));
        DataProvider.WORK_ENTRIES.addAll(DataProvider.createWorkLogFor(rangeClosed(1, 13), COMMERCIAL, SARA));
        DataProvider.WORK_ENTRIES.addAll(DataProvider.createWorkLogFor(rangeClosed(14, APRIL.maxLength()), INTERNAL, SARA));
    }

    public static List<WorkEntry> WORK_ENTRIES = new ArrayList<>();

    static List<WorkEntry> createWorkLogFor(IntStream daysOfWork, Project project, Person... people) {
        return LocalDateRange.rangeOf(daysOfWork, APRIL, Year.of(2014))
                .stream()
                .filter(isWorkDay())
                .flatMap(date -> Arrays.asList(people).stream().map(person -> new WorkEntry(date, project, person)))
                .collect(toList());
    }

    private static Predicate<LocalDate> isWorkDay() {
        return date -> date.getDayOfWeek().getValue() >= MONDAY.getValue() && date.getDayOfWeek().getValue() <= FRIDAY.getValue();
    }
}
