import java.util.ArrayList;
import java.util.List;

/**
 * Class for parking lots
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */
public class ParkingLot {

    private String parkingLotId;
    private List<List<Slot>> slots;

    /**
     * Creates "slots" array list and finds number of slots per floor for specific parking lot
     * Then adds vehicle-specific slots up until the number of slots per floor
     * Then does the same for all floors within the parking lot
     * 
     * @param parkingLotId
     *      ID of the entire parking lot
     * @param nfloors
     *      number of floors
     * @param slotsPerFlr
     *      total number of slots per floor
     */
    public ParkingLot (String parkingLotId, int nfloors, int slotsPerFlr) {
        this.parkingLotId = parkingLotId;
        slots = new ArrayList<>();
        for (int i = 0; i < nfloors; i++) {
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("bike"));

            for (int j = 3, j < slotsPerFlr; j++) {
                slots.get(i).add(new Slot("car"));
            }
        }
    }

}