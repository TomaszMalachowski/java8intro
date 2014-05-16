package pl.pragmatists;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.Callable;

public class LambdasIntroductionTest {

    private String testField = "";

    @Test
    public void quickFix_TryItOnNewRunnable() throws Exception {
        run(new Runnable() {

            @Override
            public void run() {
                System.out.println("will be called");
            }

        });
    }

    @Test
    public void passLambdaAsRunnable() throws Exception {
        run(() -> System.out.println("will be called"));
    }

    @Test
    public void passLambdaAsCallable() throws Exception {
        Assertions.assertThat(call(() -> "1")).isEqualTo("1");
    }

    @Test
    public void passLambdaAsYourSingleMethodInterface() throws Exception {
//      uncomment and try autocomplete (in IntelliJ) inside brackets
//      giveMeFunky();
        giveMeFunky((name, age) -> System.out.println("my name is " + name + " " + age));
    }

    @Test
    public void whatsThisInLambda__ItIsParentScope() throws Exception {
        call(() -> this.testField);
    }

    @Test
    public void contextValuesMustBeEffectivelyFinal() throws Exception {
//      local var needs not to be declared final but be final
        int localVar = 10;
        call(() -> localVar);
        //try to uncomment
//      localVar=10;
    }

    private void run(Runnable runnable) {
        runnable.run();
    }

    private Object call(Callable runnable) throws Exception {
        return runnable.call();
    }

    private void giveMeFunky(CallMeFunky funky) {
        funky.meHavingSingleMethodOnly("java", 8);
    }

    @FunctionalInterface
    //this ensures that this interface is functional and throws error if not
    static interface CallMeFunky {

        void meHavingSingleMethodOnly(String name, int age);

    }

}