package pl.pragmatists.defaults;

public class ToyotaPrius implements HybridCar {
    private int batteryLevel;

    @Override
    public void batteryLevelIs(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public boolean canUseElectricEngine() {
        return batteryLevel >= 30;
    }
}
