package sougou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.dao.UserDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserInsertServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UserBean user = null;
		try {
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String role = "user";
			user = new UserBean();
			user.setUserid(userid);
			user.setUsername(username);
			user.setPasswd(passwd);
			user.setRole(role);
			UserDAO dao = new UserDAO();
			dao.insertUser(user);
			response.sendRedirect("/LicenseShare");
		}
		catch(SystemException e){
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("Except", e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
		}
		catch(DatabaseException e){
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("Except", e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
		}
	}
}