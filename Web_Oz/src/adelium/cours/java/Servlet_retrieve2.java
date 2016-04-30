package adelium.cours.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_retrieve
 */
@WebServlet("/Servlet_retrieve2")
public class Servlet_retrieve2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_retrieve2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		// ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();
		Enumeration<String> params = request.getParameterNames();
		String email = "";
		String login = "";
		while (params.hasMoreElements()) {

			String param = (String) params.nextElement();
			if (param.equals("Emaill")) {
				email = request.getParameter(param);

			}

			if (param.equals("Identifiantt")) {
				login = request.getParameter(param);
			}
		}
		out.append("login:" + login + "/email:" + email + "/");

		Utilisateur client1 = null;
		try {

			client1 = new DAO_Utilisateur().RetrieveByEmail(email, login);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (client1 != null) {
			// response.setStatus(0);
			out.append("Found");
			session.setAttribute("email", email);
			session.setAttribute("login", login);
		} else {// response.setStatus(0);
			out.append("NotFound");
			session.setAttribute("email", null);
			session.setAttribute("login", null);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
