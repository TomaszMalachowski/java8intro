package pl.pragmatists.defaults;

//Rules of resolving default methods:
//-- Implementations in classes, including abstract declarations, take precedence over all interface defaults.
public class VolvoXC90Arctic implements DieselRunningCar {
    @Override
    public boolean accept(Fuel fuel) {
        return fuel == Fuel.ArcticReadyDiesel;
    }
}
