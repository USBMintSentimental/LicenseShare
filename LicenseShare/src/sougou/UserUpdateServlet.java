package sougou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.dao.OnlyDAO;
import sougou.dao.UserDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserUpdateServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UserBean user = null;
		try {
			OnlyDAO only = new OnlyDAO();
			String username = request.getParameter("username");
			String oldpasswd = request.getParameter("oldpasswd");
			String newpasswd1 = request.getParameter("newpasswd1");
			String newpasswd2 = request.getParameter("newpasswd2");
			String userid = request.getRemoteUser();
			if(only.getPassword(userid).equals(oldpasswd)){
				if(newpasswd1.equals(newpasswd2)){
					user = new UserBean();
					user.setUsername(username);
					user.setPasswd(newpasswd2);
					user.setUserid(userid);
					UserDAO dao = new UserDAO();
					dao.updateUser(user);
					getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				}else{
					String e = "入力しパスワードが正しくありません";
					HttpSession session = request.getSession();
					session.setAttribute("Except", e);
					getServletContext().getRequestDispatcher("/othererror.jsp").forward(request,response);
				}
			}
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