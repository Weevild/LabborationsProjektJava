package Car;

public class ScaniaFactory extends VehicleFactory{
    @Override
    public Scania createVehicle(){
        return new Scania(0,200);
    }
}
