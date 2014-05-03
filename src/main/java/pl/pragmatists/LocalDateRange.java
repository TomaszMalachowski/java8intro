package pl.pragmatists;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LocalDateRange {
    public static List<LocalDate> rangeOf(IntStream intStream, Month month, Year year) {
        return intStream
                .boxed()
                .map(day -> LocalDate.of(year.getValue(), month.getValue(), day))
                .collect(Collectors.toList());
    }
}
