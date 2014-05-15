package pl.pragmatists.defaults;

public interface HybridCar extends ElectricityRunningCar, PetrolRunningCar {
    void batteryLevelIs(int batteryLevel);

    boolean canUseElectricEngine();

    @Override
    default Engine drive() {
        if (canUseElectricEngine()) {
            return ElectricityRunningCar.super.drive();
        } else {
            return PetrolRunningCar.super.drive();
        }
    }

    @Override
    default boolean accept(Fuel fuel) {
        return ElectricityRunningCar.super.accept(fuel) || PetrolRunningCar.super.accept(fuel);
    }
}
