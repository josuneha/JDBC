import java.sql.*;
class basicJDBCHacked2 {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        Connection connection = DriverManager.getConnection("jdbc:odbc:northbrick");
        
      
        ResultSet result=null;
		
        
       
			
			//if (args.length==1)
			//{
				//int employeeID=Integer.parseInt(args[0]);
				String name=args[0];
				System.out.println(name);
				
				// You should write the sql to check if there is a problem
				String sql="Select * from Employees WHERE FirstName=?";
				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, name);
				System.out.println("sql: " + sql);
				result = pstmt.executeQuery();
				
				
				while(result.next()) {
					System.out.print(result.getString("LastName")+", ");
					System.out.println(result.getString("FirstName")+ " , ");
					System.out.println(result.getString("City"));
				}
            
              result.close();
			//}
            pstmt.close();
       
        
        connection.close();
    }
    
}