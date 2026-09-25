# Task 3 - JDBC Integration

Connects a Java console app to a MySQL database and performs CRUD
operations on an `employees` table using the DAO pattern.

## Files
- `sql/schema.sql` - run this first in MySQL Workbench to create the database and table
- `src/DatabaseConnection.java` - opens the JDBC connection (edit your password here)
- `src/Employee.java` - simple model class matching the table columns
- `src/EmployeeDAO.java` - all the SQL/JDBC code (insert, select, update, delete)
- `src/JDBCApp.java` - main class with the console menu

## Setup

1. **Install MySQL** (8.x recommended) and make sure the server is running.
2. **Run the schema file** in MySQL Workbench (or `mysql -u root -p < schema.sql`):
   ```
   sql/schema.sql
   ```
   This creates the `weintern_jdbc_task` database and the `employees` table.
3. **Download the MySQL JDBC driver** (`mysql-connector-j`, the `.jar` file)
   from the official MySQL site, or add it as a Maven dependency:
   ```xml
   <dependency>
       <groupId>com.mysql</groupId>
       <artifactId>mysql-connector-j</artifactId>
       <version>8.3.0</version>
   </dependency>
   ```
4. **Edit `DatabaseConnection.java`** and set your own MySQL username and
   password (`USER` and `PASSWORD` constants).

## How to Compile (manual, without Maven)

```
cd src
javac -cp .:mysql-connector-j-8.3.0.jar *.java
```
(On Windows use `;` instead of `:` in the classpath.)

## How to Run

```
java -cp .:mysql-connector-j-8.3.0.jar JDBCApp
```

## How it Works
- `EmployeeDAO` uses `PreparedStatement` for every query (insert, update,
  delete) so user input is never concatenated directly into SQL - this
  prevents SQL injection.
- Every `Connection`, `Statement`, and `ResultSet` is opened inside a
  try-with-resources block, so they're automatically closed even if an
  exception happens.
- `SQLException`s are caught and printed with a clear message instead of
  crashing the whole application.
- After running any operation, open MySQL Workbench and run
  `SELECT * FROM employees;` to confirm the data matches what the app shows.
