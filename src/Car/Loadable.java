package Car;

import java.util.List;

public interface Loadable<T extends Car> {
    void storeVehicle(T vehicle);
    void removeVehicle(T vehicle);
    int getAmountOfVehicle();
}
