package Car;

import java.awt.*;

public class Scania extends DegreePlatform {
    public Scania(double x, double y){
        super(2,300,x,y,false,"Scania");
        color = Color.white;
        stopEngine();
        setPlatformPosition(70);
    }
}
