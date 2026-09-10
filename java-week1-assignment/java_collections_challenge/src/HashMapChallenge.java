import java.util.HashMap;
import java.util.Map;

public class HashMapChallenge {

    public static void run() {
        System.out.println("\n--- HashMap Challenge (Student Marks) ---");

        HashMap<Integer, String> students = new HashMap<>();

        // insert key-value pairs
        students.put(101, "Amit");
        students.put(102, "Neha");
        students.put(103, "Rahul");
        System.out.println("Student map: " + students);

        // retrieve a value using a key
        System.out.println("Student with roll 102: " + students.get(102));

        // update a value
        students.put(101, "Amit Kumar");
        System.out.println("After updating roll 101: " + students);

        // check whether a key exists
        int rollToCheck = 105;
        if (students.containsKey(rollToCheck)) {
            System.out.println("Roll " + rollToCheck + " exists.");
        } else {
            System.out.println("Roll " + rollToCheck + " does not exist.");
        }

        // iterate through entries
        System.out.println("All students:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Roll " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
