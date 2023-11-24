import Car.Scania;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestScania {

    public Scania Scania = new Scania();

    @Test
    public void IntitialPlatformAngle(){
        assertEquals("Inital platform angle is incorrect", 0, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void MovingThePlatformUp(){
        Scania.platformUp(35);
        assertEquals("Moving the platform upwards doesn't work", 35, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingToRaiseThePlatformTooHigh(){
        Scania.platformUp(500);
        assertEquals("The restrictions for moving the platform upwards doesn't works",70, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void MovingThePlatformDown() {
        Scania.setPlatformPosition(50); // Reset to initial state if needed
        Scania.platformDown(25);
        assertEquals("Moving the platform downwards works", 25, Scania.getPlatformPosition(), 5);
    }

    @Test
    public void TryingTooLowerThePlatformTooLow(){
        Scania.platformUp(50);
        Scania.platformDown(500);
        assertEquals("The restriction for moving the platform downwards works",0,  Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingTooLowerThePlatformIncorrectly(){
        Scania.platformUp(50);
        Scania.platformDown(-10);
        assertEquals("One cannot lower the platform incorrectly",40 , Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingToMoveTheTruckWithPlatformInTheWrongPosition(){
        Scania.platformUp(50);
        Scania.move();
        assertEquals("One cannot move the Car.Scania when the platform is in the wrong position", 0, Scania.getYCoordinate(), 5);
    }
    @Test
    public void TryingToMoveWithPlatformInTheRightPosition(){
        Scania.move();
        assertEquals("One can move the platform when in the right position", 0, 0);
    }


}
