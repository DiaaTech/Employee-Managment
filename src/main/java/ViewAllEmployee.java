

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/viewAll")
public class ViewAllEmployee extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Database dbDatabase = new Database();
		ArrayList<Employee> list = dbDatabase.getAllEmployees();
		
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>"
				+ "<html>"
				+ "	<head>"
				+ "  <title>All Employees</title>"
				+ "    <link rel=\"stylesheet\" href=\"viewEmployee.css\" />"
				+ "  </head>"
				+ "  <body>"
				+ "    <h1>Employee Managment</h1>"
				+ "    <div class=\"cards\">");
		
		
		for(int i = 0; i<list.size(); i++) {
		
				    out.print( "<div class=\"card\">");
				    out.print( "<h2>Name:"+ list.get(i).name+"</h2>");
				    out.print( "<h2>Age:"+ list.get(i).age+"</h2>");
				    out.print( "<h2>Employee Id:"+ list.get(i).id+"</h2>");
				    out.print( "<h2>Salary:"+ list.get(i).salary+"</h2>");
				    out.print( "<h2>Address:"+ list.get(i).address+"</h2>");
				    out.print("</div>\n");
			
		}
		
		out.print("</div>"
				+ "	</body>"
				+ "</html>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
