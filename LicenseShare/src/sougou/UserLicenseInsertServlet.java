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
import sougou.dao.OnlyDAO;
import sougou.exception.DatabaseException;
import sougou.exception.SystemException;

@WebServlet("/UserLicenseInsertServlet")
public class UserLicenseInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserLicenseInsertServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UserLicenseBean licenseBean = null;
		try {
			Date date = new Date();
			String licenseid = request.getParameter("licenseid");
			String userid = request.getRemoteUser();
			int licensecount = Integer.parseInt(request.getParameter("licensecount"));
			String licensecomment = request.getParameter("licensecomment");
			String licensepass = request.getParameter("licensepass");
			licenseBean = new UserLicenseBean();
			licenseBean.setLicenseid(licenseid);
			licenseBean.setUserid(userid);
			licenseBean.setLicensecount(licensecount);
			licenseBean.setLicensecomment(licensecomment);
			licenseBean.setLicensepass(licensepass);
			licenseBean.setDatetime(date);
			LicenseDAO dao = new LicenseDAO();
			OnlyDAO only = new OnlyDAO();
			dao.insertUserLicense(licenseBean);
			only.updateLicensecount(licenseid,licensecount);
			if(licensepass.equals("çáäi")){
				only.updateLicensepass(licenseid);
				only.updateUserpass(userid);
			}
			getServletContext().getRequestDispatcher("/addlicense.jsp").forward(request,response);
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