package Programs.Aggregation;

public class Address {
    String city;
    String state; 
    String country;
    int pincode;
    Address(String city,String state, String country,int pincode){
        this.city=city;
        this.country=country;
        this.pincode=pincode;
        this.state=state;
    }
}
