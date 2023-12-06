package Car;

import java.util.List;
import java.util.ArrayList;
public class Workshop<T extends Car> implements Loadable<T> {
    private int vehicleLimit;
    protected List<T> vehicles = new ArrayList<>();
    public void setVehicleLimit(int limit) {
        this.vehicleLimit = limit;
    }
    public int getVehicleLimit() {
        return vehicleLimit;
    }   //getter for
    @Override
    // Overloading
    public void storeVehicle(T vehicle) {
        if (vehicles.size() < vehicleLimit) {
            vehicles.add(vehicle);
        }
    }
    @Override
    public T removeVehicle() {
        int len = vehicles.size();
        if(len > 0){
            return this.vehicles.remove(0);
        }
        return null;
    }

    @Override
    public int getAmountOfVehicle() {
        return vehicles.size();
    }

}
