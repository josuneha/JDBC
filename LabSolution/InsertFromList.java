import java.io.*;
import java.util.*;
import java.sql.*;

public class InsertFromList{
	public static void main(String args[]){
		File f = new File("namesAndCities.txt");
		Scanner fileScanner;
		Connection con = null;
		PreparedStatement prSt = null;
		String query = "INSERT INTO Employees (LastName, FirstName, City) VALUES (?,?,?)";
		int totalUpdates = 0;
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:northbrick");
			
			prSt = con.prepareStatement(query);
			try{
				fileScanner = new Scanner(f);
				fileScanner.useDelimiter("\\r?\\n");
				while(fileScanner.hasNext()){
					Scanner lineScanner = new Scanner(fileScanner.next());
					lineScanner.useDelimiter("\t");
					
					String name = lineScanner.next();
					String lastname = lineScanner.next();
					String city = lineScanner.next();
					
					prSt.setString(1, lastname);
					prSt.setString(2, name);
					prSt.setString(3, city);
					
					int count = prSt.executeUpdate();
					totalUpdates+= count;
				}
				System.out.println("You have inserted: "+totalUpdates+" lines");
			}catch(FileNotFoundException e){
				System.out.println("The file you're trying to scan doesn't exist");
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
                if(prSt != null) prSt.close();
                if(con != null) con.close();
            } catch(Exception ex){}
		}	
	}
}