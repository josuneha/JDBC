# JDBC: PreparedStatements


JDBC PreparedStatement can be used when you plan to use the same SQL statement many times. It is used to handle precompiled query. If we want to execute same query with different values for more than one time then precompiled queries will reduce the number of compilations. Connection.prepareStatement() method can provide you PreparedStatment object. This object provides setXXX() methods to provide query values. 

Below example shows how to use PreparedStatement.

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
