import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object - all the JDBC/SQL code for the employees table
// lives here so the rest of the app doesn't need to know about SQL at all.
public class EmployeeDAO {

    // Creates the table if it doesn't already exist (schema.sql does this too,
    // this is here in case someone runs the app against a fresh database).
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "department VARCHAR(100) NOT NULL," +
                "salary DOUBLE NOT NULL)";

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table ready.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public boolean insertRecord(Employee emp) {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
            return false;
        }
    }

    public List<Employee> getAllRecords() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT id, name, department, salary FROM employees";

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
                employees.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching records: " + e.getMessage());
        }
        return employees;
    }

    public boolean updateRecord(int id, String newDepartment, double newSalary) {
        String sql = "UPDATE employees SET department = ?, salary = ? WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newDepartment);
            ps.setDouble(2, newSalary);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteRecord(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting record: " + e.getMessage());
            return false;
        }
    }
}
