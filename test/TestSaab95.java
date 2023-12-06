import Car.Car;
import Car.Saab95;
import org.junit.Test;
import org.junit.Assert;

import java.awt.Color;
import static org.junit.Assert.*;

public class TestSaab95 {

    public Saab95 Saab = new Saab95(0,0);

    @Test
    public void nrOfDoors() {
        Assert.assertEquals("GetNrOfDoors should work", Saab.getNrDoors(), 2, 5);
    }
    @Test
    public void getDirection() {
        Assert.assertEquals("Get direction works", Saab.getDirectionIndex(Car.Direction.NORTH), 0);
    }
    @Test
    public void TurningLeft() {
        Saab.turnLeft();
        Assert.assertEquals("Turning left works", Saab.getDirectionIndex(Car.Direction.EAST), 1);
    }
    @Test
    public void RotatingLeftToNorth() {
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Assert.assertEquals("Rotating left works", Saab.getDirectionIndex(Car.Direction.NORTH), 0);
    }
    @Test
    public void TurningRight() {
        Saab.turnRight();
        Assert.assertEquals("Turning right works", Saab.getDirectionIndex(Car.Direction.WEST), 3);
    }
    @Test
    public void RotatingRight() {
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Assert.assertEquals("Rotating right works", Saab.getDirectionIndex(Car.Direction.NORTH), 0);
    }
    @Test
    public void StartingEngine() {
        Saab.startEngine();
        assertEquals("Engine moves the car forward slowly", Saab.getCurrentSpeed(), 0.1, 3);
    }
    @Test
    public void StopEngine() {
        Saab.stopEngine();
        assertEquals("Engine stop the car and any movement", Saab.getCurrentSpeed(), 0.0, 3);

    }
    @Test
    public void getXCoordinate() {
        assertEquals("GetxCoordinate works", Saab.getXCoordinate(), 0, 3);
    }
    @Test
    public void getYCoordinate() {
        assertEquals("GetyCoordinate works", Saab.getYCoordinate(), 0, 3);
    }
    @Test
    public void getColour() {
        assertEquals("Get colour works", Saab.getColor(), Color.red);
    }
    @Test
    public void ChangeColour() {
        Saab.setColor(Color.blue);
        assertEquals("You can change colour", Saab.getColor(), Color.blue);
    }
    @Test
    public void getEnginePower() {
        assertEquals("GetEnginePower works", Saab.getEnginePower(), 125, 3);
    }
    @Test
    public void GasWithTurboSaab() {
        Saab.startEngine();
        Saab.setTurboOn();
        Saab.gas(0.5);
        assertEquals("Gas works with turbo", Saab.getCurrentSpeed(), 0.9125, 5);
    }
    @Test
    public void GasWithTurboOffSaab(){
        Saab.startEngine();
        Saab.gas(0.5);
        assertEquals("Gas works without turbo", Saab.getCurrentSpeed(), 0.725, 5);
    }
    @Test
    public void DrivingForward() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.move();
        assertEquals("Driving forward works", Saab.getYCoordinate(), 0.725, 5);
    }
    @Test
    public void DrivingBackwards(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.move();
        assertEquals("Driving backwards works", Saab.getYCoordinate(), -0.725, 5);
    }
    @Test
    public void DrivingToTheRight(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.move();
        assertEquals("Driving right works", Saab.getXCoordinate(), 0.725, 5);
    }
    @Test
    public void DrivingToTheLeft(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnLeft();
        Saab.move();
        assertEquals("Driving left works", Saab.getXCoordinate(), -0.725, 5);
    }
    @Test
    public void BrakingWithoutTurboSaab(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.brake(0.5);
        assertEquals("Braking works", Saab.getCurrentSpeed(), 0, 5);
    }
    @Test
    public void BrakingWithTurboSaab(){
        Saab.startEngine();
        Saab.setTurboOn();
        Saab.gas(0.5);
        Saab.brake(0.5);
        assertEquals("Breaking works with turbo", Saab.getCurrentSpeed(), 0, 5);
    }
    @Test
    public void TurningOffTheEngine(){
        Saab.startEngine();
        Saab.stopEngine();
        assertEquals("Turning off the engine works", Saab.getCurrentSpeed(), 0, 5);
    }
    @Test
    public void TurningOffTheTurboSaab(){
        Saab.setTurboOn();
        Saab.setTurboOff();
        Saab.gas(0.5);
        assertEquals("Turning off the turbo works", Saab.getCurrentSpeed(), 0.725, 5);
    }
}
