#JDBC in five minutes

This short tutorial provides an introduction to the JDBC interface for connecting Java programs with SQL-based databases, giving a sequence of steps to follow.
In this course, we will work with an Access database. 

# Step 1: Define a DNS (Domain Name System)

# Step 2: Import libraries 
In the Java file:
```
import java.sql.*;
```

# Step 3: Load the driver

```
Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
```

# Step 4: Obtain a Connection to the database
```
Connection connection = null;

String url="jdbc:odbc:northwind";	         
connection = DriverManager.getConnection(url); 
```
