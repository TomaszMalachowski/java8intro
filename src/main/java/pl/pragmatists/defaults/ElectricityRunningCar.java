package pl.pragmatists.defaults;

public interface ElectricityRunningCar extends Car {
    @Override
    default Engine drive() {
        return Engine.Electric;
    }

    @Override
    default boolean accept(Fuel fuel) {
        return fuel == Fuel.AC;
    }
}
