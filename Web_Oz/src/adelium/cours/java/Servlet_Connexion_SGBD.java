package adelium.cours.java;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MaSuperServlet
 */
@WebServlet("/Servlet_Connexion_SGBD")
public class Servlet_Connexion_SGBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Connexion_SGBD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		ServletContext application = request.getServletContext();		
		application.setAttribute("Auteur", "ZIANI FAOUZI");
		
		HttpSession session = request.getSession();
		session.setAttribute("Societe", "ADELIUM-IT");
		
		
		PrintWriter out =    response.getWriter() ;
		out.append("<table>");
		out.append("<tr><th>Nom param</th><th>Valeur param</th>");
		
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()) 
        {
			String param = (String) params.nextElement();
			String valeur = request.getParameter(param);
			
			out.append("<tr><td>" + param+ "</td><td>" + valeur +"</td></tr>");
        }
        	
		out.append("</table>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
