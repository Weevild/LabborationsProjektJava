import Car.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestVolvo240 {

    public Volvo240 Volvo = new Volvo240();


    @Test
    public void GasVolvo() {
        Volvo.startEngine();
        Volvo.gas(0.5);
        assertEquals("Gas works without turbo", Volvo.getCurrentSpeed(), 0.725, 5);
    }
    @Test
    public void BrakingVolvo(){
        Volvo.startEngine();
        Volvo.gas(0.5);
        Volvo.brake(0.5);
        assertEquals("Braking works", Volvo.getCurrentSpeed(), 0, 5);
    }

}

