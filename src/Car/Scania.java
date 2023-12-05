package Car;

import java.awt.*;
import java.util.List;

public class Scania extends Car {

    public Scania(){
        super(2,300,0,0,false,"Scania");
        color = Color.white;
        stopEngine();
        setPlatformPosition(70);
    }
    private double platformAngle; // For vehicles with adjustable platform
    private final int maxAngle = 70;
    private final int minAngle = 0;
    @Override
    public void turnLeft(){
        if (!cannotMove()) super.turnLeft();
    }
    @Override
    public void turnRight(){
        if (!cannotMove()) super.turnRight();
    }


    public double getPlatformPosition() { // Getter for platform angle
        return platformAngle;
    }
    public void setPlatformPosition(double angle) { this.platformAngle = angle; }
    public boolean cannotMove(){
        return getPlatformPosition() < maxAngle;
    }
    public void platformUp(double amount) {
        if (getCurrentSpeed() == 0) {
            double newAngle = Math.min(getPlatformPosition() + amount, maxAngle);
            setPlatformPosition(newAngle);
        }
    }
    // Takes angle degrees and lowers the platform with said degrees
    public void platformDown(double amount) {
        if (getCurrentSpeed() == 0) {
            double newAngle = Math.max(getPlatformPosition() - Math.abs(amount), minAngle);
            setPlatformPosition(newAngle);
        }
    }
}
