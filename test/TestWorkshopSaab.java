import org.junit.Test;

import static org.junit.Assert.*;

public class TestWorkshopSaab {
    Saab95 Saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    public Workshop<Saab95> Workshop = new Workshop<>();
            ;
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
        assertTrue("Too many vehicles in Workshop", CarsInShop > Workshop.getVehicleLimit());
    }

    @Test
    public void NoVehiclesAvailableToRemove(){
        Workshop.storeVehicle(Saab);
        assertEquals("The workshop should have 1 vehicle", 1, Workshop.vehicles.size(), 5);

        Workshop.removeVehicle(Saab);
        assertEquals("The workshop should have 0 vehicles", 0, Workshop.vehicles.size());

        Workshop.removeVehicle(Saab);
        assertEquals("The workshop should still have 0 vehicles", 0, Workshop.vehicles.size());
    }

}
