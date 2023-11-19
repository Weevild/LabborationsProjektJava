import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class TestCarTransport {
    public CarTransport transporter = new CarTransport();
    public Saab95 saab = new Saab95();

    @Test
    public void TryToStoreTransporterOntoItself(){
        int initialSize = transporter.getStorage().size();
        transporter.storeVehicle(transporter);
        int finalSize = transporter.getStorage().size();

        assertEquals("Storing transporter onto itself should not increase the size of storage", initialSize, finalSize);
    }

    @Test
    public void StoredVehiclesShouldMoveWithTransporter(){
        transporter.storeVehicle(saab);
        transporter.startEngine();
        transporter.gas(0.5);
        assertEquals("Driving forward works", saab.getYCoordinate(), transporter.getYCoordinate(), 0.0);

    }

    @Test
    public void RemovingVehicleShouldPlaceItInProximityToTransporter(){
        transporter.storeVehicle(saab);
        transporter.removeLastVehicle();
        assertEquals("Stored vehicle should be placed within reasonable distance to the transporter", 5.0, saab.getYCoordinate(), 0.001);
    }

}
