package pl.pragmatists.defaults;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CarsTest {
    @Test
    public void fordMondeoShouldHavePetrolEngine() {
        Car car = new FordMondeo();

        Engine engine = car.drive();

        Assertions.assertThat(engine).isSameAs(Engine.Petrol);
    }
}
