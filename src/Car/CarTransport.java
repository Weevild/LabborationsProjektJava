package Car;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class CarTransport extends Car implements Loadable<Car>{
    // Creates the instance variable to make use of composition and therefore FixedPlatform's contents
    private FixedPlatform fixedPlatform;
    private List<Car> storage = new ArrayList<>(); // List of stored objects (vehicles), the "platform" if you will.

    public CarTransport(double x, double y){
        super(2,400,x,y,false,"Car Transport");
        fixedPlatform = new FixedPlatform();
        color = Color.cyan;
        fixedPlatform.setFixedPlatformPosition(true);
        stopEngine();
    }
    @Override
    // Stores an object (vehicle) if the absolute value of the distance between vehicle and transporter is below 10 and that the platform is in "down"-position.
    public void storeVehicle(Car vehicle) {
        if (Math.abs(vehicle.getXCoordinate()) - Math.abs(this.getXCoordinate()) <= 10  && Math.abs(vehicle.getYCoordinate()) - Math.abs(this.getYCoordinate()) <= 10 && !(vehicle instanceof CarTransport) && fixedPlatform.getFixedPlatformPosition()) {
            setIsStored(true);
            storage.add(vehicle);
        }
    }
    // Performs the removal of a vehicle from the platform and places it within reasonable distance of transporter.
    public Car removeLastVehicle(){
        if (!storage.isEmpty() && fixedPlatform.getFixedPlatformPosition()) {
            int index = storage.size() - 1;
            Car car = storage.get(index); // Get the last car

            double offsetX = 5 * (index + 1); // Increment offset for each car
            double offsetY = 5 * (index + 1);

            // Update car's position
            car.setXCoordinate(this.getXCoordinate() + offsetX);
            car.setYCoordinate(this.getYCoordinate() + offsetY);

            // Lets the car move again
            setIsStored(false);

            return storage.remove(index);
        }
        return null;
    }
    @Override
    public int getAmountOfVehicle() {
        return storage.size();
    }

    @Override
    public void move() {
        super.move();
        for (Car car : storage) {
            car.setXCoordinate(this.getXCoordinate());
            car.setYCoordinate(this.getYCoordinate());
        }
    }
    @Override
    public void turnLeft(){
        if (!fixedPlatform.cannotMove()) super.turnLeft();
    }
    @Override
    public void turnRight(){
        if (!fixedPlatform.cannotMove()) super.turnRight();
    }

}
