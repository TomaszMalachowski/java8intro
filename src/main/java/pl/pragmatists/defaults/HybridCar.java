package pl.pragmatists.defaults;

public interface HybridCar extends ElectricityRunningCar, PetrolRunningCar {
    void batteryLevelIs(int batteryLevel);

    boolean canUseElectricEngine();

    @Override
    default Engine drive() {
        throw new RuntimeException("I have no idea!");
    }

    @Override
    default boolean accept(Fuel fuel) {
        return ElectricityRunningCar.super.accept(fuel) || PetrolRunningCar.super.accept(fuel);
    }
}
