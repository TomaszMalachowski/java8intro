package pl.pragmatists.defaults;

public interface PetrolRunningCar extends Car {
    @Override
    default Engine drive() {
        return Engine.Petrol;
    }

    @Override
    default boolean accept(Fuel fuel) {
        return fuel == Fuel.Petrol95 || fuel == Fuel.Petrol98;
    }
}
