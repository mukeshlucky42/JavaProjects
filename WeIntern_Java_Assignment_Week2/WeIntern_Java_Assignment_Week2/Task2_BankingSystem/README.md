# Task 2 - Banking System

A console-based Java banking simulation supporting Savings and Current
accounts, deposits, withdrawals, transfers, balance checks, and statements.

## Files
- `src/BankAccount.java` - abstract base class (common fields + deposit + statement)
- `src/SavingsAccount.java` - enforces a minimum balance of 1000
- `src/CurrentAccount.java` - allows overdraft up to 5000
- `src/Transaction.java` - logs each transaction with a timestamp
- `src/Bank.java` - manages all accounts in a HashMap, handles transfers
- `src/BankingApp.java` - main class with the console menu

## How to Compile

```
cd src
javac *.java
```

## How to Run

```
java BankingApp
```

## Business Rules
- **Savings account**: withdrawal is rejected if the balance would fall
  below 1000.
- **Current account**: withdrawal is rejected only if it would exceed
  the overdraft limit of 5000 (balance can go negative up to that limit).
- **Transfer**: internally calls withdraw() on the source account and
  deposit() on the destination account - if the withdrawal fails (e.g.
  insufficient funds), the deposit is never performed, so money can't be
  created or lost.
- **Insufficient funds / invalid account**: handled with exceptions
  (`IllegalStateException`, `IllegalArgumentException`, and a custom
  `Bank.NoSuchAccountException`) that are caught in `BankingApp` and
  shown as a friendly error message instead of crashing the program.

## Sample Menu

```
===== Banking System =====
1. Create account
2. Deposit
3. Withdraw
4. Transfer
5. Check balance
6. Print statement
7. List all accounts
0. Exit
```

## Notes
- Account numbers are auto-generated (ACC1001, ACC1002, ...).
- This is an in-memory simulation - accounts reset each time you restart
  the program (no file/database persistence was required for this task).
