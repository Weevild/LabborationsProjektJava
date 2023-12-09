package CarGUI;

import Car.Saab95;
import Car.Scania;
import Car.Volvo240;

public class Main {
    public static void main(String[] args) {
        // Create instances of the controller and the view
        CarController controller = new CarController();
        CarView view = new CarView("CarSim 1.0");
        // Register the view as an observer to the controller
        view.addObserver(controller);

        // Add vehicles to the controller's list
        controller.vehicles.add(new Volvo240(0,0));
        controller.vehicles.add(new Saab95(0,100));
        controller.vehicles.add(new Scania(0,200));

        // Start the timer in the controller
        controller.timer.start();

        // Set the frame of the controller to be the view
        controller.frame = view;
    }
}
