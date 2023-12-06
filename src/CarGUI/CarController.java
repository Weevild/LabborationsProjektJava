package CarGUI;

import Car.Car;
import Car.Volvo240;
import Car.Saab95;
import Car.Scania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 5;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getXCoordinate());
                int y = (int) Math.round(car.getYCoordinate());
                frame.drawPanel.moveit(x, y, car);
                frame.drawPanel.repaint();
            }
            carOutOfBounds();
        }

    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    public void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    public void turnLeft() {
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    public void turnRight() {
        for (Car car : cars) {
            car.turnRight();
        }
    }

    public void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void platformUp(double position) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).platformUp(position);
            }
        }
    }

    public void platformDown(double position) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).platformDown(position);
            }
        }
    }


    public void carOutOfBounds() {
        for (Car car : cars) {
            if (0 > car.getXCoordinate() || CarView.getXBoundary() - 100 < car.getXCoordinate()) {
                // Adjust car's X position to within boundaries
                double newX = Math.max(0, Math.min(car.getXCoordinate(), CarView.getXBoundary() - 100));
                car.setXCoordinate(newX);

                car.stopEngine();
                if (car.getDirection() == car.getDirectionIndex(Car.Direction.WEST)) {
                    car.setDirection(Car.Direction.EAST);
                } else if (car.getDirection() == car.getDirectionIndex(Car.Direction.EAST)) {
                    car.setDirection(Car.Direction.WEST);
                }
                car.startEngine();
            } else if (0 > car.getYCoordinate() || CarView.getYBoundary() - 300 < car.getYCoordinate()) {
                // Adjust car's Y position to within boundaries
                double newY = Math.max(0, Math.min(car.getYCoordinate(), CarView.getYBoundary() - 300));
                car.setYCoordinate(newY);

                car.stopEngine();
                if (car.getDirection() == car.getDirectionIndex(Car.Direction.NORTH)) {
                    car.setDirection(Car.Direction.SOUTH);
                } else if (car.getDirection() == car.getDirectionIndex(Car.Direction.SOUTH)) {
                    car.setDirection(Car.Direction.NORTH);
                }
                car.startEngine();
            }
        }
    }
}