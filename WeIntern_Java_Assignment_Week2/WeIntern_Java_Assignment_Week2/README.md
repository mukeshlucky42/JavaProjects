# WeIntern Pvt Ltd - Java Development Internship
# Week 2 Assignment - Full Submission

This folder contains all three tasks from the Week 2 handbook:

| Task | Folder | Topic |
|------|--------|-------|
| 1 | Task1_StudentManagementSystem | Console app to manage student records |
| 2 | Task2_BankingSystem | Console banking simulation (savings/current accounts) |
| 3 | Task3_JDBCIntegration | Java + MySQL CRUD app using JDBC |

Each task folder has its own `README.md` with compile/run instructions
specific to that task - start there.

## General order to follow

1. Read `Task1_StudentManagementSystem/README.md`, compile and run it, take
   screenshots of the console showing add/search/update/delete/average.
2. Read `Task2_BankingSystem/README.md`, compile and run it, take
   screenshots showing account creation, deposit, withdraw, transfer, and
   a printed statement.
3. Read `Task3_JDBCIntegration/README.md`:
   - install MySQL if you don't already have it
   - run `sql/schema.sql` in MySQL Workbench
   - add the JDBC driver jar to your classpath
   - edit `DatabaseConnection.java` with your own DB password
   - compile and run, then verify the data in MySQL Workbench

## Submission checklist (from the handbook)

- [ ] Java source code (.java) for all 3 tasks, organized in packages/folders
- [ ] SQL schema file (Task 3)
- [ ] Screenshots of the console for each task showing all operations
- [ ] Screenshot of MySQL Workbench showing table data (Task 3)
- [ ] One README per task with compile/run instructions (included)
- [ ] UML class diagrams for Task 1 and Task 2 (see notes below)
- [ ] Everything uploaded to the assigned Google Drive folder before the
      end-of-Week-2 deadline

## About the UML diagrams
The handbook asks for a class diagram for Task 1 and Task 2. These are best
drawn by hand or with a free tool (draw.io / diagrams.net, or even a photo of
a hand-drawn diagram) since they're meant to show that you understand your
own class relationships. Based on the code here:

- **Task 1**: `StudentApp` -> uses -> `StudentManager` -> manages a list of -> `Student`
- **Task 2**: `BankAccount` (abstract) <- extended by <- `SavingsAccount`, `CurrentAccount`;
  `Bank` manages a map of `BankAccount`; `BankAccount` has a list of `Transaction`
