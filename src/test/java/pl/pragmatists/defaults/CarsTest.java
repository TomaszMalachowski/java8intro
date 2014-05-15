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
        assertThat(car.accept(Fuel.ArcticReadyDiesel)).isFalse();
        assertThat(car.accept(Fuel.AC)).isFalse();
    }

    @Test
    public void fastCarShouldHavePetrolEngine() {
        Car car = new FastCar() {
        };

        Engine engine = car.drive();

        assertThat(engine).isSameAs(Engine.Petrol);
    }

    @Test
    public void fastCarShouldAcceptOnlyPetrol98() {
        Car car = new FastCar() {
        };

        assertThat(car.accept(Fuel.Petrol98)).isTrue();
        assertThat(car.accept(Fuel.Petrol95)).isFalse();
        assertThat(car.accept(Fuel.Diesel)).isFalse();
        assertThat(car.accept(Fuel.ArcticReadyDiesel)).isFalse();
        assertThat(car.accept(Fuel.AC)).isFalse();
    }

    @Test
    public void volvoXC90ArcticShouldHaveDieselEngine() {
        Car car = new VolvoXC90Arctic();

        Engine engine = car.drive();

        assertThat(engine).isSameAs(Engine.Diesel);
    }

    @Test
    public void volvoXC90ArcticShouldAcceptOnlyArcticReadyDiesel() {
        Car car = new VolvoXC90Arctic();

        assertThat(car.accept(Fuel.ArcticReadyDiesel)).isTrue();
        assertThat(car.accept(Fuel.Petrol95)).isFalse();
        assertThat(car.accept(Fuel.Petrol98)).isFalse();
        assertThat(car.accept(Fuel.Diesel)).isFalse();
        assertThat(car.accept(Fuel.AC)).isFalse();
    }

    @Test
    public void toyotaPriusShouldAcceptAcOrPetrolAsFuel() {
        HybridCar car = new ToyotaPrius();

        assertThat(car.accept(Fuel.AC)).isTrue();
        assertThat(car.accept(Fuel.Petrol95)).isTrue();
        assertThat(car.accept(Fuel.Petrol98)).isTrue();
        assertThat(car.accept(Fuel.Diesel)).isFalse();
        assertThat(car.accept(Fuel.ArcticReadyDiesel)).isFalse();
    }

    @Test
    public void toyotaPriusShouldUseElectricEngineIfBatteryIsOver30PercentFull() {
        HybridCar car = new ToyotaPrius();
        car.batteryLevelIs(45);

        Engine engine = car.drive();

        assertThat(engine).isSameAs(Engine.Electric);
    }

    @Test
    public void toyotaPriusShouldUsePetrolEngineIfBatteryIsBelow30PercentFull() {
        HybridCar car = new ToyotaPrius();
        car.batteryLevelIs(22);

        Engine engine = car.drive();

        assertThat(engine).isSameAs(Engine.Petrol);
    }
}
