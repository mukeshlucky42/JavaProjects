import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Java Collections Challenge =====");
            System.out.println("1. ArrayList Challenge");
            System.out.println("2. HashMap Challenge");
            System.out.println("3. Queue Challenge");
            System.out.println("4. Run All");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    ArrayListChallenge.run();
                    break;
                case 2:
                    HashMapChallenge.run();
                    break;
                case 3:
                    QueueChallenge.run();
                    break;
                case 4:
                    ArrayListChallenge.run();
                    HashMapChallenge.run();
                    QueueChallenge.run();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        sc.close();
    }
}
