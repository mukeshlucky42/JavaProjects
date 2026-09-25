import java.util.ArrayList;
import java.util.List;

// Base class for all account types. Holds the common fields/behaviour
// (deposit, balance check, transaction history) and leaves withdraw()
// abstract because each account type enforces different rules.
public abstract class BankAccount {

    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected List<Transaction> history;

    public BankAccount(String accountNumber, String holderName, double openingBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = openingBalance;
        this.history = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposits are the same for every account type, so this lives here.
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        history.add(new Transaction("DEPOSIT", amount));
    }

    // Each subclass decides its own withdrawal rules (minimum balance,
    // overdraft limit, etc.), so this stays abstract.
    public abstract void withdraw(double amount);

    public void getStatement() {
        System.out.println("---- Statement for " + accountNumber + " (" + holderName + ") ----");
        System.out.printf("Current balance: %.2f%n", balance);
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : history) {
                System.out.println(t);
            }
        }
    }

    protected void logTransaction(Transaction t) {
        history.add(t);
    }

    public abstract String getAccountType();
}
