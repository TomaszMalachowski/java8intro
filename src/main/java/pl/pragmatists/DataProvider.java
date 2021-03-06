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
    public static List<WorkEntry> WORK_ENTRIES = new ArrayList<>();

    public static Person JOHN = new Person("john@company.com",20);
    public static Person JANE = new Person("jane@company.com",30);
    public static Person SARA = new Person("sara@company.com",35);
    public static Person GREG = new Person("greg@company.com",33);


    static {
        PEOPLE.add(DataProvider.JOHN);
        PEOPLE.add(DataProvider.JANE);
        PEOPLE.add(DataProvider.SARA);
        PEOPLE.add(DataProvider.GREG);

        WORK_ENTRIES.addAll(createWorkLogFor(rangeClosed(1, APRIL.maxLength()), INTERNAL, JOHN, JANE));
        WORK_ENTRIES.addAll(createWorkLogFor(rangeClosed(1, APRIL.maxLength()), COMMERCIAL, GREG));
        WORK_ENTRIES.addAll(createWorkLogFor(rangeClosed(1, 13), COMMERCIAL, SARA));
        WORK_ENTRIES.addAll(createWorkLogFor(rangeClosed(14, APRIL.maxLength()), INTERNAL, SARA));
    }


    private static List<WorkEntry> createWorkLogFor(IntStream daysOfWork, Project project, Person... people) {
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
