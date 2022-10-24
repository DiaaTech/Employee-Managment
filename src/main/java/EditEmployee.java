

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		try {
			Database dbDatabase = new Database();
			dbDatabase.updateEmployee(id, name, address, age, salary);
			

			response.sendRedirect("main.html");
		}
		catch(Exception e) {
			
		}
	}

	

}
