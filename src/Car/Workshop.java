package Car;

import java.util.List;
import java.util.ArrayList;

public class Workshop<T extends Vehicle> implements Loadable<T> {
    private int vehicleLimit;
    protected List<T> vehicles = new ArrayList<>();
    public void setVehicleLimit(int limit) {
        this.vehicleLimit = limit;
    }
    public int getVehicleLimit() {
        return vehicleLimit;
    }

    @Override
    // Overloading
    public void storeVehicle(T vehicle) {
        if (vehicles.size() < vehicleLimit) {
            vehicles.add(vehicle);
        }
    }

    public void removeVehicle(T vehicle) {
        int len = vehicles.size();
        if(len > 0){
            this.vehicles.remove(0);
        }
    }

    @Override
    public int getAmountOfVehicle() {
        return vehicles.size();
    }

}
