import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "832854"; 

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            stmt.execute("CREATE DATABASE IF NOT EXISTS weintern_jdbc_task");
            stmt.execute("USE weintern_jdbc_task");
            stmt.execute("CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "department VARCHAR(100) NOT NULL," +
                    "salary DOUBLE NOT NULL)");

            System.out.println("Database and table created successfully!");
        }
    }
}