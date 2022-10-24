

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			Database dbDatabase = new Database();
			boolean status = dbDatabase.login(userName, password);
			if(status) {
				HttpSession session = request.getSession(true);
				session.setAttribute("login", "true");
				response.sendRedirect("main.html");
			}
			else {
				response.sendRedirect("error.html");		// it takes user at other page/servlet
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
