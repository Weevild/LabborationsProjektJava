import java.util.ArrayList;
import java.util.List;

public abstract class Vehicles_with_platform extends Car implements Movable {

    private double platformAngle;
    public int maxAngle;
    public int minAngle;
    private boolean FixedPlatformRetractedPosition;
    private List<Car> storage = new ArrayList<>();

    public boolean getFixedPlatformPosition(){
        return FixedPlatformRetractedPosition;
    }
    public void setFixedPlatformPosition(boolean position){
        this.FixedPlatformRetractedPosition = position;
    }

    public List<Car> getStorage(){
        return storage;
    }

    /* Onödig kod, storeVehicle gör det bättre
    public void setStorage(Car car){
        if (!(car instanceof CarTransport)) {
            this.storage.add(car);
        }
    }
    */
    public Vehicles_with_platform(){   // initializes platform angle as the lowest possible angle
        platformAngle = minAngle;
    }

    public abstract boolean canMoveCheck();
    public double getPlatformPosition() {
        return platformAngle;
    }
    public void platformUp(double amount) {
        if (!canMoveCheck()) {
            double newAngle = Math.min(getPlatformPosition() + amount, maxAngle);
            if (newAngle >= getPlatformPosition()) {
                platformAngle = newAngle;
            }
        }
    }
    public void platformDown(double amount) {
        if (!canMoveCheck()) {
        double newAngle  = Math.max(getPlatformPosition() - amount, minAngle);
        if (newAngle <= getPlatformPosition()) {
            platformAngle = newAngle;
        }
        }
    }
    @Override
    public void move(){
        if (canMoveCheck()){
            super.move();
            for (Car car : getStorage()) {
                car.setXCoordinate(this.getXCoordinate());
                car.setYCoordinate(this.getYCoordinate());
            }
        }
    }
    @Override
    public void turnLeft(){
        if (canMoveCheck()) super.turnLeft();
    }
    @Override
    public void turnRight(){
        if (canMoveCheck()) super.turnRight();
    }

}
