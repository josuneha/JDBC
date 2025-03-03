# JDBC: PreparedStatements


JDBC PreparedStatement can be used when you plan to use the same SQL statement many times. It is used to handle precompiled query. If we want to execute same query with different values for more than one time then precompiled queries will reduce the number of compilations, and it **runs faster**. 

**Connection.prepareStatement() **method can provide you PreparedStatment object. This object provides setXXX() methods to provide query values. 

The main feature of a PreparedStatement object is that, unlike a Statement object, it is given a SQL statement when it is created. The advantage to this is that in most cases, this SQL statement is sent to the DBMS (Data Base Management System) right away, where it is compiled. As a result, the PreparedStatement object contains not just a SQL statement, but a SQL statement that has been precompiled. This means that when the PreparedStatement is executed, the DBMS can just run the PreparedStatement SQL statement without having to compile it first.

Another important reason for using the PreparedStatements is that its use **avoids SQL injection**. SQL injection is a code injection technique, used to attack data-driven applications, in which nefarious SQL statements are inserted into an entry field for execution (e.g. to dump the database contents to the attacker). SQL injection must exploit a security vulnerability in an application's software, for example, when user input is either incorrectly filtered for string literal escape characters embedded in SQL statements or user input is not strongly typed and unexpectedly executed. SQL injection is mostly known as an attack vector for websites but can be used to attack any type of SQL database. See the following links from Wikipedia to see some examples:  [1](https://es.wikipedia.org/wiki/Inyecci%C3%B3n_SQL) and [2](https://en.wikipedia.org/wiki/SQL_injection)


The following are the steps you should follow to use PreparedStatements:

## Creating a PreparedStatement
We create the query passing parameter (?) for the values that can be changed. THe values for ? will be set by calling the setter methods of PreparedStatement.Then, the PreparedStatement object is created. 

```
String query = "Insert into Employees (LastName, FirstName, City) values(?,?, ?)";

PreparedStatement prSt = con.prepareStatement(query);

```

## Inserting Parameters into a PreparedStatement
Once a PreparedStatement is created (prepared) for the above SQL statement, you can insert parameters at the location of the question mark. This is done using the many setXXX() methods. The first number (1) is the index of the parameter to insert the value for. The second value ("Garcia") is the value to insert into the SQL statement.
Examples of setXXX() methods: **setString, setLong, setInt, setDate, setFloat, setDouble**

```
prSt.setString(1, "Garcia");
prSt.setString(2, "Ane");
prSt.setString(3, "Madrid");
```
## Executing the PreparedStatement
Executing the PreparedStatement looks like executing a regular Statement. To execute a query, call the executeQuery() or executeUpdate method. 

```
 int count = prSt.executeUpdate();
 ```
The executeUpdate() method is used when updating the database. It returns an int which tells how many records in the database were affected by the update.

## Reusing a PreparedStatement
Once a PreparedStatement is prepared, it can be reused after execution. You reuse a PreparedStatement by setting new values for the parameters and then execute it again. 

```
 //Run the same query with different values
  prSt.setString(1, "Lopez");
  prSt.setString(2, "Maria");
  prSt.setString(3, "Donostia");
			
  count = prSt.executeUpdate();
  ```
	  
Below an example to test the use of PreparedStatement:

```
 
import java.sql.*;

class MyPreparedStatements {
 
    public static void main(String a[]){
         
        Connection con = null;
        PreparedStatement prSt = null;
		
        try {
		    
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
            con = DriverManager.getConnection("jdbc:odbc:northbrick");
            
            
            String query = "Insert into Employees (LastName, FirstName, City) values(?,?, ?)";
            
	   // We prepare the query
	    prSt = con.prepareStatement(query);
			
	    prSt.setString(1, "Garcia");
            prSt.setString(2, "Ane");
            prSt.setString(3, "Madrid");
            
            //count will give you how many records got updated
            int count = prSt.executeUpdate();
            
            //Run the same query with different values
            prSt.setString(1, "Lopez");
            prSt.setString(2, "Maria");
            prSt.setString(3, "Donostia");
			
            count = prSt.executeUpdate();
            
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if(prSt != null) prSt.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }
}
```
