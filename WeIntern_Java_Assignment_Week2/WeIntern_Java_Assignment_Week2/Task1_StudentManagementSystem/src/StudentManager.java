import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Handles all the CRUD operations for Student records.
// Keeps the list in memory (ArrayList) and can save/load it to a text file.
public class StudentManager {

    private List<Student> students;
    private static final String DATA_FILE = "students_data.txt";

    public StudentManager() {
        students = new ArrayList<>();
    }

    // ---------- CREATE ----------
    public boolean addStudent(Student student) {
        // don't allow duplicate IDs
        if (findById(student.getId()) != null) {
            System.out.println("A student with ID " + student.getId() + " already exists.");
            return false;
        }
        students.add(student);
        return true;
    }

    // ---------- READ ----------
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.printf("%-5s %-20s %-5s %-8s %-30s%n", "ID", "Name", "Age", "Grade", "Subjects");
        System.out.println("---------------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-5d %-20s %-5d %-8s %-30s%n",
                    s.getId(), s.getName(), s.getAge(), s.getGrade(), String.join(", ", s.getSubjects()));
        }
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public List<Student> findByName(String name) {
        List<Student> matches = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                matches.add(s);
            }
        }
        return matches;
    }

    // ---------- UPDATE ----------
    // Pass null / -1 for any field you don't want to change (partial update).
    public boolean updateStudent(int id, String newGrade, List<String> newSubjects) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        if (newGrade != null && !newGrade.trim().isEmpty()) {
            s.setGrade(newGrade);
        }
        if (newSubjects != null && !newSubjects.isEmpty()) {
            s.setSubjects(newSubjects);
        }
        return true;
    }

    // ---------- DELETE ----------
    public boolean deleteStudent(int id) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }

    // ---------- CLASS AVERAGE ----------
    public double calculateAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Student s : students) {
            total += s.gradeToPoints();
        }
        return total / students.size();
    }

    // ---------- FILE PERSISTENCE (plain text) ----------
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Student s : students) {
                writer.write(s.toFileLine());
                writer.newLine();
            }
            System.out.println("Data saved to " + DATA_FILE);
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return; // nothing to load yet, that's fine on first run
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            students.clear();
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    students.add(Student.fromFileLine(line));
                }
            }
            System.out.println("Loaded " + students.size() + " student record(s) from file.");
        } catch (IOException e) {
            System.out.println("Error while loading data: " + e.getMessage());
        }
    }

    public int getNextId() {
        int max = 0;
        for (Student s : students) {
            if (s.getId() > max) {
                max = s.getId();
            }
        }
        return max + 1;
    }
}
