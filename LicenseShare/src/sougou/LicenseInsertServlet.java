package sougou;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sougou.dao.LicenseDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/LicenseInsertServlet")
public class LicenseInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LicenseInsertServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try{
			Date date = new Date();
			LicenseDAO dao = new LicenseDAO();
			LicenseBean licenseBean = new LicenseBean();
			String licenseid = request.getParameter("licenseid");
			String licensename = request.getParameter("licensename");
			String licensegroup = request.getParameter("licensegroup");
			int licenseprice = Integer.parseInt(request.getParameter("licenseprice"));
			licenseBean.setLicenseid(licenseid);
			licenseBean.setLicensename(licensename);
			licenseBean.setLicensegroup(licensegroup);
			licenseBean.setLicenseprice(licenseprice);
			licenseBean.setLicensecount(0);
			licenseBean.setLicensepass(0);
			licenseBean.setDatetime(date);
			dao.insertLicense(licenseBean);
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