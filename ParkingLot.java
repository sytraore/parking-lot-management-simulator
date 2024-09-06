import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String parkingLotId;
    private List<List<Slot>> slots;

    /**
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