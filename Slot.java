/**
 * Class for parking slots
 * 
 * @author Sy Traore
 * @author Byron Streit
 * @version 2024.09.06
 */

public class Slot{
    
    private String typeOfSlot;        // typeOfSlot represents the typeOfSlot of vehicle for a slot
    private Vehicle vehicle;    
    private String ticketId;

    public Slot(String typeOfSlot){
        this.typeOfSlot = typeOfSlot;
        vehicle = null;
        ticketId = null;
    }


    // Getter of slot's type
    public String getTypeOfSlot() {
        return typeOfSlot;
    }

    // Setter for slot's type
    public void setTypeOfSlot(String newTypeOfSlot){
     typeOfSlot = newTypeOfSlot;
    }

    // Getter for vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Setter for vehilce
    public void setVehicle(Vehicle newVehicle) {
        this.vehicle = newVehicle;
    }

    // Getter for ticket ID
    public String getTicketId() {
        return ticketId;
    }

    //Setter for ticket ID
    public void setTicketId(String newTicketId) {
        this.ticketId = newTicketId;
    }
}