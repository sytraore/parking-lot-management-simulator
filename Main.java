/**
 * Parking Lot Management Simulator
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */
public class Main{
    public static void main(String[] args){
        ParkingLot test1 = new ParkingLot("PR1234", 4, 6);

        System.out.println("Number of open slots for cars: " + test1.openSlotsNumb("car"));

        String ticket1 = test1.parkVehicle("car", "MH-03", "red");
        String ticket2 = test1.parkVehicle("car", "MH-04", "purple");

        System.out.println("Ticket 1: "+ ticket1);
        System.out.println("Ticket 2: "+ ticket2);

        
        
        
        

        // display open slots position for vehicle of type car
        // test1.displayOpenSlotPositions("car");

        // System.out.println("Number of open slots for cars: "+ test1.openSlotsNumb("car"));

        // test1.unPark(ticket2);

        // // display busy slots position for vehicle of type car
        // test1.displayBusySlotsPositions("car");

        // // display open slots position for vehicle of type truck
        // test1.displayOpenSlotPositions("truck");

        // test1.parkVehicle("truck", "MH-01", "black");

        // // display busy slots position for vehicle of type car
        // test1.displayBusySlotsPositions("truck");
    }

}