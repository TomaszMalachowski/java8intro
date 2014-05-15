package pl.pragmatists.defaults;

public interface DieselRunningCar extends PetrolRunningCar {
    @Override
    default Engine drive() {
        return Engine.Diesel;
    }
}
