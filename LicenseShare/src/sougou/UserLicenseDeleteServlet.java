package sougou;

import java.io.IOException;

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

@WebServlet("/UserLicenseDeleteServlet")
public class UserLicenseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserLicenseDeleteServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		LicenseBean licenseBean = null;
		try {
			String licenseid = request.getParameter("licenseid");
			String userid = request.getParameter("userid");
			String licensepass = request.getParameter("licensepass");
			licenseBean = new LicenseBean();
			licenseBean.setLicenseid(licenseid);
			licenseBean.setUserid(userid);
			LicenseDAO dao = new LicenseDAO();
			OnlyDAO only = new OnlyDAO();
			dao.deleteUserLicense(licenseBean);
			if(licensepass.equals("合格")){
				only.deleteUserpass(userid);
			}
			getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
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