package sougou.link;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/License")
public class License extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public License() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            String licenseid = request.getParameter("id");
            HttpSession session = request.getSession();
            session.setAttribute("licenseid", licenseid);
            getServletContext().getRequestDispatcher("/license.jsp").forward(request, response);
        }
        finally{
        	
        }

	}
}