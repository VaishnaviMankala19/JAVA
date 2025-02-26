import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudOperations {

    static Scanner scanner = new Scanner(System.in);
    static String currentDB = "Student"; 
    
    //create DB
    public static void createDB(){

        try{
            Connection con = DatabaseConfig.getConnection();
            System.out.println("Enter DataBase Name:");
            String db = scanner.nextLine();
            String createdb = "create database "+db;
            PreparedStatement st = con.prepareStatement(createdb);
            st.execute();
            System.out.println("DataBase created");
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    // show DB
    public static void showDB() {

        try{
            Connection con = DatabaseConfig.getConnection();
            System.out.println("Following are the Databases Available");
            String db = "show databases";
            PreparedStatement st = con.prepareStatement(db);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    //use db
    public static void useDB() {
        try {
            System.out.println("Enter database name to use:");
            String db = scanner.nextLine();
            currentDB = db;
            System.out.println("Using database: " + db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //create Table
    public static void createTable(){
    }


    public static void insertData() {
       
    }


    public static void displayData() {
       
    }


    public static void updateData() {
        
    }


    public static void deleteData() {
       
    }
}
