public class Vehicle {
    private String type, registration, color; 
    // type represents the type of vehicle (car, truck, bicyle)
    // registration represents the registraton number of the vehicle
    // color reprsents the color of the vehicle

    // default constructor
    // set default values
    public Vehicle(){
        this.type = "Type Unknown";
        this.registration = "No registration";
        this.color = "Color Unknown";
    }
    
    // customized contructor
     // set cstoized default values
    public Vehicle(String type, String registration, String color){
        this.type = type;
        this.registration = registration;
        this.color = color;
    }

    // change the type of the vehicle
    public void setType(String newType){
        type = newType;
    }

    // change the color of the vehicle
    public void setColor(String newColor){
        color = newColor;
    }

    // change the registration of the vehicle
    public void setRegistration(String newRegistration){
        registration = newRegistration;
    }

    // get the type of the vehicle
    public String getType(){
        return type;
    }

    // get the registration of the vehicle
    public String getRegistration(){
        return registration;
    }

    // get the color of the vehicle
    public String getColor(){
        return color;
    }
}
