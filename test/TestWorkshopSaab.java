import Car.Saab95;
import Car.Workshop;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestWorkshopSaab {
    Saab95 Saab = new Saab95(0,0);

    public Workshop<Saab95> Workshop = new Workshop<Saab95>();

    /*
    @Test
    public void TryToStoreWrongModelInWorkshop(){
        Workshop.storeVehicle(Volvo);
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

    @Test
    public void NoVehiclesAvailableToRemove(){
        Workshop.setVehicleLimit(8);
        Workshop.storeVehicle(Saab);
        assertEquals("The workshop should have 1 vehicle", 1, Workshop.getAmountOfVehicle());

        Workshop.removeVehicle(Saab);
        int remainingVehiclesAfterFirstRemoval = Workshop.getAmountOfVehicle();
        assertEquals("The workshop should have 0 vehicles", 0, remainingVehiclesAfterFirstRemoval);

        Workshop.removeVehicle(Saab);
        assertEquals("Trying to remove again shouldn't do anything as there are no more vehicles", 0, Workshop.getAmountOfVehicle());
    }
}