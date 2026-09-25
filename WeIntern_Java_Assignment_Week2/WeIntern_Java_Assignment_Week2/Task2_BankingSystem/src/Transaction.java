import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Logs a single transaction (deposit, withdrawal, or transfer) on an account.
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private final LocalDateTime dateTime;
    private final String type;   // DEPOSIT, WITHDRAW, TRANSFER_IN, TRANSFER_OUT
    private final double amount;

    public Transaction(String type, double amount) {
        this.dateTime = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "[" + dateTime.format(FORMAT) + "] " + type + " : " + String.format("%.2f", amount);
    }
}
