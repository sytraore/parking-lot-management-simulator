import java.util.ArrayList;
import java.util.List;

/**
 * Class for parking lots and has to be called before use of most methods
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
            floorSlots.add(new Slot("Truck"));
            floorSlots.add(new Slot("Bike"));
            floorSlots.add(new Slot("Bike"));

            for (int j = 3; j < slotsPerFlr; j++) {
                slots.get(i).add(new Slot("Car"));
            }
        }
    }

    // set parking lot Id
    public void setparkingLotId(String newParkingLotId){
        parkingLotId = newParkingLotId;
    }

    // get parking lot Id
    public String getParkingLotId(){
        return parkingLotId;
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
    public String parkVehicle(String vehicleType, String vehicleRegis, String vehicleColor) {

        // vehicle that needs to be parked
        Vehicle vehicle = new Vehicle(vehicleType, vehicleRegis, vehicleColor);
        

        // go through all slots until an empty slot is found
        // first loop go through the ith floor
        // second loop represents the slots of the ith floor
        for (int i = 0; i < slots.size(); i++) {   

            for (int j = 0; j < slots.get(i).size(); j++) { 

                Slot slot = slots.get(i).get(j);

                // check if the vehicle type is allowed to be parked at the slot[i][j] and if the slot is free
                // if yes:
                // vehicle is parked at slot[i][j] and a ticket ID is generated
                // if no:
                // print unavailability message
                if (slot.getTypeOfSlot() == vehicleType && slot.getVehicle() == null) {    
                    slot.setVehicle(vehicle);

                    String generatedTicketId = generateTicketId(i + 1, j + 1);
                    slot.setTicketId(generatedTicketId);
                    System.out.println("** Park " + vehicleType + " at Floor "+ (i+1) + " slot number "+ (j+1)+" **");
                    return slot.getTicketId();
                    
                }
            }
        }

        
    
        System.out.println("No parking slots currently available for " + vehicleType + "s");
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

        // get the floor and slot number of the unparked vehicle from the ticket Id
        String[] extract = ticketId.split("_");
        int flr_idx = Integer.parseInt(extract[1]) - 1;
        int slot_idx = Integer.parseInt(extract[2]) - 1;

        // go through all slots until the floor and slot numbers correspond to the pointers i and j
        // first loop go through the ith floor
        // second loop represents the slots of the ith floor
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {

                // if the floor being at which i points at is the same as the floor number on the ticket ID
                // and
                // if the slot at which j points at is the same as the slot on the tickt ID
                // update the status of the slot: from busy to free
            
                if (i == flr_idx && j == slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    String type = slot.getVehicle().getType();
                    slot.setVehicle(null);
                    slot.setTicketId(null);
                    System.out.println("Unpark "+ type);
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
    public int openSlotsNumb(String type) {
        // track the number of open slots
        int count = 0;

        // go through all slots and count the number of open slots
        // first loop go through the ith floor
        // second loop go through the slots of the ith floor
        for(List<Slot> floor: slots) {
            for (Slot slot: floor) {

                // check if the slot is free from any vehicle and if the type of the slot is the same as the type of vehicle
                // if yes, increment count variable
                if (slot.getVehicle() == null && slot.getTypeOfSlot().equals(type)) count++;
            }
        }

        return count;
    }

    /**
     * Display all the open slots for a vehicle type
     * @param type type of vehicle
     */
    public void displayOpenSlotPositions(String type) {

        // go through all slots and print the position of open slots
        // first loop go through the ith floor
        // second loop go through the slots of the ith floor
        for (int i = 0; i < slots.size(); i++) {

            for (int j = 0; j < slots.get(i).size(); j++) {

                Slot slot = slots.get(i).get(j);

                // if slot is free and the type of the slot matches the type of the vehicle, display position of slot
                if (slot.getVehicle() == null && slot.getTypeOfSlot().equals(type)){
                    System.out.println("Open slot for "+ type+ "s at Floor " + (i + 1) + " slot number " + (j + 1));
                }
                // else{
                //     System.out.println("No Parking at Floor " + (i + 1) + " slot number " + (j + 1)); 
                // }
                    
            }
        }
    }

    /**
     * Display all occupied slots for a vehicle type
     * @param type type of vehicle
     */
    // public void displayBusySlotsPositions(String type) {
    //     // go through all slots and print the position of busy slots
    //     // first loop go through the ith floor
    //     // second loop go through the slots of the ith floor

    //     for (int i = 0; i < slots.size(); i++) {

    //         for (int j = 0; j < slots.get(i).size(); j++) {

    //             Slot slot = slots.get(i).get(j);
    //             // if slot is not free and the type of the slot matches the type of the vehicle, display position of slot
    //             if (slot.getVehicle() != null && slot.getTypeOfSlot().equals(type))
    //                 System.out.println("Busy slot at Floor " + (i + 1) + " slot number " + (j + 1));
    //         }
    //     }
    // }

}