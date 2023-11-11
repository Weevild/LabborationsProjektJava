package src;

import java.util.ArrayList;
import java.util.List;

public class WorkshopSaab extends Workshop<Saab95> {
    public WorkshopSaab(){
        this.specializedWorkshop = true;
        this.vehicleLimit = 8;
    }

}
