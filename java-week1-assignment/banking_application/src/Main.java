public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Default User", 0.0);
        BankingApp app = new BankingApp(account);
        app.start();
    }
}
