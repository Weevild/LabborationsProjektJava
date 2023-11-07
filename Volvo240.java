import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;
    public Volvo240(){
        direction = 0;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        xCoordinate = 0;
        yCoordinate = 0;
        stopEngine();
    }
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
        double newSpeed  = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        if (newSpeed <= enginePower && newSpeed > getCurrentSpeed()) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        double newSpeed  = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if (newSpeed <= getCurrentSpeed()) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }
    }
}
