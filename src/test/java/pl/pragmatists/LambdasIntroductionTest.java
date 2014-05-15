package pl.pragmatists;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.Callable;

public class LambdasIntroductionTest {

    @Test
    public void passLambdaAsRunnable() throws Exception {
        run(() -> System.out.println("will be called"));
    }

    @Test
    public void passLambdaAsCallable() throws Exception {
        Assertions.assertThat(call(() -> "1")).isEqualTo("1");
    }

    private void run(Runnable runnable) {
        runnable.run();
    }

    private Object call(Callable runnable) throws Exception {
        return runnable.call();
    }

}