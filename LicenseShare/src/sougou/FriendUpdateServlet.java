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

@WebServlet("/FriendUpdateServlet")
public class FriendUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FriendUpdateServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		FriendBean friendBean = null;
		try{
			String userid = request.getParameter("userid");
			String friendid = request.getParameter("friendid");
			String check = request.getParameter("check");
			UserDAO dao = new UserDAO();
			OnlyDAO only = new OnlyDAO();
			friendBean = new FriendBean();
			friendBean.setUserid(userid);
			friendBean.setFriendid(friendid);
			friendBean.setCheck(check);
			if(only.getUserid(friendid).equals(friendid)){
				dao.updateFriend(friendBean);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
			}
		}
		catch(SystemException e){
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("Except", e);
			getServletContext().getRequestDispatcher("/parametererror.jsp").forward(request,response);
		}
		catch(DatabaseException e){
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("Except", e);
			getServletContext().getRequestDispatcher("/parametererror.jsp").forward(request,response);
		}
	}
}