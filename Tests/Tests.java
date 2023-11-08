import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import static org.junit.Assert.*;

public class Tests {

    private Saab95 Saab = new Saab95();

    /*@Before
    void setUp() throws Exception{
        Car Car = new Car();
        Saab95 Saab = new Saab95();
    }*/

    @Test
    void nrOfDoors(){
        assertEquals("GetNrOfDoors should work",Saab.getNrDoors(), 2);
    }
    @Test
    void getDirection(){
        assertEquals("Get direction works", Saab.getDirection(), "N");
    }

    @Test
    void TurningLeft(){
        Saab.turnLeft();
        assertEquals("Turning left works", Saab.getDirection(), "E");
    }
    @Test
    void RotatingLeftToNorth(){
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        assertEquals("Rotating left works", Saab.getDirection(), "N");
    }

    @Test
    void TurningRight(){
        Saab.turnRight();
        assertEquals("Turning right works", Saab.getDirection(), "W");
    }
    @Test
    void RotatingRight(){
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        assertEquals("Rotating right works", Saab.getDirection(), "N");
    }

    @Test
    void StartingEngine(){
        Saab.startEngine();
        assertSame("Engine moves the car forward slowly", Saab.getCurrentSpeed(), 0.1);
    }

    @Test
    void StopEngine(){
        Saab.stopEngine();
        assertSame("Engine stop the car and any movement", Saab.getCurrentSpeed(), 0);

    }

    @Test
    void IncreasingSpeed(){
        assertEquals("Speed has increased", );
    }


}
