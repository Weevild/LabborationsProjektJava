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
    }
    @Override
    // Overloading
    public void storeVehicle(T vehicle) {
        if (vehicles.size() < vehicleLimit) {
            vehicles.add(vehicle);
        }
    }
    @Override
    public T removeVehicle() {
        if(vehicles.size() < vehicleLimit){
            this.vehicles.remove(vehicle);      //Fixa denna
        }
    }

    // Overloading
    public void removeVehicle(T vehicle) {
        if(vehicles.size() < vehicleLimit){
            this.vehicles.remove(vehicle);
        }
    }
    @Override
    public int getAmountOfVehicle() {
        return vehicles.size();
    }

}
