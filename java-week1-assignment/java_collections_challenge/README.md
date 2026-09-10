# Java Collections Challenge

## Objective
A set of small console programs to practice the most commonly used Java collections: ArrayList, HashMap, and Queue. This was built as part of the Week 1 Java Development Internship assignment.

## Features Implemented
- ArrayList: add, remove, update, search, and iterate over a list of book titles
- HashMap: insert, retrieve, update, check key existence, and iterate over student roll number and name pairs
- Queue: add, remove, peek, and display a FIFO queue of customer tokens

## Technologies Used
- Java (JDK 8 or above)
- java.util.ArrayList
- java.util.HashMap
- java.util.Queue / java.util.LinkedList

## File Structure
```
java_collections_challenge/
├── src/
│   ├── ArrayListChallenge.java
│   ├── HashMapChallenge.java
│   ├── QueueChallenge.java
│   └── Main.java
└── README.md
```

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

## Sample Output
```
--- ArrayList Challenge (Book Titles) ---
After adding books: [Java Basics, OOP in Practice, Data Structures]
After updating index 1: [Java Basics, OOP Concepts, Data Structures]
Data Structures found at index 2
After removing Java Basics: [OOP Concepts, Data Structures]
Final book list:
- OOP Concepts
- Data Structures

--- HashMap Challenge (Student Marks) ---
Student map: {101=Amit, 102=Neha, 103=Rahul}
Student with roll 102: Neha
After updating roll 101: {101=Amit Kumar, 102=Neha, 103=Rahul}
Roll 105 does not exist.
All students:
Roll 101 -> Amit Kumar
Roll 102 -> Neha
Roll 103 -> Rahul

--- Queue Challenge (Customer Tokens) ---
Queue after adding customers: [Customer1, Customer2, Customer3]
Next customer to be served: Customer1
Served: Customer1
Queue after serving one customer: [Customer2, Customer3]
```

## Author
Yakkali Mukesh
Java Development Intern, WeIntern Pvt Ltd
