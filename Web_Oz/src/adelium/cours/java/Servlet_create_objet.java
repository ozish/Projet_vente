package adelium.cours.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class Servlet_create
 */
@WebServlet("/Servlet_create_objet")
public class Servlet_create_objet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_create_objet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		HttpSession session = request.getSession();
		
		PrintWriter out=response.getWriter();//reponse contient type printwriter retourné par la methode getwriter
	    Enumeration<String> params=request.getParameterNames();
	    String Designation="";
	    String Prix = null;
	    String Categorie="";
	    String Lieu="";
	    String Email="oz@hottry.fr";
	    Date date= java.sql.Date.valueOf(LocalDate.now());
	    //Pour les noms de variables utiliser des minuscul par exemple date
	    /*String prenom="";
	    String email="";
	    int telephone = 0;*/
	 
	    if(request.getParameter("RetrieveAllObjet") != null){
	    	List<Objet> liste = new ArrayList<Objet>(); // TODO
	    	//DAO_Objet liste = new DAO_Objet() ;
	    	try {
	    		liste = new DAO_Objet().RetrieveAll();
	    		//liste.RetrieveAll();
	    	} catch (ClassNotFoundException | SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	String lstobjet = new Gson().toJson(liste);//convertit en chaine de caracteres format Json (1ere etape)
	    	//String lstobjet = new Gson().toJson(liste.RetrieveAll());
	    	out.append(lstobjet);
	    }
	    else
	    {
	  
	    	while(params.hasMoreElements())
	    	{

	    		String param=(String) params.nextElement();

	    		if (param.equals("Designationn"))
	    		{
	    			Designation=request.getParameter(param);

	    		}					
	    		if (param.equals("Pricee"))
	    		{
	    			Prix=request.getParameter(param);

	    		}						

	    		if (param.equals("Categoriess"))
	    		{
	    			Categorie=request.getParameter(param);
	    		}

	    		if (param.equals("Lieuu"))
	    		{
	    			Lieu=request.getParameter(param);
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
	    	//out.append("Designation:"+Designation+"/Prix:"+ Prix+"/Categorie" +Categorie+"/Lieu" + Lieu+"/" ); //le data.split recupere ce qui est avant le slash



	    	Objet obj1=new Objet(Designation,Prix,Categorie,Lieu,date,Email);



	    	try {
	    		int val = new DAO_Objet().Create(obj1);// retourne le nbre de lignes modifiees si 0 = fail dans le proc modif
	    		String obj1S = new Gson().toJson(obj1);
	    		out.append(obj1S);
	    		/*
	    	if (val==0) {//response.setStatus(0);
			  out.append("Found");
			  session.setAttribute("Designation", null );
			  session.setAttribute("Prix", null );
			  session.setAttribute("Categorie", null );
			  session.setAttribute("Lieu", null );
			  session.setAttribute("Date", null );
			  session.setAttribute("Email", null );
			   }*/
	    	} catch (ClassNotFoundException | SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
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
