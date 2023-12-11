package Car;

public class Saab95Factory extends VehicleFactory {
    @Override
    public Saab95 createVehicle(){
        return new Saab95(0,100);
    }
}
