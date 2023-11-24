package Car;

import java.util.List;
import java.util.ArrayList;
public class Workshop<T extends Car> implements Loadable<T> {
    private boolean specializedWorkshop;
    private int vehicleLimit;
    protected List<T> vehicles = new ArrayList<>();

    List<Integer> myList = new ArrayList<>();
    public void setSpecializedWorkshop(boolean specialized) {
        this.specializedWorkshop = specialized;
    }

    public boolean isSpecializedWorkshop() {
        return specializedWorkshop;
    }

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
    // Overloading
    public void removeVehicle(T vehicle) {
        if(vehicles.size() < vehicleLimit){
            this.vehicles.remove(vehicle);
        }
    }
    @Override
    public List<T> getStorage(){
        return this.vehicles;
    }

}
