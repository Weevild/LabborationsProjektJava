package Car;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class CarTransport extends Car implements Loadable<Car>{
    public CarTransport(){
        super(2,400,0,0,false,"Car.Car Transport");
        color = Color.cyan;
        setFixedPlatformPosition(true);
        stopEngine();
    }
    private List<Car> storage = new ArrayList<>(); // List of stored objects (vehicles), the "platform" if you will.
    public List<Car> getStorage(){
        return storage;
    } // Getter for storage list
    private boolean FixedPlatformRetractedPosition; // For vehicles with a platform with only up/down positions, checks if platform is "down".
    public boolean getFixedPlatformPosition(){ return FixedPlatformRetractedPosition; } // Getter for platform position
    public void setFixedPlatformPosition(boolean position){ this.FixedPlatformRetractedPosition = position; } // Setter for platform position

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
    public boolean cannotMove(){
        return getFixedPlatformPosition();
    }

    @Override
    public void move(){
        if (!cannotMove()){
            super.move();
            for (Car car : getStorage()) {
                car.setXCoordinate(this.getXCoordinate());
                car.setYCoordinate(this.getYCoordinate());
            }
        }
    }
    @Override
    public void turnLeft(){
        if (!cannotMove()) super.turnLeft();
    }
    @Override
    public void turnRight(){
        if (!cannotMove()) super.turnRight();
    }

}
