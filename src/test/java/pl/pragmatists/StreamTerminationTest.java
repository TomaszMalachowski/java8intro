package pl.pragmatists;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminationTest {

    @Test
    public void shouldTerminateWhenCollectIsCalled() throws Exception {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));

        Stream<Integer> intsStream = ints.stream().map(o -> 2 * o); //at this moment stream does not yet reach to the original collection

        ints.add(10);
        Integer sum = intsStream.collect(Collectors.summingInt(value -> value)); // collections is processed at 'collect' which is a terminal operation

        Assertions.assertThat(sum).isEqualTo(32);
    }

}