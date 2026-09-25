import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Represents a single student record.
// Implements Serializable so we can save/load the list to a file.
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private String grade;
    private List<String> subjects;

    public Student(int id, String name, int age, String grade, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.subjects = (subjects != null) ? subjects : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    // Converts the grade letter into a rough numeric value so we can
    // calculate a class average. Simple mapping, nothing fancy.
    public double gradeToPoints() {
        switch (grade.toUpperCase()) {
            case "A": return 90;
            case "B": return 80;
            case "C": return 70;
            case "D": return 60;
            default: return 50;
        }
    }

    // Used when saving/loading from the plain text file.
    public String toFileLine() {
        return id + "|" + name + "|" + age + "|" + grade + "|" + String.join(",", subjects);
    }

    public static Student fromFileLine(String line) {
        String[] parts = line.split("\\|", -1);
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int age = Integer.parseInt(parts[2]);
        String grade = parts[3];
        List<String> subjects = new ArrayList<>();
        if (parts.length > 4 && !parts[4].isEmpty()) {
            for (String s : parts[4].split(",")) {
                subjects.add(s.trim());
            }
        }
        return new Student(id, name, age, grade, subjects);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", age=" + age +
                ", grade=" + grade + ", subjects=" + subjects + "}";
    }
}
