import Car.Saab95;
import Car.Volvo240;
import Car.Workshop;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestWorkshopSaab {
    Saab95 Saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    public Workshop<Saab95> Workshop = new Workshop<Saab95>();
    /*
    @Test
    public void TryToStoreWrongModelInWorkshop(){
        WorkshopSaab.storeVehicle(Volvo);
        // Gives compile time error
    }
    */
    @Test
    public void TooManyVehiclesInWorkshop(){
        int CarsInShop = 0;
        for(int i = 1; i <= 9; i++){
            Workshop.storeVehicle(Saab);
            CarsInShop++;
        }
        assertTrue("Too many vehicles in Car.Workshop", CarsInShop > Workshop.getVehicleLimit());
    }

    @Test
    public void NoVehiclesAvailableToRemove(){
        Workshop.storeVehicle(Saab);
        assertEquals("The workshop should have 1 vehicle", 1, Workshop.getStorage().size(), 5);

        Workshop.removeVehicle(Saab);
        assertEquals("The workshop should have 0 vehicles", 0, Workshop.getStorage().size());

        Workshop.removeVehicle(Saab);
        assertEquals("The workshop should still have 0 vehicles", 0, Workshop.getStorage().size());
    }

}
