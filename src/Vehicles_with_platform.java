import java.util.ArrayList;
import java.util.List;

public abstract class Vehicles_with_platform extends Car implements Movable {

    public Vehicles_with_platform(){
        super(0,0,0,0,"");
    }
    public Vehicles_with_platform(int nr, int power, double x, double y, String model) {
        super(nr, power, x, y, model); // Calls Car's constructor with the given arguments
        stopEngine();
    }
    private double platformAngle; // For vehicles with adjustable platform
    public double getPlatformAngle(){ return platformAngle; }
    private final int maxAngle = 70;
    private final int minAngle = 0;
    public int getMaxAngle(){ return maxAngle; }
    public int getMinAngle(){ return minAngle; }
    private boolean FixedPlatformRetractedPosition; // For vehicles with a platform with only up/down positions, checks if platform is "down".
    private List<Car> storage = new ArrayList<>(); // List of stored objects (vehicles), the "platform" if you will.
    public boolean getFixedPlatformPosition(){ return FixedPlatformRetractedPosition; } // Getter for platform position
    public void setFixedPlatformPosition(boolean position){ this.FixedPlatformRetractedPosition = position; } // Setter for platform position
    public List<Car> getStorage(){
        return storage;
    } // Getter for storage list
    public abstract boolean canMoveCheck(); // Keeps track of whether vehicle with platform can move
    public double getPlatformPosition() { // Getter for platform angle
        return platformAngle;
    }
    // Takes angle degrees and raises the platform with said degrees
    public void platformUp(double amount) {
        if (!canMoveCheck()) {
            double newAngle = Math.min(getPlatformPosition() + amount, maxAngle);
            if (newAngle >= getPlatformPosition()) {
                platformAngle = newAngle;
            }
        }
    }
    // Takes angle degrees and lowers the platform with said degrees
    public void platformDown(double amount) {
        if (!canMoveCheck()) {
        double newAngle  = Math.max(getPlatformPosition() - amount, minAngle);
        if (newAngle <= getPlatformPosition()) {
            platformAngle = newAngle;
        }
        }
    }
    // When called moves the vehicle if canMoveCheck conditions are met
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
