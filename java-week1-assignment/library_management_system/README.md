# Library Management System

## Objective
A console-based Java application to manage books in a library. This was built as part of the Week 1 Java Development Internship assignment to practice class design, object relationships, menu handling, and organized application flow.

## Features Implemented
- Add a new book
- View all books
- Search for a book by ID or title
- Issue a book
- Return a book
- Remove a book
- Exit the application

## Technologies Used
- Java (JDK 8 or above)
- Java Collections (ArrayList)

## File Structure
```
library_management_system/
├── src/
│   ├── Book.java
│   ├── Library.java
│   └── Main.java
└── README.md
```

## Class Responsibilities
| Class | Responsibility |
|---|---|
| Book | Stores book details such as ID, title, author, and availability |
| Library | Manages the collection of books and library operations |
| Main | Runs the application menu and user flow |

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
===== Library Management System =====
1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Remove Book
7. Exit
Enter your choice: 1
Enter Book ID: 201
Enter Title: Clean Code in Java
Enter Author: Robert Martin
Book added successfully.

Enter your choice: 4
Enter Book ID to issue: 201
Book issued successfully.
```

## Author
Yakkali Mukesh
Java Development Intern, WeIntern Pvt Ltd
