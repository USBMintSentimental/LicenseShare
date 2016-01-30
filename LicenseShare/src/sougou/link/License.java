package sougou.link;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.UserLicenseDataBean;
import sougou.dao.LicenseDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/License")
public class License extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public License() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLicenseDataBean userlicenseData;
		try {
            String licenseid = request.getParameter("id");
            LicenseDAO dao = new LicenseDAO();
            userlicenseData = dao.getUserLicenseData();
            HttpSession session = request.getSession();
            session.setAttribute("licenseid", licenseid);
            session.setAttribute("UserLicenseDataBean", userlicenseData);
            getServletContext().getRequestDispatcher("/license.jsp").forward(request, response);
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