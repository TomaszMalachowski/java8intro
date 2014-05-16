package pl.pragmatists;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreamsTest {

    @Test
    public void calculateFibonacci() throws Exception {
        Stream<Integer> fibonacciStream = Stream.iterate(new FibonacciContext(1, 2), FibonacciContext::nextFibonacci).map(o -> o.prev);

        Assertions.assertThat(fibonacciStream.limit(10).collect(Collectors.toList())).containsExactly(1,2,3,5,8,13,21,34,55,89);
    }

    private static class FibonacciContext {
        private final int prev;
        private final int curr;

        public FibonacciContext(int prev, int curr) {
            this.prev = prev;
            this.curr = curr;
        }

        public static FibonacciContext nextFibonacci(FibonacciContext context) {
            return new FibonacciContext(context.curr,context.prev+context.curr );
        }
    }
}