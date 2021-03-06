package sougou;

import java.io.IOException;
import java.util.Date;

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

@WebServlet("/FriendInsertServlet")
public class FriendInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FriendInsertServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		FriendBean friendBean = null;
		try{
			String userid = request.getParameter("userid");
			String friendid = request.getParameter("friendid");
			String check = "null";
			UserDAO dao = new UserDAO();
			OnlyDAO only = new OnlyDAO();
			Date date = new Date();
			friendBean = new FriendBean();
			friendBean.setUserid(userid);
			friendBean.setFriendid(friendid);
			friendBean.setCheck(check);
			friendBean.setCreatedate(date);
			if((only.getCheck(userid,friendid).equals("comp"))||(only.getCheck(friendid,userid).equals("comp"))||(only.getCheck(userid,friendid).equals("null"))||(only.getCheck(friendid,userid).equals("null"))){
				String error = "既に登録されている、もしくは承認待ちです";
				HttpSession session = request.getSession();
				session.setAttribute("Error", error);
				getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
			}else if(only.getUserid(friendid).equals(friendid)){
				dao.insertFriend(friendBean);
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