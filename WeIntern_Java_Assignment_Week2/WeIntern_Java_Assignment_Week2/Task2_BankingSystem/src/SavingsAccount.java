// Savings account - must always keep a minimum balance of 1000.
public class SavingsAccount extends BankAccount {

    public static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber, String holderName, double openingBalance) {
        super(accountNumber, holderName, openingBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance - amount < MIN_BALANCE) {
            throw new IllegalStateException(
                    "Withdrawal denied: savings account must keep a minimum balance of " + MIN_BALANCE);
        }
        balance -= amount;
        logTransaction(new Transaction("WITHDRAW", amount));
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }
}
