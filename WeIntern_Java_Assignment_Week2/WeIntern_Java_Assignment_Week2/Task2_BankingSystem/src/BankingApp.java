import java.util.Scanner;

// Entry point for the Banking System. Console menu that talks to the Bank class.
public class BankingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
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

            try {
                switch (choice) {
                    case 1:
                        createAccount(sc, bank);
                        break;
                    case 2:
                        deposit(sc, bank);
                        break;
                    case 3:
                        withdraw(sc, bank);
                        break;
                    case 4:
                        transfer(sc, bank);
                        break;
                    case 5:
                        checkBalance(sc, bank);
                        break;
                    case 6:
                        printStatement(sc, bank);
                        break;
                    case 7:
                        bank.listAllAccounts();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (IllegalArgumentException | IllegalStateException | Bank.NoSuchAccountException e) {
                // catches invalid amounts, min-balance/overdraft violations, and unknown accounts
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== Banking System =====");
        System.out.println("1. Create account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check balance");
        System.out.println("6. Print statement");
        System.out.println("7. List all accounts");
        System.out.println("0. Exit");
    }

    private static void createAccount(Scanner sc, Bank bank) {
        System.out.print("Holder name: ");
        String name = sc.nextLine().trim();

        System.out.print("Account type (SAVINGS/CURRENT): ");
        String type = sc.nextLine().trim();

        System.out.print("Opening balance: ");
        double opening = Double.parseDouble(sc.nextLine().trim());

        String accNumber = bank.createAccount(name, type, opening);
        System.out.println("Account created successfully. Account number: " + accNumber);
    }

    private static void deposit(Scanner sc, Bank bank) {
        System.out.print("Account number: ");
        String acc = sc.nextLine().trim();
        System.out.print("Amount to deposit: ");
        double amount = Double.parseDouble(sc.nextLine().trim());
        bank.deposit(acc, amount);
        System.out.println("Deposit successful.");
    }

    private static void withdraw(Scanner sc, Bank bank) {
        System.out.print("Account number: ");
        String acc = sc.nextLine().trim();
        System.out.print("Amount to withdraw: ");
        double amount = Double.parseDouble(sc.nextLine().trim());
        bank.withdraw(acc, amount);
        System.out.println("Withdrawal successful.");
    }

    private static void transfer(Scanner sc, Bank bank) {
        System.out.print("From account: ");
        String from = sc.nextLine().trim();
        System.out.print("To account: ");
        String to = sc.nextLine().trim();
        System.out.print("Amount to transfer: ");
        double amount = Double.parseDouble(sc.nextLine().trim());
        bank.transfer(from, to, amount);
        System.out.println("Transfer successful.");
    }

    private static void checkBalance(Scanner sc, Bank bank) {
        System.out.print("Account number: ");
        String acc = sc.nextLine().trim();
        BankAccount account = bank.getAccount(acc);
        if (account == null) {
            throw new Bank.NoSuchAccountException("No account found with number: " + acc);
        }
        System.out.printf("Balance: %.2f%n", account.getBalance());
    }

    private static void printStatement(Scanner sc, Bank bank) {
        System.out.print("Account number: ");
        String acc = sc.nextLine().trim();
        BankAccount account = bank.getAccount(acc);
        if (account == null) {
            throw new Bank.NoSuchAccountException("No account found with number: " + acc);
        }
        account.getStatement();
    }
}
