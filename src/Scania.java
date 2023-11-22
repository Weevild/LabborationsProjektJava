import java.awt.*;

public class Scania extends Vehicles_with_platform {

    public Scania(){
        super(2,300,0,0,false,"Scania");
        color = Color.white;
        stopEngine();
        this.cannotMove();
    }

    @Override
    public boolean cannotMove(){
        return getPlatformPosition() < getMaxAngle();
    }


}
