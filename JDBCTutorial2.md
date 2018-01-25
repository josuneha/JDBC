# JDBC with exception handling (try and catch)


An Exception is an unwanted event that interrupts the normal flow of the program. When an exception occurs program execution gets terminated. In such cases we get a system generated error message. By handling the exceptions we can provide a meaningful message to the user about the issue rather than a system generated message, which may not be understandable to a user.

A method catches an exception using a combination of the try and catch keywords: 
```
try {
   // Protected code
} catch (ExceptionName e1) {
   // Catch block
}
```
Another option can be: 
```
try {
   // Protected code
} catch (ExceptionName e1) {
   // Catch block
}finally {

}
```

The try block contains set of statements where an exception can occur. A try block is always followed by a catch block, which handles the exception that occurs in associated try block. A try block must be followed by catch blocks or finally block or both. 

A catch block is where you handle the exceptions, this block must follow a try block. A single try block can have several catch blocks associated with it. You can catch different exceptions in different catch blocks. When an exception occurs in try block, the corresponding catch block that handles that particular exception executes. For example if an arithmetic exception occurs in try block then the statements enclosed in catch block for arithmetic exception executes. If an exception occurs in the try block then the control of execution is passed to the corresponding catch block. A single try block can have multiple catch blocks associated with it, you should place the catch blocks in such a way that the generic exception handler catch block is at the last.

Optionally, a finally-clause can be attached to a try-catch block. The code inside the finally clause will always be executed, even if an exception is thrown from within the try or catch block. If your code has a return statement inside the try or catch block, the code inside the finally-block will get executed before returning from the method. 

## Example

```
import java.sql.*;
class testExceptions {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
        Connection connection;
		    
        try{
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		Connection connection = DriverManager.getConnection("jdbc:odbc:northbrick");

		Statement statement = connection.createStatement();

		// You should write the sql to check if there is a problem
		String sql="Select * from Employees WHERE EmployeeID='10'";
		System.out.println("sql: " + sql);
		
		 ResultSet result = statement.executeQuery(sql);

		 while(result.next()) {
			System.out.print(result.getString("LastName")+", ");
			System.out.println(result.getString("FirstName")+ " , ");
			System.out.println(result.getString("City"));
		 }

		 result.close();
		 statement.close();
			
		  connection.close();
			
        }
		
        // Catch any exceptions that are thrown.
        catch(ClassNotFoundException e) {
              System.out.println(e.toString());
        }
	catch(SQLException e) {
	      System.out.println(e.toString());
	}
        
    }
    
}

```
