package pl.pragmatists.defaults;

public interface Car {
    Engine drive();

    boolean accept(Fuel fuel);
}
