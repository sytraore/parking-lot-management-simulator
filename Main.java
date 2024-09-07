import java.util.Scanner;
import java.util.HashMap;

// ************         PRESS CONTROL + C TO END PROGRAM            **************************

/**
 * Parking Lot Management Simulator
 * 
 * @author Sy Traore and Byron Streit
 * @version 2024.09.06
 */
public class Main{

    // prompt users to enter vehicle type and color
    // tell users where to park if there is an open slot
    public static String parkVehicle(String vehicleRegist, ParkingLot parkingLot){
        String ticket = null;
        Scanner input = new Scanner(System.in);

        System.out.println("\nSelect type of vehicle:\n 1.Truck\n 2.Bike\n 3.Car\n");
        System.out.print("Enter 1 or 2 or 3.\t");

        String vehicleType= null;
        String vehicleColor= null;

        int option = input.nextInt();

        System.out.println();

        if ((int) option == 1){
            vehicleType = "Truck";
        }
        else if((int) option == 2){
            vehicleType = "Bike";
        }
        else if((int) option == 3){
            vehicleType = "Car";
        }
        
        if (parkingLot.openSlotsNumb(vehicleType) > 0){
            
            System.out.printf("Enter %s's color: \t",vehicleType);
            vehicleColor = input.next();
            System.out.println();
            ticket = parkingLot.parkVehicle(vehicleType, vehicleRegist, vehicleColor);
            
        }

        if (ticket != null){
            return ticket;
        }

        System.out.println("No more parking slot for " + vehicleType+"s");
        return null;
    }

    // update number of open slot after users unpark
    public static void unparkVehicle(String ticket, ParkingLot parkingLot){
       
        parkingLot.unPark(ticket);

    }

    public static void viewOpenSlot(ParkingLot parkingLot){
        Scanner input = new Scanner(System.in);
        System.out.println("Select type of vehicle:\n 1.Truck\n 2.Bike\n 3.Car");
        System.out.print("\nEnter 1 or 2 or 3.\t");
        String vehicleType= null;
       
        

        int option = input.nextInt();
        System.out.println();

        if ((int) option == 1){
            vehicleType = "Truck";
        }
        else if((int) option == 2){
            vehicleType = "Bike";
        }
        else if((int) option == 3){
            vehicleType = "Car";
        }
        
        if (parkingLot.openSlotsNumb(vehicleType) > 0){
           
            System.out.println();
            parkingLot.displayOpenSlotPositions(vehicleType);
        }
    }
    public static void main(String[] args){

        // ********* User Interface ****************

        // users is prompt to enter vehicle type
        // check if there is any open slot for vehicle type
        // if yes, prompt users to enter vehicle registration number and color
        // give parking ticket + location of slot
        // else, display a no more slot message

        // users can also unpark their vehicle
        // users will have to provide the registration number of the vehicle
        

        // users can view all open slots according to their vehicle type
        // users must enter their vehicle type

        
        // ************         PRESS CONTROL + C TO END PROGRAM            **************************


        ParkingLot univParkLot = new ParkingLot("PR1234", 2, 4);

        
        boolean statement = true;
        Scanner input = new Scanner(System.in);
        HashMap<String, String> registAndTicket = new HashMap<>();

        while (statement){
            //String choice = null;
            System.out.println("\n\t\tWelcome!");
            System.out.println("*************************************************************************************************");
            System.out.println("\n- The first slot on each floor is reserved for trucks.\n- The second and third slots on each floor are reserved for Bikes and any other 2 wheels engine.\n- Cars can be parked else where.\n");
            System.out.println("*************************************************************************************************");
            System.out.println(); 

            String ticket = null;
            
            System.out.println("1.Park\n2.Unpark\n3.View All Open Slots\n");
            System.out.print("Enter 1 or 2 or 3.\t");
            int select = input.nextInt();
            String vehicleRegist = null;

            System.out.println();

            // park vehicle if user input is 1
            if ((int) select == 1){
                System.out.print("Enter vehicle's registration: \t");
                vehicleRegist = input.next();
                
                ticket = parkVehicle(vehicleRegist,univParkLot);
                System.out.println("\nHave a nice day!");
                registAndTicket.put(vehicleRegist, ticket);
                
            }

            // unpark vehicle if user input is 2
            else if((int) select == 2){
                String vehicleTicket = null;
                System.out.print("Enter vehicle's registration: \t");
                vehicleRegist = input.next();
                System.out.println();
                for(String i: registAndTicket.keySet()){
                    if (i.equals(vehicleRegist)){
                        vehicleTicket = registAndTicket.get(i);
                    }
                }
                unparkVehicle(vehicleTicket,univParkLot);
                System.out.println("\nHave a nice day!");

            }

            // show all open slots for vehicle if user input is 3
            else if ((int) select == 3){
                viewOpenSlot(univParkLot);
            }

            // ************         PRESS CONTROL + C TO END PROGRAM            **************************
            
        }
        

        // ** Testing **

        // String [] vehicleType = {"truck", "bike", "car"};

        // System.out.println("Number of open slots for " + vehicleType[0] + ": " + test1.openSlotsNumb(vehicleType[0]));
        // System.out.println("Number of open slots for " + vehicleType[1] + ": " + test1.openSlotsNumb(vehicleType[1]));
        // System.out.println("Number of open slots for " + vehicleType[2] + ": " + test1.openSlotsNumb(vehicleType[2]) +"\n");

        // String truckTicket1 = test1.parkVehicle(vehicleType[0], "MH-03", "red");
        // String truckTicket2 = test1.parkVehicle(vehicleType[0], "MH-04", "purple");

        // String carTicket1 = test1.parkVehicle(vehicleType[2], "AA-88", "blue");
        // String carTicket2 = test1.parkVehicle(vehicleType[2], "AA-99", "orange");
        
        // String bikeTicket1 = test1.parkVehicle(vehicleType[1], "RR-11", "green");
        // String bikeTicket2 = test1.parkVehicle(vehicleType[1], "AA-22", "pink");

        // System.out.println();
        

        // // System.out.println("Ticket 1: "+ ticket1);
        // // System.out.println("Ticket 2: "+ ticket2);


        // System.out.println("Number of open slots for " + vehicleType[0] + ": " + test1.openSlotsNumb(vehicleType[0]));
        // System.out.println("Number of open slots for " + vehicleType[1] + ": " + test1.openSlotsNumb(vehicleType[1]));
        // System.out.println("Number of open slots for " + vehicleType[2] + ": " + test1.openSlotsNumb(vehicleType[2]) + "\n");

        
        // // display open slots position for vehicle of type truck
        // System.out.print(vehicleType[0]+"\n");
        // test1.displayOpenSlotPositions(vehicleType[0]);
        // System.out.println();
        // System.out.print(vehicleType[1]+"\n");
        // test1.displayOpenSlotPositions(vehicleType[1]);
        // System.out.println();
        // System.out.print(vehicleType[2]+"\n");
        // test1.displayOpenSlotPositions(vehicleType[2]);
        // System.out.println();

        
        // String truckTicket3 = test1.parkVehicle(vehicleType[0], "MA-66", "grey");
        // String bikeTicket3 = test1.parkVehicle(vehicleType[1], "AB-66", "grey");
        

        // test1.unPark(carTicket1);
        // String carTicket3 = test1.parkVehicle(vehicleType[2], "AA-66", "grey");
        // System.out.println("Number of open slots for " + vehicleType[2] + ": " + test1.openSlotsNumb(vehicleType[2]));


    }

}