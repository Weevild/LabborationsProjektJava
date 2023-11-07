import java.awt.*;
public class Saab95 extends Car {
    public boolean turboOn;
    public Saab95(){
        direction = 0;
        xCoordinate = 0;
        yCoordinate = 0;
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    private void setTurboOn(){
        turboOn = true;
    }
    private void setTurboOff(){
        turboOn = false;
    }
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        double newSpeed  = getCurrentSpeed() + speedFactor() * amount;
        if (newSpeed <= enginePower && newSpeed > getCurrentSpeed()) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }
    }
    @Override
    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (newSpeed <= getCurrentSpeed()) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
    }
 }

