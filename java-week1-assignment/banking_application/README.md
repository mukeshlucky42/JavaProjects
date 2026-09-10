# Banking Application

## Objective
A console-based Java application that simulates basic bank account operations. This was built as part of the Week 1 Java Development Internship assignment to practice class design, method implementation, validation logic, and exception handling.

## Features Implemented
- Deposit
- Withdraw
- Balance Inquiry
- Exit
- Handling of invalid numeric input, negative values, and overdraw attempts

## Technologies Used
- Java (JDK 8 or above)
- Exception handling using `try-catch` (InputMismatchException)

## File Structure
```
banking_application/
├── src/
│   ├── BankAccount.java
│   ├── BankingApp.java
│   └── Main.java
└── README.md
```

## Class Responsibilities
| Class | Responsibility |
|---|---|
| BankAccount | Stores balance and performs account operations |
| BankingApp | Handles menu logic and user interaction |
| Main | Starts the application |

## Steps to Compile and Run
1. Open a terminal inside the `src` folder.
2. Compile all files:
   ```
   javac *.java
   ```
3. Run the application:
   ```
   java Main
   ```

## Sample Input and Output
```
===== Banking Application =====
1. Deposit
2. Withdraw
3. Balance Inquiry
4. Exit
Enter your choice: 1
Enter deposit amount: 5000
Deposit successful.
Current Balance: 5000.00

Enter your choice: 2
Enter withdrawal amount: 8000
Insufficient funds. Withdrawal not allowed.
```

## Author
Yakkali Mukesh
Java Development Intern, WeIntern Pvt Ltd
