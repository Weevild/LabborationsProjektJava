import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class CarTransport extends Vehicles_with_platform implements StorageThings{
    public CarTransport(){
        direction = 0;
        nrDoors = 2;
        color = Color.cyan;
        enginePower = 400;
        modelName = "Example Car Transport";
        setXCoordinate(0);
        setYCoordinate(0);
        setFixedPlatformPosition(true);
        stopEngine();
    }
    @Override
    public void storeVehicle(){
    }

    public void storeVehicle(Car vehicle) {
        if (Math.abs(vehicle.getXCoordinate()) - Math.abs(this.getXCoordinate()) <= 10  && Math.abs(vehicle.getYCoordinate()) - Math.abs(this.getYCoordinate()) <= 10 && !(vehicle instanceof CarTransport) && getFixedPlatformPosition()) {
            getStorage().add(vehicle);
        }
    }
    @Override
    public void removeVehicle(){
    }

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
    @Override
    public boolean canMoveCheck(){
        return getPlatformPosition() == maxAngle || getFixedPlatformPosition();
    }
}
