package Car;
public interface Loadable<T extends Vehicle> {
    void storeVehicle(T vehicle);
    int getAmountOfVehicle();
}