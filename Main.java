/**
 * Parking Lot Management Simulator
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */
public class Main{
    public static void main(String[] args){
        ParkingLot test1 = new ParkingLot("PR1234", 4, 6);

        System.out.println("No of open slots for cars: "+ test1.getNoOfOpenSlots("car"));

        String ticket1 = test1.parkVehicle("car", "MH-03", "red");
        String ticket2 = test1.parkVehicle("car", "MH-04", "purple");

        test1.displayOccupiedSlots("car");

        test1.unPark(ticket2);
        test1.displayOccupiedSlots("car");

        test1.displayOpenSlots("truck");
        test1.parkVehicle("truck", "MH-01", "black");
        test1.displayOccupiedSlots("truck");
    }

}