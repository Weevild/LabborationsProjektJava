import java.awt.*;

public class Car implements Movable {
        private final String[] directions = {"N", "E", "S", "W"};
        public int nrDoors; // Number of doors on the car
        public double enginePower; // Engine power of the car
        public double currentSpeed; // The current speed of the car
        public Color color; // Color of the car
        public String modelName; // The car model name
        public int direction; // The direction that the car is facing
        public double xCoordinate; // The x coordinate of the car
        public double yCoordinate; // The Y coordinate of the car
        private int getNrDoors(){
            return nrDoors;
        }
        private double getEnginePower(){
            return enginePower;
        }
        public double getCurrentSpeed(){
            return currentSpeed;
        }
        private Color getColor(){
            return color;
        }
        private String getDirection() {
            return directions[direction];
        }
        private double getxCoordinate(){
            return xCoordinate;
        }
        private double getyCoordinate(){
            return yCoordinate;
        }
        private void setColor(Color clr){
            color = clr;
        }
        public void startEngine(){
            currentSpeed = 0.1;
        }

        public void stopEngine(){
            currentSpeed = 0;
        }

        @Override
        public void move() { // använd enum för directions
            double speed = getCurrentSpeed();
            String currentDirection = getDirection();
            if (currentDirection.equals("N")){
                xCoordinate = getxCoordinate() + speed;
            }
            else if (currentDirection.equals("S")){
                xCoordinate = getxCoordinate() - speed;
            }
            else if (currentDirection.equals("E")){
                yCoordinate = getyCoordinate() + speed;
            }
            else if (currentDirection.equals("W")){
                yCoordinate = getyCoordinate() - speed;
            }
        }
        @Override
        public void turnLeft() {
            direction = (direction + 1) % 4;
        }
        @Override
        public void turnRight() {
            direction = (direction - 1) % 4;
        }
}