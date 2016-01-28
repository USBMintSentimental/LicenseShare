package sougou.link;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LicenseUpdatePageServlet")
public class LicenseUpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LicenseUpdatePageServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String licenseid = request.getParameter("licenseid");
			HttpSession session = request.getSession();
            session.setAttribute("licenseid", licenseid);
            getServletContext().getRequestDispatcher("/licenseupdate.jsp").forward(request, response);
		}
        finally{
        	
        }

	}
}