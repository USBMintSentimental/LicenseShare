package sougou.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.UserDataBean;
import sougou.dao.UserDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/PassRankingServlet")
public class PassRankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PassRankingServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDataBean userData;
		try {
			UserDAO dao = new UserDAO();
			userData = dao.getUserData();
			HttpSession session = request.getSession();
			session.setAttribute("UserDataBean", userData);
			getServletContext().getRequestDispatcher("/passranking.jsp").forward(request, response);
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
