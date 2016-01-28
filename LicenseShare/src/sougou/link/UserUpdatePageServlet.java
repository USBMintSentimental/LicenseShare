package sougou.link;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserUpdatePageServlet")
public class UserUpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserUpdatePageServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String userid = request.getParameter("userid");
			HttpSession session = request.getSession();
            session.setAttribute("userid", userid);
            getServletContext().getRequestDispatcher("/userupdate.jsp").forward(request, response);
		}
        finally{
        	
        }

	}
}