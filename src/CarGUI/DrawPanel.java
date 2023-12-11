package CarGUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Car.*;
import java.util.HashMap;
import java.util.Map;
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a single cars position
    Map<Vehicle, Point> vehiclePoints = new HashMap<>();

    void moveit(int x, int y, Vehicle vehicle) {
        vehiclePoints.put(vehicle, new Point(x, y));
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Map.Entry<Vehicle, Point> entry : vehiclePoints.entrySet()) {
            Vehicle v = entry.getKey();
            Point p = entry.getValue();
            if (v instanceof Volvo240) {
                g.drawImage(volvoImage, p.x, p.y, null);
            } else if (v instanceof Saab95) {
                g.drawImage(saabImage, p.x, p.y, null);
            } else if (v instanceof Scania) {
                g.drawImage(scaniaImage, p.x, p.y, null);
            }
            // Add more else if blocks for other vehicle types
        }
    }
}
