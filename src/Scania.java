import java.awt.*;

public class Scania extends Vehicles_with_platform {

    public Scania(){
        direction = 0;
        nrDoors = 2;
        color = Color.white;
        enginePower = 300;
        modelName = "Scania";
        setXCoordinate(0);
        setYCoordinate(0);
        maxAngle = 70;
        minAngle = 0;
        stopEngine();
    }
    public String getModelName() {
        return modelName;
    }

    @Override
    public boolean canMoveCheck(){
        return getPlatformPosition() == minAngle;
    }


}
