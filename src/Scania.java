import java.awt.*;

public class Scania extends Vehicles_with_platform {

    public Scania(){
        super(2,300,0,0,"Scania");
        color = Color.white;
        stopEngine();
    }

    @Override
    public boolean canMoveCheck(){
        return getPlatformPosition() == getMinAngle();
    }


}
