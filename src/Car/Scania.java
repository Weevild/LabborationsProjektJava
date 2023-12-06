package Car;

import java.awt.*;

public class Scania extends DegreePlatform {
    public Scania(){
        super(2,300,0,0,false,"Scania");
        color = Color.white;
        stopEngine();
        setPlatformPosition(70);
    }
}
