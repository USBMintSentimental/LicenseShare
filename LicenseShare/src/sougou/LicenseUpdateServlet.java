package sougou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.dao.LicenseDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/LicenseUpdateServlet")
public class LicenseUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LicenseUpdateServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		LicenseBean licenseBean = null;
		try {
			String licenseid = request.getParameter("licenseid");
			String licensename = request.getParameter("licensename");
			String licensegroup = request.getParameter("licensegroup");
			int licenseprice = Integer.parseInt(request.getParameter("licenseprice"));
			licenseBean = new LicenseBean();
			licenseBean.setLicenseid(licenseid);
			licenseBean.setLicensename(licensename);
			licenseBean.setLicensegroup(licensegroup);
			licenseBean.setLicenseprice(licenseprice);
			LicenseDAO dao = new LicenseDAO();
			dao.updateLicense(licenseBean);
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