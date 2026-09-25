# Task 1 - Student Management System

A console-based Java application to manage student records (add, view, search,
update, delete, class average, and save/load to a file).

## Files
- `src/Student.java` - the Student model class
- `src/StudentManager.java` - handles all the CRUD logic and file I/O
- `src/StudentApp.java` - main class with the console menu

## How to Compile
Open a terminal inside the `src` folder and run:

```
javac *.java
```

## How to Run

```
java StudentApp
```

## How it Works
- Records are kept in an `ArrayList<Student>` while the program is running.
- Choosing option 7 (or exiting with 0) writes all records to `students_data.txt`
  in the same folder, in a simple pipe-separated format.
- The next time you run the app, it automatically loads any existing
  `students_data.txt` file so your data isn't lost between runs.
- IDs are auto-generated (highest existing ID + 1) so you don't have to
  track them manually.

## Sample Menu

```
===== Student Management System =====
1. Add student
2. Display all students
3. Search student (by ID or name)
4. Update student
5. Delete student
6. Calculate class average
7. Save data to file
0. Exit
```

## Notes
- Grades are simple letters (A/B/C/D/F) and are converted to points
  internally (A=90, B=80, C=70, D=60, F=50) just to calculate a class average.
- Update supports partial updates - you can leave grade or subjects blank
  to keep the existing value.
- Delete asks for a y/n confirmation before removing a record.
