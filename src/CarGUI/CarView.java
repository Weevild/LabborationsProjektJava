package CarGUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private static final int X = 1500;
    private static final int Y = 1500;

    public static int getXBoundary() { return X; }
    public static int getYBoundary() { return Y; }

    private List<CarViewObserver> observers = new ArrayList<>();

    public void addObserver(CarViewObserver observer) {
        observers.add(observer);
    }
    private void setupButtonListeners() {
        gasButton.addActionListener(e -> notifyGasButtonPress(gasAmount));
        brakeButton.addActionListener(e -> notifyBrakeButtonPress(brakeAmount));
        startButton.addActionListener(e -> notifyStartEngineButtonPressed());
        stopButton.addActionListener(e -> notifyStopEngineButtonPressed());
        turnLeftButton.addActionListener(e -> notifyTurnLeftButtonPressed());
        turnRightButton.addActionListener(e -> notifyTurnRightButtonPressed());
        turboOnButton.addActionListener(e -> notifySetTurboOnButtonPressed());
        turboOffButton.addActionListener(e -> notifySetTurboOffButtonPressed());
        liftBedButton.addActionListener(e -> notifyPlatformUpButtonPressed());
        lowerBedButton.addActionListener(e -> notifyPlatformDownButtonPressed());
    }
    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JPanel brakePanel = new JPanel();
    JSpinner brakeSpinner = new JSpinner();
    int brakeAmount = 0;
    JLabel brakeLabel = new JLabel("Amount of brake");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");

    JButton turnRightButton = new JButton("Turn right");
    JButton turnLeftButton = new JButton("Turn left");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename){
        initComponents(framename);
        setupButtonListeners();
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        brakeSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                brakeAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        brakePanel.setLayout(new BorderLayout());
        brakePanel.add(brakeLabel, BorderLayout.PAGE_START);
        brakePanel.add(brakeSpinner, BorderLayout.PAGE_END);

        this.add(controlPanel);

        controlPanel.setLayout(new GridLayout(2, 5));
        controlPanel.add(gasPanel, 0);
        controlPanel.add(gasButton, 1);
        controlPanel.add(turnLeftButton, 2);
        controlPanel.add(turboOnButton, 3);
        controlPanel.add(liftBedButton, 4);
        controlPanel.add(brakePanel, 5);
        controlPanel.add(brakeButton, 6);
        controlPanel.add(turnRightButton, 7);
        controlPanel.add(turboOffButton, 8);
        controlPanel.add(lowerBedButton, 9);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 100, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void notifyGasButtonPress(int gasAmount) {
        for (CarViewObserver observer : observers) {
            observer.onGasButtonPressed(gasAmount);
        }
    }

    private void notifyBrakeButtonPress(int brakeAmount) {
        for (CarViewObserver observer : observers) {
            observer.onBreakButtonPressed(brakeAmount);
        }
    }

    private void notifyStartEngineButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onStartEngineButtonPressed();
        }
    }

    private void notifyStopEngineButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onStopEngineButtonPressed();
        }
    }

    private void notifyTurnLeftButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onTurnLeftButtonPressed();
        }
    }

    private void notifyTurnRightButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onTurnRightButtonPressed();
        }
    }

    private void notifySetTurboOnButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onSetTurboOnButtonPressed();
        }
    }

    private void notifySetTurboOffButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onSetTurboOffButtonPressed();
        }
    }

    private void notifyPlatformUpButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onPlatformUpButtonPressed(70);
        }
    }

    private void notifyPlatformDownButtonPressed() {
        for (CarViewObserver observer : observers) {
            observer.onPlatformDownButtonPressed(70);
        }
    }
}