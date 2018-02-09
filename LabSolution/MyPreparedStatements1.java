import java.sql.*;

class MyPreparedStatements1 {
 
    public static void main(String a[]){
         
        Connection con = null;
        PreparedStatement prSt = null;
		
        try {
		    
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:northbrick");
            
            String query="select CustomerID, OrderDate from Orders where OrderId= ?";
			
            //String query = "Insert into Employees (LastName, FirstName, City) values(?,?, ?)";
			System.out.println(query);
            
			// We prepare the query
			prSt = con.prepareStatement(query);
			
	        prSt.setInt(1, 10248);
           
            
            //result will give you how many records got select
            ResultSet result = prSt.executeQuery();
            
			while(result.next()) {
            System.out.print(result.getString("CustomerID")+" ");
            System.out.println(result.getString("OrderDate"));
			
        }
			
            //Run the same query with different values
            //
            
        } catch (ClassNotFoundException e){
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