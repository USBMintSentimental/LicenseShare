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

@WebServlet("/AdminUserUpdateServlet")
public class AdminUserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AdminUserUpdateServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UserBean user = null;
		try {
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String role = request.getParameter("role");
			user = new UserBean();
			user.setUserid(userid);
			user.setUsername(username);
			user.setPassword(passwd);
			user.setRole(role);
			UserDAO dao = new UserDAO();
			dao.updateUser(user);
			getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
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