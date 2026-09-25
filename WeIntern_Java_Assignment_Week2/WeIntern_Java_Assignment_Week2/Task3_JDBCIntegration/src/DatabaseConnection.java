import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Small helper class to open a connection to the MySQL database.
// Change the URL/USER/PASSWORD to match your own local MySQL setup.
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/weintern_jdbc_task";
    private static final String USER = "root";
    private static final String PASSWORD = "832854";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
