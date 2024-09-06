/**
 * Class for parking slots
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */

public class Slot(){
    
    private String type;
    private Vehicle vehicle;
    private String ticketId;

    public Slot(String type) {
        this.type = type;
        this.vehicle = null;
        this.ticketId = null;
    }

    // Getter for type of vehicle
    public String getType() {
        return type;
    }

    // Setteer for type of vehicle
    public String setType(String newType) {
        this.type = newType;
    }

    // Getter for vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Setter for vehilce
    public Vehilce setVehicle(Vehicle newVehicle) {
        this.vehicle = newVehicle;
    }

    // Getter for ticket ID
    public String getTicketId() {
        return ticketId;
    }

    //Setter for ticket ID
    public String setTicketId(String newTicketId) {
        this.ticketId = newTicketId;
    }
}