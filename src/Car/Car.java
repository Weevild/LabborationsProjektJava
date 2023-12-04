package Car;

import java.awt.*;
public abstract class Car implements Movable {

    public Car(int nr, int power, double x, double y, boolean stored, String model){
        this.direction = getDirectionIndex(Direction.SOUTH);
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.nrDoors = nr;
        this.isStored = stored;
        enginePower = power;
        modelName = model;
        stopEngine();
    }
    public enum Direction{
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    Direction[] directions = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    public int getDirectionIndex(Direction direction) {
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == direction) {
                return i;
            }
        }
        return -1; // Return -1 or throw an exception if the direction is not found
    }
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    private String modelName; // The car model name
    private boolean isStored;
    public int getDirection(){
        return this.direction;
    }
    public void setDirection(Direction direction){
        this.direction = getDirectionIndex(direction);
    }
    private int direction; // The direction that the car is facing
    private double xCoordinate; // The x coordinate of the car
    private double yCoordinate; // The Y coordinate of the car
    private boolean isCarRunning;
    public boolean isCarRunning(){ return this.isCarRunning; }
    public int getNrDoors(){ return nrDoors; }
    public double getEnginePower(){ return enginePower; }
    public double getCurrentSpeed(){ return currentSpeed; }
    public Color getColor(){ return color; }
    public String getModelName() { return modelName;}
    public double getXCoordinate(){ return xCoordinate;}
    public double getYCoordinate(){ return yCoordinate;}
    public boolean isStored() {return this.isStored;}
    public void setXCoordinate(double x) {this.xCoordinate = x;}
    public void setYCoordinate(double y) {this.yCoordinate = y;}
    protected void setIsStored(boolean stored) {this.isStored = stored;}
    public void setColor(Color clr){ color = clr;}
    public void startEngine(){
            currentSpeed = 0.1;
            this.isCarRunning = true;
    }
    public void stopEngine(){
            currentSpeed = 0;
            this.isCarRunning = false;
    }
    @Override
    public void move() {
        if (!isStored()) {
            double speed = getCurrentSpeed();
            if (getDirection() == getDirectionIndex(Direction.NORTH)) {
                yCoordinate = getYCoordinate() - speed;
            } else if (getDirection() == getDirectionIndex(Direction.SOUTH)) {
                yCoordinate = getYCoordinate() + speed;
            } else if (getDirection() == getDirectionIndex(Direction.EAST)) {
                xCoordinate = getXCoordinate() - speed;
            } else if (getDirection() == getDirectionIndex(Direction.WEST)) {
                xCoordinate = getXCoordinate() + speed;
            }
        }
    }
    @Override
    public void turnLeft() {
            direction = (direction + 1) % 4;
    }
    @Override
    public void turnRight() {
            direction = (direction + 3 ) % 4;
    }
    public double speedFactor(){
            return enginePower * 0.01;
    }
    protected void incrementSpeed(double amount){
        double newSpeed  = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        if (newSpeed > getCurrentSpeed()) {
            currentSpeed = newSpeed;
        }
    }
        protected void decrementSpeed(double amount){
            double newSpeed  = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
            if (newSpeed <= getCurrentSpeed()) {
                currentSpeed = newSpeed;
            }
        }

        public void gas(double amount){
            if (amount > 0 && amount < 1 && isCarRunning()){
                incrementSpeed(amount);
            }
        }
        public void brake(double amount){
            if (amount > 0 && amount < 1){
                decrementSpeed(amount);
            }
        }
}
