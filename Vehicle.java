public class Vehicle {
    private String type, registration, color;

    public Vehicle(){
        this.type = "Type Unknown";
        this.registration = "No registration";
        this.color = "Color Unknown";
    }
    public Vehicle(String type, String registration, String color){
        this.type = type;
        this.registration = registration;
        this.color = color;
    }

    public void setType(String newType){
        type = newType;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public void setRegistration(String newRegistration){
        registration = newRegistration;
    }

    public String getType(){
        return type;
    }

    public String getRegistration(){
        return registration;
    }

    public String getColor(){
        return color;
    }
}
