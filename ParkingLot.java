import java.util.ArrayList;
import java.util.List;

/**
 * Class for parking lots and has to be called for most info
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

            for (int j = 3; j < slotsPerFlr; j++) {
                slots.get(i).add(new Slot("car"));
            }
        }
    }

    /**
     * Method to find closest slot, occupy it, and assign ticketId to slot
     * @param type 
     *      type of vehicle (truck, bike, car)
     * @param regNo
     *      registration number of vehicle
     * @param color
     *      color of vehicle
     */
    public String parkVehicle(String type, String regNo, String color) {

        Vehicle vehicle = new Vehicle(type, regNo, color);

        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.getType() == type && slot.getVehicle() == null) {
                    slot.setVehicle(vehicle);
                    slot.setTicketId(generateTicketId(i + 1, j + 1));
                    return slot.getTicketId();
                }
            }
        }

        System.out.println("No parking slot currently available for given type");
        return null;
    }

            
    /**
     * Method to generate ticket ID
     * @param flr 
     *      floor of parking slot
     * @param slno
     *      slot number of parking slot
     */
    private String generateTicketId(int flr, int slno) {
        return parkingLotId + "_" + flr + "_" + slno;
    }

    // Method to unpark vehicles and mark slot available again
    public void unPark(String ticketId) {
        String[] extract = ticketId.split("_");
        int flr_idx = Integer.parseInt(extract[1]) - 1;
        int slot_idx = Integer.parseInt(extract[2]) - 1;

        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                if (i == flr_idx && j == slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.setVehicle(null);
                    slot.setTicketId(null);
                    System.out.println("Unparked vehicle");
                }
            }
        }
    }

    // Display Options -----------------------------------------

    /**
     * Return the number of open slots for a vehicle type
     * @param type type of vehicle
     * @return number of open slots for a vehicle type
     */
    int getNoOfOpenSlots(String type) {
        int count = 0;
        for(List<Slot> floor: slots) {
            for (Slot slot: floor) {
                if (slot.getVehicle() == null && slot.getType().equals(type)) count++;
            }
        }

        return count;
    }

    /**
     * Display all the open slots for a vehicle type
     * @param type type of vehicle
     */
    void displayOpenSlots(String type) {
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.getVehicle() == null && slot.getType().equals(type))
                    System.out.println("Floor " + (i + 1) + " slot " + (j + 1));
            }
        }
    }

    /**
     * Display all occupied slots for a vehicle type
     * @param type type of vehicle
     */
    void displayOccupiedSlots(String type) {
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.getVehicle() != null && slot.getType().equals(type))
                    System.out.println("Floor " + (i + 1) + " slot " + (j + 1));
            }
        }
    }

}