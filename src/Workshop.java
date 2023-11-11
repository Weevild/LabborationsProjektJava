package src;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class Workshop<T extends Car> implements StorageThings {
    public boolean specializedWorkshop;
    public int vehicleLimit;
    protected List<T> vehicles = new ArrayList<>();

    @Override
    public void storeVehicle(){
    }
    // Overloading
    public void storeVehicle(T vehicle) {
        if (vehicles.size() < vehicleLimit) {
            vehicles.add(vehicle);
        }
    }
    @Override
    public void removeVehicle(){
    }
    // Overloading
    public void removeVehicle(T vehicle) {
        if(vehicles.size() < vehicleLimit){
            this.vehicles.remove(vehicle);
        }
    }
    @Override
    public List getStorage(){
        return this.vehicles;
    }

}
