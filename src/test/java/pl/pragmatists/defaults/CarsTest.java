package pl.pragmatists.defaults;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    //introducing default method
    @Test
    public void fordMondeoShouldHavePetrolEngine() {
        Car car = new FordMondeo();

        Engine engine = car.drive();

        assertThat(engine).isSameAs(Engine.Petrol);
    }

    @Test
    public void fordMondeoShouldAcceptPetrol() {
        Car car = new FordMondeo();

        assertThat(car.accept(Fuel.Petrol95)).isTrue();
        assertThat(car.accept(Fuel.Petrol98)).isTrue();
        assertThat(car.accept(Fuel.Diesel)).isFalse();
        assertThat(car.accept(Fuel.AC)).isFalse();
    }
}
