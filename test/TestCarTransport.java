import Car.CarTransport;
import Car.Saab95;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCarTransport {
    public CarTransport transporter = new CarTransport();
    public Saab95 saab = new Saab95();

    @Test
    public void TryToStoreTransporterOntoItself(){
        int initialSize = transporter.getAmountOfVehicle();
        transporter.storeVehicle(transporter);
        int finalSize = transporter.getStorage().size();

        assertEquals("Storing transporter onto itself should not increase the size of storage", initialSize, finalSize);
    }

    @Test
    public void StoredVehiclesShouldMoveWithTransporter(){
        transporter.storeVehicle(saab);
        transporter.startEngine();
        transporter.gas(0.5);
        assertEquals("Stored vehicle should move together with transporter", saab.getYCoordinate(), transporter.getYCoordinate(), 0.0);

    }

    @Test
    public void RemovingVehicleShouldPlaceItInProximityToTransporter(){
        transporter.storeVehicle(saab);
        transporter.removeVehicle();
        assertEquals("Stored vehicle should be placed within reasonable distance to the transporter", 5.0, saab.getYCoordinate(), 0.001);
    }
    @Test
    public void TryingToMoveStoredVehicleInTransport(){
        transporter.storeVehicle(saab);
        saab.startEngine();
        saab.gas(5);
        saab.move();
        assertEquals("Saab shouldn't have moved when stored", saab.getXCoordinate(), 0, 5);
    }

}
