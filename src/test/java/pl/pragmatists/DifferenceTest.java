package pl.pragmatists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DifferenceTest {

    @Test
    public void cannotDoInJava7() throws Exception {
        List<String> strings = new ArrayList<>();

        strings.addAll(Arrays.asList());
    }
}
