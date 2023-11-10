import java.awt.*;

public class Scania extends Car implements Trucks{

    private int platformAngle;

    public Scania(){
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
    public double speedFactor(){
        return 0;
    }
    @Override
    public void platformUp(){

    }

}
