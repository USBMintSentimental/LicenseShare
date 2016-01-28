package sougou.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.LicenseDataBean;
import sougou.dao.LicenseDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/AddLicenseServlet")
public class AddLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddLicenseServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LicenseDataBean licenseData;
		try {
			LicenseDAO dao = new LicenseDAO();
			licenseData = dao.getLicenseData();
			HttpSession session = request.getSession();
			session.setAttribute("LicenseDataBean", licenseData);
			getServletContext().getRequestDispatcher("/addlicense.jsp").forward(request, response);
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
