import java.util.List;
import java.util.Scanner;

// Entry point for the JDBC Integration task. Console menu that uses
// EmployeeDAO to talk to the MySQL database.
public class JDBCApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        dao.createTable();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    insertEmployee(sc, dao);
                    break;
                case 2:
                    listEmployees(dao);
                    break;
                case 3:
                    updateEmployee(sc, dao);
                    break;
                case 4:
                    deleteEmployee(sc, dao);
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== JDBC Employee Records =====");
        System.out.println("1. Add employee");
        System.out.println("2. View all employees");
        System.out.println("3. Update employee");
        System.out.println("4. Delete employee");
        System.out.println("0. Exit");
    }

    private static void insertEmployee(Scanner sc, EmployeeDAO dao) {
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Department: ");
        String dept = sc.nextLine().trim();
        System.out.print("Salary: ");
        double salary;
        try {
            salary = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary. Record not added.");
            return;
        }

        Employee emp = new Employee(name, dept, salary);
        boolean success = dao.insertRecord(emp);
        System.out.println(success ? "Employee added." : "Failed to add employee.");
    }

    private static void listEmployees(EmployeeDAO dao) {
        List<Employee> employees = dao.getAllRecords();
        if (employees.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    private static void updateEmployee(Scanner sc, EmployeeDAO dao) {
        System.out.print("Employee ID to update: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return;
        }
        System.out.print("New department: ");
        String dept = sc.nextLine().trim();
        System.out.print("New salary: ");
        double salary;
        try {
            salary = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary.");
            return;
        }

        boolean success = dao.updateRecord(id, dept, salary);
        System.out.println(success ? "Employee updated." : "No employee found with that ID.");
    }

    private static void deleteEmployee(Scanner sc, EmployeeDAO dao) {
        System.out.print("Employee ID to delete: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return;
        }
        boolean success = dao.deleteRecord(id);
        System.out.println(success ? "Employee deleted." : "No employee found with that ID.");
    }
}
