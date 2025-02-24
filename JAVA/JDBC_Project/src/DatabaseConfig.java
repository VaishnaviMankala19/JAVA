import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "jdbc";
    static final String USERNAME = "root";
    static final String PASSWORD = "vaishu";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL + DB_NAME, USERNAME, PASSWORD);
    }
}
