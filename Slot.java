/**
 * Class for parking slots
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */

public class Slot{
    
    private String type;
    private Vehicle vehicle;
    private String ticketId;

    public Slot(String type){
        this.type = type;
        vehicle = null;
        ticketId = null;
    }

    public Slot(String type, Vehicle vehicle, String ticketId) {
        this.type = type;
        this.vehicle = vehicle;
        this.ticketId = ticketId;
    }

    // Getter for type of slot
    public String getType() {
        return type;
    }

    // Setteer for type of vehicle
    public void setType(String newType){
        type = newType;
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