import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class CarTransport extends Vehicles_with_platform implements Loadable<Car>{
    public CarTransport(){
        super(2,400,0,0,"Car Transport");
        color = Color.cyan;
        setFixedPlatformPosition(true);
        stopEngine();
    }
    @Override
    // Stores an object (vehicle) if the absolute value of the distance between vehicle and transporter is below 10 and that the platform is in "down"-position.
    public void storeVehicle(Car vehicle) {
        if (Math.abs(vehicle.getXCoordinate()) - Math.abs(this.getXCoordinate()) <= 10  && Math.abs(vehicle.getYCoordinate()) - Math.abs(this.getYCoordinate()) <= 10 && !(vehicle instanceof CarTransport) && getFixedPlatformPosition()) {
            getStorage().add(vehicle);
        }
    }
    // Implements removeVehicle() since it's obligatory.
    @Override
    public void removeVehicle(Car vehicle){
    }
    // Performs the actual removal of a vehicle from the platform and places it within reasonable distance of transporter.
    public Car removeLastVehicle(){
        if (!getStorage().isEmpty() && getFixedPlatformPosition()) {
            int index = getStorage().size() - 1;
            Car car = getStorage().get(index); // Get the last car

            double offsetX = 5 * (index + 1); // Increment offset for each car
            double offsetY = 5 * (index + 1);

            // Update car's position
            car.setXCoordinate(this.getXCoordinate() + offsetX);
            car.setYCoordinate(this.getYCoordinate() + offsetY);

            // Remove and return the car
            return getStorage().remove(index);
        }
        return null;
    }
    // Checks so that either an angled or fixed platform is in their lowered position
    @Override
    public boolean canMoveCheck(){
        return getFixedPlatformPosition();
    }
}
