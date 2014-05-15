package pl.pragmatists.defaults;

public interface PetrolRunningCar extends Car {
    @Override
    default Engine drive() {
        return Engine.Petrol;
    }
}
