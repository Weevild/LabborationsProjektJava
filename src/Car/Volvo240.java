package Car;

import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;
    public Volvo240(){
        super(4,100,0,0,false, "Volvo240");
        color = Color.black;
    }
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
