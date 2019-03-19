package admin;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		
		HttpSession session=request.getSession();
		
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		
		
		
		session.setAttribute("name",username);
		
		
		
		if (new AdminDao().login(username, password)) {
			
			response.sendRedirect(basePath+"jsp/backstage/main.jsp");
		}
		else {
			response.sendRedirect(basePath+"jsp/backstage/login.jsp");
		}
		
		
		
		
	}

}
