package Car;

import java.awt.*;

import static java.lang.Math.abs;

public class CarTransport extends Vehicles_with_platform implements Loadable<Car>{
    public CarTransport(){
        super(2,400,0,0,false,"Car.Car Transport");
        color = Color.cyan;
        setFixedPlatformPosition(true);
        stopEngine();
    }
    @Override
    // Stores an object (vehicle) if the absolute value of the distance between vehicle and transporter is below 10 and that the platform is in "down"-position.
    public void storeVehicle(Car vehicle) {
        if (Math.abs(vehicle.getXCoordinate()) - Math.abs(this.getXCoordinate()) <= 10  && Math.abs(vehicle.getYCoordinate()) - Math.abs(this.getYCoordinate()) <= 10 && !(vehicle instanceof CarTransport) && getFixedPlatformPosition()) {
            setIsStored(true);
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

            // Lets the car move again
            setIsStored(false);

            return getStorage().remove(index);
        }
        return null;
    }
    // Checks so that either a fixed platform is in their lowered position
    @Override
    public boolean cannotMove(){
        return getFixedPlatformPosition();
    }
}
