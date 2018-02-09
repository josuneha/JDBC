import java.sql.*;

class basicJDBCUpdate2 {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
		Connection connection = DriverManager.getConnection("jdbc:odbc:northbrick");
        
		Statement statement = connection.createStatement();
		
		
		if (args.length == 2) {
			// get the arguments
			int employeeId = Integer.parseInt(args[0]);
			String cityName = args[1];
				
			// You should write the sql to check if there is a problem
			String sql="Update Employees SET City=' "+ cityName + "' WHERE EmployeeID=" + employeeId + ";";
					
			System.out.println("sqlUpdate: " + sql);
			
			int result = statement.executeUpdate(sql);
			
			System.out.println("filas modificadas: " + result);
		}
		else 
			System.out.println("Not enough arguments");
        
        connection.close();
    }
	
}