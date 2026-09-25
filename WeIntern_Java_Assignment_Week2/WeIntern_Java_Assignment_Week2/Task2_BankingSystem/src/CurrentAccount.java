// Current account - no minimum balance, but allows a small overdraft.
public class CurrentAccount extends BankAccount {

    public static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accountNumber, String holderName, double openingBalance) {
        super(accountNumber, holderName, openingBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance - amount < -OVERDRAFT_LIMIT) {
            throw new IllegalStateException(
                    "Withdrawal denied: overdraft limit of " + OVERDRAFT_LIMIT + " exceeded.");
        }
        balance -= amount;
        logTransaction(new Transaction("WITHDRAW", amount));
    }

    @Override
    public String getAccountType() {
        return "CURRENT";
    }
}
