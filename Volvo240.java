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
    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
