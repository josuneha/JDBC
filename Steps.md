
# JDBC in five minutes

This short tutorial provides an introduction to the JDBC interface for connecting Java programs with SQL-based databases, giving a sequence of steps to follow.
In this course, we will work with an Access database. 

## Step 1: Define a DNS (Domain Name System)

## Step 2: Import libraries 
In the Java file:
```
import java.sql.*;
```

## Step 3: Load the driver

```
Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
```

## Step 4: Obtain a Connection to the database
```
Connection connection = null;

String url="jdbc:odbc:northwind";	         
connection = DriverManager.getConnection(url); 
```

## Step 5: Create a Statement object
```
Statement statement;
statement = connection.createStatement();
```

## Step 6: Execute a query using a Statement

The Statement interface defines 2 methods for executing SQL queries:
1) public ResultSet executeQuery(String sql)
 returns a ResultSet that includes all rows and columns which match the SELECT query
 
 ```
ResultSet resultSet;
String query = "SELECT * FROM Authors";
resultSet = stmt.executeQuery( query );

```
 
2) public int executeUpdate(String sql)
executeUpdate returns the number of rows changed by the update statement. This is used for insert statements, update statements and delete statements

```
String deleteStr = “DELETE FROM Authors WHERE LastName=‘Follet’";
int delnum = stmt.executeUpdate(deleteStr);
```



## Step 7: Execute a query using a Statement



