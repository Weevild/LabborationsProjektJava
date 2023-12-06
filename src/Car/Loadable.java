package Car;
public interface Loadable<T extends Car> {
    void storeVehicle(T vehicle);
    int getAmountOfVehicle();
}