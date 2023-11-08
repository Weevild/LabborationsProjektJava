import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    private Saab95 saab;

    @Before
    public void setUp() {
        saab = new Saab95();
    }

    @Test
    public void testNrOfDoors() {
        assertEquals("Number of doors should be 2", 2, saab.getNrDoors());
    }

    @Test
    public void testGetDirection() {
        assertEquals("Initial direction should be North", "N", saab.getDirection());
    }

    @Test
    public void testTurningLeft() {
        saab.turnLeft();
        // Assuming the initial direction is North, turning left should make it West
        assertEquals("Turning left should change direction to West", "W", saab.getDirection());
    }

    @Test
    public void testRotatingLeftToNorth() {
        // Assuming the initial direction is North, rotating left 4 times should make it North again
        for (int i = 0; i < 4; i++) {
            saab.turnLeft();
        }
        assertEquals("Rotating left 4 times should return to North", "N", saab.getDirection());
    }

    @Test
    public void testTurningRight() {
        saab.turnRight();
        // Assuming the initial direction is North, turning right should make it East
        assertEquals("Turning right should change direction to East", "E", saab.getDirection());
    }

    @Test
    public void testRotatingRight() {
        // Assuming the initial direction is North, rotating right 4 times should make it North again
        for (int i = 0; i < 4; i++) {
            saab.turnRight();
        }
        assertEquals("Rotating right 4 times should return to North", "N", saab.getDirection());
    }

    @Test
    public void testStartingEngine() {
        saab.startEngine();
        // The current speed should be slightly greater than 0 after starting the engine
        assertTrue("Starting the engine should set current speed greater than 0", saab.getCurrentSpeed() > 0);
    }

    @Test
    public void testStopEngine() {
        saab.startEngine();
        saab.stopEngine();
        assertEquals("Stopping the engine should set current speed to 0", 0, saab.getCurrentSpeed(), 0.0);
    }

}
