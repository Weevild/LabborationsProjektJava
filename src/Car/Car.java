package Car;

import java.awt.*;
public abstract class Car implements Movable {

    public Car(int nr, int power, double x, double y, boolean stored, String model){
        this.direction = 0;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.nrDoors = nr;
        this.isStored = stored;
        enginePower = power;
        modelName = model;
        stopEngine();
    }
        private final String[] directions = {"N", "E", "S", "W"}; // Direction is decided by using the indexes of the letters
        private int nrDoors; // Number of doors on the car
        protected double enginePower; // Engine power of the car
        private double currentSpeed; // The current speed of the car must be public
        protected Color color; // Color of the car
        private String modelName; // The car model name
        private boolean isStored;
        private int direction; // The direction that the car is facing
        private double xCoordinate; // The x coordinate of the car
        private double yCoordinate; // The Y coordinate of the car
        private boolean isCarRunning;

        private boolean isCarRunning() { return isCarRunning; }
        public boolean getisCarRunning(){ return this.isCarRunning; }
        public int getNrDoors(){
            return nrDoors;
        }
        public double getEnginePower(){
            return enginePower;
        }
        public double getCurrentSpeed(){
            return currentSpeed;
        }
        public Color getColor(){
            return color;
        }
        public String getModelName() {
        return modelName;
    }
        public String getDirection() {
            return directions[direction];
        }
        public double getXCoordinate(){
            return xCoordinate;
        }
        public double getYCoordinate(){
            return yCoordinate;
        }

        public boolean getIsStored() {return this.isStored;}
        public void setXCoordinate(double x) {this.xCoordinate = x;}
        public void setYCoordinate(double y) {this.yCoordinate = y;}

        protected void setIsStored(boolean stored) {this.isStored = stored;}

        public void setColor(Color clr){
            color = clr;
        }
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
            if (!getIsStored()) {
                double speed = getCurrentSpeed();
                String currentDirection = getDirection();
                if (currentDirection.equals("N")) {
                    yCoordinate = getYCoordinate() + speed;
                } else if (currentDirection.equals("S")) {
                    yCoordinate = getYCoordinate() - speed;
                } else if (currentDirection.equals("E")) {
                    xCoordinate = getYCoordinate() + speed;
                } else if (currentDirection.equals("W")) {
                    xCoordinate = getYCoordinate() - speed;
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
            if (amount > 0 && amount < 1 && getisCarRunning()){
                incrementSpeed(amount);
            }
        }
        public void brake(double amount){
            if (amount > 0 && amount < 1){
                decrementSpeed(amount);
            }
        }
}
