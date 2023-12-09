package Car;

import java.awt.*;

public class Volvo240 extends Vehicle implements isCar{
    private final static double trimFactor = 1.25;
    public Volvo240(double x, double y){
        super(4,100,x,y, false,"Volvo240");
        color = Color.black;
    }
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
