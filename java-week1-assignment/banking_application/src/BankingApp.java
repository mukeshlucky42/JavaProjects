
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {

    private BankAccount account;
    private Scanner sc;

    public BankingApp(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Banking Application =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        sc.close();
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: ");
        try {
            double amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Deposit amount must be greater than zero.");
                return;
            }
            account.deposit(amount);
            System.out.println("Deposit successful.");
            System.out.printf("Current Balance: %.2f%n", account.getBalance());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            sc.nextLine();
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter withdrawal amount: ");
        try {
            double amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be greater than zero.");
                return;
            }
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println("Withdrawal successful.");
                System.out.printf("Current Balance: %.2f%n", account.getBalance());
            } else {
                System.out.println("Insufficient funds. Withdrawal not allowed.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            sc.nextLine();
        }
    }

    private void showBalance() {
        System.out.printf("Current Balance: %.2f%n", account.getBalance());
    }
}
