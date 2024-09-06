public class Main{
    public static void main(String[] args){
        
    }

    public String parkVehicle(String type, String regNo, String color) {
        private String generateTicketId(int flor, int slots){
            return parkingLotId + " " + flr + " " + slots;
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

}