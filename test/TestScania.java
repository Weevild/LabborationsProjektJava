import org.junit.Test;

import static org.junit.Assert.*;


public class TestScania {

    public Scania Scania = new Scania();

    @Test
    public void IntitialPlatformAngle(){
        assertEquals("Inital platform angle is correct", 0, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void MovingThePlatformUp(){
        Scania.platformUp(35);
        assertEquals("Moving the platform upwards works", 35, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingToRaiseThePlatformTooHigh(){
        Scania.platformUp(500);
        assertEquals("The restrictions for moving the platform upwards works",70, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void MovingThePlatfromDown(){
        Scania.platformUp(35);
        Scania.platformDown(25);
        assertEquals("Moving the platform downwards works",10, Scania.getPlatformPosition(), 5);
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
        assertEquals("One cannot lower the platform incorrectly",50 , Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingToMoveTheTruckWithPlatformInTheWrongPosition(){
        Scania.platformUp(50);
        Scania.move();
        assertEquals("One cannot move the Scania when the platform is in the wrong position", 0, Scania.getYCoordinate(), 5);
    }
    @Test
    public void TryingToMoveWithPlatformInTheRightPosition(){
        Scania.move();
        assertEquals("One can move the platform when in the right position", 0, 0);
    }


}
