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
 * Servlet implementation class Servlet_create
 */
@WebServlet("/Servlet_create")
public class Servlet_create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		HttpSession session = request.getSession();
		
		PrintWriter out=response.getWriter();
	    Enumeration<String> params=request.getParameterNames();
	    String Identifiant="";
	    String Mdp="";
	    String role="Utilisateur";
	    String Email="";
	    /*String prenom="";
	    String email="";
	    int telephone = 0;*/
	 
	  
	   while(params.hasMoreElements())
	    {
	    	
	      	String param=(String) params.nextElement();
	      	
	      	if (param.equals("Emaill"))
	      	{
	      		Email=request.getParameter(param);

	      	}					
	      	if (param.equals("Identifiantt"))
	      	{
	      		Identifiant=request.getParameter(param);

	      	}						
	      	
	      	if (param.equals("Mdpp1"))
	      	{
	      		Mdp=request.getParameter(param);
	      	}
	      	
	      	
	      	
	      	
	      	/*if (param.equals("prenom"))
	      	{
	      		prenom=request.getParameter(param);
	      	}*/
	      	/*if (param.equals("email"))
	      	{
	      		email=request.getParameter(param);
	      	}
	      	if (param.equals("telephone"))
	      	{
	      		telephone=Integer.parseInt(request.getParameter(param));
	      	}*/
	    }
	    out.append("Identifiant:"+Identifiant+"/Mdp:"+ Mdp+"/role" +role+"/Email" + Email+"/" ); //le data.split recupere ce qui est avant le slash

	    
        
	    @SuppressWarnings("deprecation")
		Utilisateur client1=new Utilisateur(Identifiant,Mdp,role,Email);
	    
	    try {
	    	int val = new DAO_Utilisateur().Create(client1);
	    	
			if (val==0) {//response.setStatus(0);
			  out.append("Found");
			  session.setAttribute( "Identifiant", null );
			  session.setAttribute("Mdp", null );
			  session.setAttribute("role", null );
			  session.setAttribute("Email", null );
			  
			   }
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
