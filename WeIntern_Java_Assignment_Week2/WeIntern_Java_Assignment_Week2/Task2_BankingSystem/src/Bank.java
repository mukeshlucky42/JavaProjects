import java.util.HashMap;
import java.util.Map;

// Manages all the accounts in the bank. Accounts are stored in a HashMap
// keyed by account number so lookups are quick.
public class Bank {

    private Map<String, BankAccount> accounts;
    private int accountCounter;

    public Bank() {
        accounts = new HashMap<>();
        accountCounter = 1000; // account numbers start from ACC1001
    }

    public String createAccount(String holderName, String type, double openingBalance) {
        accountCounter++;
        String accNumber = "ACC" + accountCounter;

        BankAccount account;
        if (type.equalsIgnoreCase("SAVINGS")) {
            account = new SavingsAccount(accNumber, holderName, openingBalance);
        } else if (type.equalsIgnoreCase("CURRENT")) {
            account = new CurrentAccount(accNumber, holderName, openingBalance);
        } else {
            throw new IllegalArgumentException("Unknown account type: " + type);
        }

        accounts.put(accNumber, account);
        return accNumber;
    }

    public BankAccount getAccount(String accNumber) {
        return accounts.get(accNumber);
    }

    public void deposit(String accNumber, double amount) {
        BankAccount acc = requireAccount(accNumber);
        acc.deposit(amount);
    }

    public void withdraw(String accNumber, double amount) {
        BankAccount acc = requireAccount(accNumber);
        acc.withdraw(amount);
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        BankAccount from = requireAccount(fromAcc);
        BankAccount to = requireAccount(toAcc);

        // withdraw first - if it fails (insufficient funds), the deposit never happens
        from.withdraw(amount);
        to.deposit(amount);
    }

    private BankAccount requireAccount(String accNumber) {
        BankAccount acc = accounts.get(accNumber);
        if (acc == null) {
            throw new NoSuchAccountException("No account found with number: " + accNumber);
        }
        return acc;
    }

    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts created yet.");
            return;
        }
        System.out.printf("%-10s %-15s %-10s %-10s%n", "Acc No", "Holder", "Type", "Balance");
        for (BankAccount acc : accounts.values()) {
            System.out.printf("%-10s %-15s %-10s %-10.2f%n",
                    acc.getAccountNumber(), acc.getHolderName(), acc.getAccountType(), acc.getBalance());
        }
    }

    // Custom exception for a cleaner error message than a generic NPE.
    public static class NoSuchAccountException extends RuntimeException {
        public NoSuchAccountException(String message) {
            super(message);
        }
    }
}
