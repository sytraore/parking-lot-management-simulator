/**
 * Parking Lot Management Simulator
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */
public class Main{
    public static void main(String[] args){
        
    }

    /**
     * Method to find closest slot, occupy it, and assign ticketId to slot
     * 
     * @param type 
     *      type of vehicle (truck, bike, car)
     * @param regNo
     *      registration number of vehicle
     * @param color
     *      color of vehicle
     */
    public String parkVehicle(String type, String regNo, String color) {
        
        /**
         * Method to generate ticket ID
         * 
         * @param flor 
         *      floor of parking slot
         * @param slno
         *      slot number of parking slot
         */
        private String generateTicketId(int flor, int slno) {
            return parkingLotId + "_" + flr + "_" + slno;
        }

        Vehicle vehicle = new Vehicle(type, regNo, color);

        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.type == type && slot.vehicle == null) {
                    slot.vehicle = vehicle;
                    slot.ticketId = generateTicketId(i + 1, j + 1);
                    return slot.ticketId;
                }
            }
        }

        System.out.println("No parking slot currently available for given type");
        return null;
    }

    // Method to unpark vehicles and mark slot available again
    public void unPark(String ticketId) {
        String[] extract = ticketId.split("_");
        int flr_idx = Integer.parseInt(extract[1]) - 1;
        int slot_idx = Integer.parseInt(extract[2]) - 1;

        for (int i = 0; i < slots.size(); i++) {
            for (int = j = 0; j < slots.get(i).size(); j++) {
                if (i == flr_idx && j == slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.vehicle = null;
                    slot.ticketId = null;
                    System.out.println("Unparked vehicle");
                }
            }
        }
    }

}