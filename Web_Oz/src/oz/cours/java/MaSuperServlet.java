package oz.cours.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaSuperServlet
 */
@WebServlet("/MaSuperServlet")
public class MaSuperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaSuperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//1) retourner du html qui est généré en reponse
		
		// 1) response.setContentType("text/html");
		
	
		/*PrintWriter out = response.getWriter();
	out.append("Served at: ");
	out.append(request.getContextPath());
	out.append("<br/> Bonjoooour");
	
	// pour recuperer des parametre
	//on connait les parametre
	//retourne un string
	String nom = request.getParameter("txtNom");
	out.append ( " Nom : " +nom );*/
	// la ca naffiche pas car rien dans txtnom
	
	//retourne une enumeration
	//2)pour retourner un tableau a 2 colonne en html [nom, valeur]
	//2)
	response.setContentType("text/html");
	
	
	PrintWriter out = response.getWriter();
	//out.append("<table>") est la reponse HTML crée la balise table
	out.append("<table>");
	out.append("<tr><th>Nom param</th><th>Valeur param</th></tr>");
		//recuper un enum avec TOUS les noms passé en parametres en attributs
		Enumeration<String> params = request.getParameterNames();
		
		while (params.hasMoreElements())
				{
				//email est dans param
				String param = (String) params.nextElement();
				String valeur = request.getParameter(param);
				//parcours tous les parametres (email et pwd)
				//crée une ligne tr 
				out.append("<tr><td> "+ param +"</td><td> "+ valeur +"</td></tr>");
				}
	out.append("</table>");
	//getparameter retourne la valeur
	//getattribute values aussi
	//getattribute maps aussi
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
