import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CrudOperations {

    static Scanner scanner = new Scanner(System.in);
    static String currentDB = "jdbc";  

    // Create Database
    public static void createDB() {
        try {
            Connection con = DatabaseConfig.getConnection();
            System.out.println("Enter Database Name:");
            String db = scanner.nextLine();
            String createDBQuery = "CREATE DATABASE " + db;
            PreparedStatement st = con.prepareStatement(createDBQuery);
            st.execute();
            System.out.println("Database Created Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error Creating Database: " + e.getMessage());
        }
    }

    // Show Databases
    public static void showDB() {
        try {
            Connection con = DatabaseConfig.getConnection();
            System.out.println("Available Databases:");
            String showDBQuery = "SHOW DATABASES";
            PreparedStatement st = con.prepareStatement(showDBQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error Showing Databases: " + e.getMessage());
        }
    }

    // Use Database
    public static void useDB() {
        try {
            System.out.println("Enter Database Name to Use:");
            String db = scanner.nextLine();
            currentDB = db;
            System.out.println("Using Database: " + db);
        } catch (Exception e) {
            System.out.println("Error Using Database: " + e.getMessage());
        }
    }

    //delete db
    public static void deleteDB() {
        try {
            Connection con = DatabaseConfig.getConnection();
            System.out.println("Enter database name to delete:");
            String db = scanner.nextLine();
            
            String deleteDbQuery = "DROP DATABASE " + db;
            PreparedStatement st = con.prepareStatement(deleteDbQuery);
            st.execute();
            
            System.out.println("Database '" + db + "' deleted successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error deleting database: " + e.getMessage());
        }
    }
    

    // Create Table
    public static void createTable() {
        try {
            Connection con = DatabaseConfig.getConnection(currentDB);
            System.out.println("Enter Query to Create a Table in " + currentDB + ":");
            String query = scanner.nextLine();
            PreparedStatement st = con.prepareStatement(query);
            st.execute();
            System.out.println("Table Created Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error Creating Table: " + e.getMessage());
        }
    }

    // Insert Data
    public static void insertData() {
        try {
            Connection con = DatabaseConfig.getConnection(currentDB);
            System.out.println("Enter Query to Insert Data into a Table in " + currentDB + ":");
            String query = scanner.nextLine();
            PreparedStatement st = con.prepareStatement(query);
            st.execute();
            System.out.println("Data Inserted Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error Inserting Data: " + e.getMessage());
        }
    }

    // Display Data
    public static void displayData() {
        try {
            Connection con = DatabaseConfig.getConnection(currentDB);
            System.out.println("Enter Table Name to Display Data:");
            String table = scanner.nextLine();
            String query = "SELECT * FROM " + table;
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error Displaying Data: " + e.getMessage());
        }
    }

    // Update Data
    public static void updateData() {
        try {
            Connection con = DatabaseConfig.getConnection(currentDB);
            System.out.println("Enter SQL Query to Update Data in " + currentDB + ":");
            String query = scanner.nextLine();
            PreparedStatement st = con.prepareStatement(query);
            int rowsUpdated = st.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error Updating Data: " + e.getMessage());
        }
    }

    // Delete Data
    public static void deleteData() {
        try {
            Connection con = DatabaseConfig.getConnection(currentDB);
            System.out.println("Enter SQL Query to Delete Data in " + currentDB + ":");
            String query = scanner.nextLine();
            PreparedStatement st = con.prepareStatement(query);
            int rowsDeleted = st.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Data: " + e.getMessage());
        }
    }
}
