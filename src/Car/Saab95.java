package Car;

import java.awt.*;
public class Saab95 extends Car {
    private boolean turboOn;
    public Saab95(){
        super(0,125,0,0, false, "Saab95");
        color = Color.red;
        turboOn = false;
    }
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
 }

