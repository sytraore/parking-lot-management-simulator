<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
/**
 * Class for entire parking lots
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */
>>>>>>> 81e49311401b727ca24faa3959f9e68f3f56f56b
public class ParkingLot {

    private String parkingLotId;
    private List<List<Slot>> slots;

    public ParkingLot (String parkingLotId, int nfloors, int noOfSlotsPerFlr) {
        this.parkingLotId = parkingLotId;
        slots = new ArrayList<>();
        for (int i = 0; i < nfloors; i++) {
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("bike"));

            for (int j = 3; j < noOfSlotsPerFlr; j++) {
                slots.get(i).add(new Slot("car"));
            }
        }
    }
    
}