package src;
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
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
