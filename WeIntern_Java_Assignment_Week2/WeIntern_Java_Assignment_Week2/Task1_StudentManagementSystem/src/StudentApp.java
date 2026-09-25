import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Entry point of the Student Management System.
// Just a console menu that calls into StudentManager.
public class StudentApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile();

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choiceInput = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(sc, manager);
                    break;
                case 2:
                    manager.displayAll();
                    break;
                case 3:
                    searchStudent(sc, manager);
                    break;
                case 4:
                    updateStudent(sc, manager);
                    break;
                case 5:
                    deleteStudent(sc, manager);
                    break;
                case 6:
                    System.out.printf("Class average: %.2f%n", manager.calculateAverage());
                    break;
                case 7:
                    manager.saveToFile();
                    break;
                case 0:
                    manager.saveToFile();
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
        System.out.println("===== Student Management System =====");
        System.out.println("1. Add student");
        System.out.println("2. Display all students");
        System.out.println("3. Search student (by ID or name)");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Calculate class average");
        System.out.println("7. Save data to file");
        System.out.println("0. Exit");
    }

    private static void addStudent(Scanner sc, StudentManager manager) {
        try {
            System.out.print("Name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine().trim());
            if (age <= 0 || age > 100) {
                System.out.println("Please enter a realistic age.");
                return;
            }

            System.out.print("Grade (A/B/C/D/F): ");
            String grade = sc.nextLine().trim().toUpperCase();

            System.out.print("Subjects (comma separated): ");
            String subjectLine = sc.nextLine().trim();
            List<String> subjects = new ArrayList<>();
            if (!subjectLine.isEmpty()) {
                for (String s : subjectLine.split(",")) {
                    subjects.add(s.trim());
                }
            }

            int id = manager.getNextId();
            Student student = new Student(id, name, age, grade, subjects);
            if (manager.addStudent(student)) {
                System.out.println("Student added with ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Student not added.");
        }
    }

    private static void searchStudent(Scanner sc, StudentManager manager) {
        System.out.print("Search by (1) ID or (2) Name? ");
        String option = sc.nextLine().trim();

        if (option.equals("1")) {
            System.out.print("Enter ID: ");
            try {
                int id = Integer.parseInt(sc.nextLine().trim());
                Student s = manager.findById(id);
                System.out.println(s != null ? s : "No student found with that ID.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID.");
            }
        } else if (option.equals("2")) {
            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();
            List<Student> matches = manager.findByName(name);
            if (matches.isEmpty()) {
                System.out.println("No student found with that name.");
            } else {
                matches.forEach(System.out::println);
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void updateStudent(Scanner sc, StudentManager manager) {
        System.out.print("Enter ID of student to update: ");
        try {
            int id = Integer.parseInt(sc.nextLine().trim());
            if (manager.findById(id) == null) {
                System.out.println("No student found with that ID.");
                return;
            }
            System.out.print("New grade (leave blank to keep current): ");
            String grade = sc.nextLine().trim();

            System.out.print("New subjects, comma separated (leave blank to keep current): ");
            String subjectLine = sc.nextLine().trim();
            List<String> subjects = null;
            if (!subjectLine.isEmpty()) {
                subjects = new ArrayList<>();
                for (String s : subjectLine.split(",")) {
                    subjects.add(s.trim());
                }
            }

            boolean updated = manager.updateStudent(id, grade.isEmpty() ? null : grade, subjects);
            System.out.println(updated ? "Student updated." : "Update failed.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private static void deleteStudent(Scanner sc, StudentManager manager) {
        System.out.print("Enter ID of student to delete: ");
        try {
            int id = Integer.parseInt(sc.nextLine().trim());
            Student s = manager.findById(id);
            if (s == null) {
                System.out.println("No student found with that ID.");
                return;
            }
            System.out.print("Are you sure you want to delete " + s.getName() + "? (y/n): ");
            String confirm = sc.nextLine().trim();
            if (confirm.equalsIgnoreCase("y")) {
                manager.deleteStudent(id);
                System.out.println("Student deleted.");
            } else {
                System.out.println("Delete cancelled.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }
}
