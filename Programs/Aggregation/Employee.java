package Programs.Aggregation;

public class Employee {
    int id;
    String name;
    Address address;
    
    Employee(int id , String name , Address address){
        this.id=id;
        this.name=name;
        this.address=address;
    }

    void displayDetails(){
        System.out.println();
        System.out.println(id+" "+name);  
        System.out.println(address.city+" "+address.state+" "+address.country+" "+address.pincode);  
    }
    public static void main(String[] args) {  
        Address address1=new Address("gzb","UP","india",530027);  
        Address address2=new Address("gno","UP","india",530047);  
          
        Employee e1=new Employee(111,"varun",address1);  
        Employee e2=new Employee(112,"arun",address2);  
              
        e1.displayDetails();  
        e2.displayDetails();  
              
    }  
}  


