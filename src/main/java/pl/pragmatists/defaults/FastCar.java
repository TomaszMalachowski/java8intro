package pl.pragmatists.defaults;

//Rules of resolving default methods:
//-- Subtypes automatically carry over the default methods from their supertypes.
//-- For interfaces that contribute a default method, the implementation in a subtype takes precedence over the one in supertypes.
public interface FastCar extends PetrolRunningCar {
}
