# JDBC Lab

In this first lab, we will be dealing with information from an existing database: it´s the database called northbrick.mdb, which can be found in this repository. 
You can use the following basic example and modify it so that you don't to start programming from scratch. 

```
import java.sql.*;
class basicJDBC {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection connection = DriverManager.getConnection("jdbc:odbc:northbrick");
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("Select * from Shippers");
        
        while(result.next()) {
            System.out.print(  result.getString("CompanyName")+", ");
            System.out.println(result.getString("Phone"));
        }
        
        
        connection.close();
    }
}
````
## Exercise 1: Getting information from a database
Develop a program that connects with northbrick database and shows the information contained in Employees table. You should write their LastName, FirstName and the City where they are from. 

Note: This excercise uses a Data Selection Query, meaning it requests rows from the database that fulfill certain requirements; in other words, it uses SQL sentences of the type SELECT.
This process has to be done with the executeQuery(String sql) method of the class Statement, which returns an object of the type ResultSet with the rows that fulfill the specific conditions of the SQL sentence. This ResultSet object is then iterated row by row to obtain the desired values.

## Exercise 2 Updating query
Develop a program that connects with northbrick database and updates the information of one specific employee. Specifically, we would like to change the city where one specific employee (EmployeeID=2) lives. You can choose any city name you want. 

Example: Update Employees SET City='Madrid' WHERE EmployeeID=2;

Now, in this second type of query exercise we are going to develop Data Upgrading Queries, which are queries that allow us to insert, modify and delete rows on a table of the Data Base with the following types SQL sentences: INSERT INTO, UPDATE or DELETE.
In this case we will be introducing the executeUpdate(String sql) method of the class Statement. This specific method doesn’t have any returning object of the class ResultSet, instead it returns an Integer number which corresponds to the number of rows that were modified
with the executed SQL sentence; if the SQL sentence doesn’t modify any rows the returning value will be 0.

## Exercise 3 Updating query using parameters
Based on the code developed in the previous exercise, develop a program that takes two String arguments from the command line: the employee id and the city you want to change, and updates the database with that information.  
You should check that the number of the arguments you receive after executing the file is 2, otherwise you should return the following message: 'Not enough parameters in the call'.

Example: java filename EmployeeID City
```
         java basicJDBCUpdate 3 Barcelona
```         
## Exercise 4 Exception handling (try and catch)

An Exception is an unwanted event that interrupts the normal flow of the program. When an exception occurs program execution gets terminated. In such cases we get a system generated error message. By handling the exceptions we can provide a meaningful message to the user about the issue rather than a system generated message, which may not be understandable to a user.

The ```try``` block contains set of statements where an exception can occur. A try block is always followed by a catch block, which handles the exception that occurs in associated try block. A try block must be followed by catch blocks or finally block or both.
A ```catch``` block is where you handle the exceptions, this block must follow a try block. A single try block can have several catch blocks associated with it. You can catch different exceptions in different catch blocks. When an exception occurs in try block, the corresponding catch block that handles that particular exception executes. For example if an arithmetic exception occurs in try block then the statements enclosed in catch block for arithmetic exception executes.
If an exception occurs in the try block then the control of execution is passed to the corresponding catch block. A single try block can have multiple catch blocks associated with it, you should place the catch blocks in such a way that the generic exception handler catch block is at the last.

To understand better the importance of handling exceptions, you should execute the following two files and see the differences. 
- [basicJDBC2.java](https://github.com/josuneha/JDBC/blob/master/files/basicJDBC2.java) 
- [basicJDBC3.java](https://github.com/josuneha/JDBC/blob/master/files/basicJDBC3.java) 

## Exercise 5 PreparedStatement: select example
Based on the example provided in [JDBCTutorial3](https://josuneha.github.io/JDBC/JDBCTutorial3) , modify it to select an order given a specific OrderId. 
For instance, show the CustomerID and OrderDate from the order OrderID= 10248

## Exercise 6 PreparedStatement: insert data from a file in the database 
The file [namesAndCities.txt](https://github.com/josuneha/JDBC/blob/master/files/namesAndCities.txt) contains information about employees that needs to be added to the database. Each row in the file contains the last name, first name and city. You should develop a program that reads this information from the file and inserts in the database using PreparedStatements. 

## Exercise 7: Review and test the files 
Review the following files [ProductData.java](https://github.com/josuneha/JDBC/blob/master/files/ProductData.java) and [ProductJavaTest.java](https://github.com/josuneha/JDBC/blob/master/files/ProductDataTest.java) to understand how they work and the results we get if we execute them using different parameters. 

