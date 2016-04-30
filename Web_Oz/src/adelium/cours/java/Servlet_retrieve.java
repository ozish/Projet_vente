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

import com.google.gson.Gson;

/**
 * Servlet implementation class Servlet_retrieve
 */
@WebServlet("/Servlet_retrieve")
public class Servlet_retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_retrieve() {
        super();
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("Identifiant") ; // celui de setAttribute du post
		
		if(user == null)
		{
			response.setStatus(401);
		}
		else
		{
			String jsonContent = new Gson().toJson(user) ;
			response.setContentType("application/json");
			response.getWriter().write(jsonContent);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html"); 
		
		//ServletContext application = request.getServletContext();		
		HttpSession session = request.getSession();

		
		
		PrintWriter out=response.getWriter();
	    Enumeration<String> params=request.getParameterNames();
	    String Identifiant="";
	    String Mdp="";
	    while(params.hasMoreElements())
	    {
	    	
	      	String param=(String) params.nextElement();
	      	if (param.equals("Identifiantt"))
	      	{
	      		Identifiant=request.getParameter(param);
	      	}						
	      	
	      	if (param.equals("Mdpp"))
	      	{
	      		Mdp=request.getParameter(param);
	      	}
	    }
	    out.append("Identifiant:"+Identifiant+"/Mdp:"+ Mdp+"/");

	    

	    Utilisateur client1=null;
		try {
			
			client1 = new DAO_Utilisateur().Retrieve(Identifiant,Mdp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   if (client1!=null)
	   {
		   //response.setStatus(0);
		   out.append("Found"); 
		   session.setAttribute("Identifiant", Identifiant);
		   session.setAttribute("Mdp", Mdp);
	   }
	   else 
		   {//response.setStatus(0);
		  out.append("NotFound");
		  session.setAttribute( "Identifiant", null );
		  session.setAttribute("Mdp", null );
		   }
	}
	

}
