package CarGUI;

import Car.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View via an observer and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements CarViewObserver {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 5;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getXCoordinate());
                int y = (int) Math.round(vehicle.getYCoordinate());
                frame.drawPanel.moveit(x, y, vehicle);
                frame.drawPanel.repaint();
            }
            carOutOfBounds();
        }

    }
    public Vehicle createRandomVehicle() {
        // Array of factory instances
        VehicleFactory[] factories = new VehicleFactory[] {
                new Volvo240Factory(),
                new Saab95Factory(),
                new ScaniaFactory()
        };

        Random random = new Random();

        // Select a random factory
        int randomIndex = random.nextInt(factories.length);
        VehicleFactory selectedFactory = factories[randomIndex];

        // Create a vehicle using the selected factory
        return selectedFactory.createVehicle();
    }

    public Vehicle createSpecifiedVehicle(String name) {
        String lowerCaseModelName = name.toLowerCase();
        switch(lowerCaseModelName) {
            case "volvo240":
                Volvo240Factory volvoFactory = new Volvo240Factory();
                return volvoFactory.createVehicle();

            case "saab95":
                Saab95Factory saabFactory = new Saab95Factory();
                return saabFactory.createVehicle();

            case "scania":
                ScaniaFactory scaniaFactory = new ScaniaFactory();
                return scaniaFactory.createVehicle();

            default:
                // Handle the case where the model name does not match
                return null;
        }
    }



    // Calls the gas method for each car once
    public void onGasButtonPressed(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void onBreakButtonPressed(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    public void onStartEngineButtonPressed() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    public void onStopEngineButtonPressed() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    public void onTurnLeftButtonPressed() {
        for (Vehicle vehicle : vehicles) {
            vehicle.turnLeft();
        }
    }

    public void onTurnRightButtonPressed() {
        for (Vehicle vehicle : vehicles) {
            vehicle.turnRight();
        }
    }

    public void onSetTurboOnButtonPressed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    public void onSetTurboOffButtonPressed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    public void onPlatformUpButtonPressed(double position) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).platformUp(position);
            }
        }
    }

    public void onPlatformDownButtonPressed(double position) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).platformDown(position);
            }
        }
    }

    public void onAddCarButtonPressed(String name){
        Vehicle newVehicle;
        if(vehicles.size() < 10) {
            if (name.isEmpty()) {
                newVehicle = createRandomVehicle();
            } else {
                newVehicle = createSpecifiedVehicle(name);
            }

            if (newVehicle != null) {
                vehicles.add(newVehicle);
                frame.drawPanel.moveit(0, 0, newVehicle); // Assuming new vehicles start at (0,0)
                frame.drawPanel.repaint(); // Refresh the view
            }
        }
    }

    public void onRemoveButtonPressed() {
        if (!vehicles.isEmpty()) {
            Vehicle vehicleToRemove = vehicles.remove(vehicles.size() - 1); // Remove last vehicle
            frame.drawPanel.vehiclePoints.remove(vehicleToRemove); // Remove from view
            frame.drawPanel.repaint(); // Refresh the view
        }
    }

    public void carOutOfBounds() {
        for (Vehicle vehicle : vehicles) {
            if (0 > vehicle.getXCoordinate() || CarView.getXBoundary() - 100 < vehicle.getXCoordinate()) {
                // Adjust car's X position to within boundaries
                double newX = Math.max(0, Math.min(vehicle.getXCoordinate(), CarView.getXBoundary() - 100));
                vehicle.setXCoordinate(newX);

                vehicle.stopEngine();
                if (vehicle.getDirection() == vehicle.getDirectionIndex(Vehicle.Direction.WEST)) {
                    vehicle.setDirection(Vehicle.Direction.EAST);
                } else if (vehicle.getDirection() == vehicle.getDirectionIndex(Vehicle.Direction.EAST)) {
                    vehicle.setDirection(Vehicle.Direction.WEST);
                }
                vehicle.startEngine();
            } else if (0 > vehicle.getYCoordinate() || CarView.getYBoundary() - 300 < vehicle.getYCoordinate()) {
                // Adjust car's Y position to within boundaries
                double newY = Math.max(0, Math.min(vehicle.getYCoordinate(), CarView.getYBoundary() - 300));
                vehicle.setYCoordinate(newY);

                vehicle.stopEngine();
                if (vehicle.getDirection() == vehicle.getDirectionIndex(Vehicle.Direction.NORTH)) {
                    vehicle.setDirection(Vehicle.Direction.SOUTH);
                } else if (vehicle.getDirection() == vehicle.getDirectionIndex(Vehicle.Direction.SOUTH)) {
                    vehicle.setDirection(Vehicle.Direction.NORTH);
                }
                vehicle.startEngine();
            }
        }
    }
}