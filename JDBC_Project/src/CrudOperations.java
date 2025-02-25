import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudOperations {

    static Scanner scanner = new Scanner(System.in);

    // Create Record
    public static void insertUser() {
        try (Connection con = DatabaseConfig.getConnection()) {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Email: ");
            String email = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();

            String insertSQL = "INSERT INTO user (username, emailid, password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertSQL);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read Records
    public static void fetchUsers() {
        try (Connection con = DatabaseConfig.getConnection()) {
            String querySQL = "SELECT * FROM user";
            PreparedStatement pstmt = con.prepareStatement(querySQL);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("\nUser Records:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Username: " + rs.getString("username") +
                        ", Email: " + rs.getString("emailid") +
                        ", Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Record
    public static void updateUser() {
        try (Connection con = DatabaseConfig.getConnection()) {
            System.out.print("Enter User ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Enter new Password: ");
            String newPassword = scanner.next();

            String updateSQL = "UPDATE user SET password = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(updateSQL);
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Record
    public static void deleteUser() {
        try (Connection con = DatabaseConfig.getConnection()) {
            System.out.print("Enter User ID to delete: ");
            int id = scanner.nextInt();

            String deleteSQL = "DELETE FROM user WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteSQL);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
