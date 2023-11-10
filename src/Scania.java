package src;

import java.awt.*;

public class Scania extends Car {
    public Scania(){
        direction = 0;
        nrDoors = 2;
        color = Color.blue;
        enginePower = 200;
        modelName = "Scania";
        xCoordinate = 0;
        yCoordinate = 0;
        TruckBedAngle = 0;
        stopEngine();
    }

    @Override
    public double speedFactor() {
        // Oklar användning
        return 0.0;
    }

}
