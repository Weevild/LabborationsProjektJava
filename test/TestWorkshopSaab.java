import Car.Saab95;
import Car.Workshop;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestWorkshopSaab {
    Saab95 Saab = new Saab95();

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

//    @Test
//    public void NoVehiclesAvailableToRemove(){
//        Workshop.storeVehicle(Saab);
//        assertEquals("The workshop should have 1 vehicle", 1, Workshop.getAmountOfVehicle(), 5);
//
//        Workshop.removeVehicle(Saab);
//        assertEquals("The workshop should have 0 vehicles", 0, Workshop.getAmountOfVehicle());
//
//        Workshop.removeVehicle(Saab);
//        assertEquals("The workshop should still have 0 vehicles", 0, Workshop.getAmountOfVehicle());
//    }
//}

//    @Test
//    public void NoVehiclesAvailableToRemove(){
//        Workshop.storeVehicle(Saab);
//        assertEquals("The workshop should have 1 vehicle", 1, Workshop.getAmountOfVehicle());
//
//        Saab95 removedSaab = Workshop.removeVehicle();
//        assertEquals("Removed vehicle should be the Saab instance", Saab, removedSaab);
//
//        int remainingVehiclesAfterFirstRemoval = Workshop.getAmountOfVehicle();
//        assertEquals("The workshop should have 0 vehicles", 0, remainingVehiclesAfterFirstRemoval);
//
//        Saab95 attemptToRemoveAgain = Workshop.removeVehicle();
//        assertNull("Trying to remove again should return null as there are no more vehicles", attemptToRemoveAgain);
//    }
}