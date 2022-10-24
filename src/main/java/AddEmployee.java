

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
		
		Employee employee = new Employee();
		employee.id = Integer.parseInt(request.getParameter("id"));
		employee.name = request.getParameter("name");
		employee.address = request.getParameter("address");
		employee.salary = Integer.parseInt(request.getParameter("salary"));
		employee.age = Integer.parseInt(request.getParameter("age"));
		
		
		// How to add that employee in dataBase???
		try {
			Database dbDatabase = new Database();
			dbDatabase.addEmployee(employee);
			
			response.sendRedirect("main.html");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			response.sendRedirect("error.html");
		}
		
		
	}

}
