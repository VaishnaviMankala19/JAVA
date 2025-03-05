import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/UserDB";
    private static final String username = "root";
    private static final String password = "vaishu";

    public static Connection getConnection() throws SQLException {
        try {
            // Ensure JDBC Driver is loaded
        	Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found!", e);
        }
        return DriverManager.getConnection(URL, username, password);
    }
}
