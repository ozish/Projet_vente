package adelium.cours.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet("/MaSuperServlet2")
public class MaSuperServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaSuperServlet2() {
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
		
		
		
		

	
	
	PrintWriter out = response.getWriter() ; //envoie à la methode do get
	Enumeration<String> params = request.getParameterNames();// recupere les parametre qui ont un nom
	
	String Email = "";
	String Mdp = "";
	
	while(params.hasMoreElements()) // verifie ce qui est recupéré
	
	{ 	
		String param = (String) params.nextElement(); // lit en bout de l'element puis saute une ligne donc lit email puis saute une ligne, 
		//lit pwd saute une ligne puis rien
		if (param.equals("email"))
			{
				
				Email = request.getParameter(param);
				System.out.println(Email);
				out.append("email:" +Email);
			}
		else if (param.equals("pwd"))
			{
				
				Mdp = request.getParameter(param);
				out.append(Mdp);
				System.out.println("Mdp"+Mdp);
				
			}
		
		
    }
    	
	
	
	try {
		DAO_Utilisateur userDAO = new DAO_Utilisateur();
		userDAO.Create(new Utilisateur(Email,Mdp,"Utilisateur")) ;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
