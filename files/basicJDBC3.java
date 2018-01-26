import java.sql.*;
class basicJDBC3 {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        Connection connection = DriverManager.getConnection("jdbc:odbc:northbrick");
        
        Statement statement = connection.createStatement();
        
        // You should write the sql to check if there is a problem
        String sql="Select * from Employees WHERE EmployeeID='10'";
        System.out.println("sql: " + sql);
        
        try{
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
                System.out.print(result.getString("LastName")+", ");
                System.out.println(result.getString("FirstName")+ " , ");
                System.out.println(result.getString("City"));
            }
            
            result.close();
            statement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error in getEmployee: " + sql + " Exception: " + e);
        }
        
        
        connection.close();
    }
    
}
