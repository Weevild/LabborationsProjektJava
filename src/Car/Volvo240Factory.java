package Car;

public class Volvo240Factory extends VehicleFactory {
        @Override
        public Volvo240 createVehicle() {
            return new Volvo240(0, 0);
        }
}
