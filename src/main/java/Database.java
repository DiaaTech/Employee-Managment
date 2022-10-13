import java.sql.*;
import java.util.ArrayList;

public class Database {
	
	Connection con;			// Connection Object
	Statement st;			// Statement Object
	
	String url = "jdbc:mysql://localhost:3306/employeemanagment";
	
	// constructor | Make connection
	Database() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");			// Register Driver
		con = DriverManager.getConnection(url ,"root","851438"); // get Connection
		st = con.createStatement();					// get statement	
	}
	
	// function for checking the credentials
	boolean login(String name, String password) throws Exception {
		String queryString = "select * from login where name = ? and password = ?";
		
		PreparedStatement pr = con.prepareStatement(queryString);
		pr.setString(1, name);
		pr.setString(2, password);
		
		ResultSet rSet = pr.executeQuery();
		
		if(rSet.next()) {
			return true;
		}
		
		return false;
	}
	
	ArrayList<Employee> getAllEmployees() throws SQLException{
		ArrayList<Employee> list = new ArrayList<>();
		String query = "select * from employee";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			String address = rs.getNString(4);
			int salary = rs.getInt(5);
			
			Employee employee = new Employee(name, address, id, age, salary);
			list.add(employee);
		}
		return list;
		
	}
	
	// Deletion
	// Edit | Update Data
	// Insert New Employee
	
}
