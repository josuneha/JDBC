import java.sql.*;

class basicJDBCUpdate {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
		Connection connection = DriverManager.getConnection("jdbc:odbc:northbrick");
        
		Statement statement = connection.createStatement();
		
		// You should write the sql to check if there is a problem
		String sql="Update Employees SET City='Madrid' WHERE EmployeeID=2;";
				
		System.out.println("sqlUpdate: " + sql);
		
		int result = statement.executeUpdate(sql);
		
		System.out.println("filas modificadas: " + result);
        
        connection.close();
    }
	
}