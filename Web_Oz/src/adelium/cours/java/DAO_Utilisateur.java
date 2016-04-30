package adelium.cours.java;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Utilisateur extends DAO<Utilisateur> {

	public DAO_Utilisateur() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int Create(Utilisateur element) {
		// TODO Auto-generated method stub
		
	PreparedStatement smt=null;  
		
		String chaineSQL="";
        int rep=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			chaineSQL="insert into Utilisateur (Login,mdp,Role,Email) values(?,?,?,?)";			
			smt=this.getCnn().prepareStatement(chaineSQL); 
			
			smt.setString(1, element.getLogin());
			smt.setString(2, element.getMdp());
			smt.setString(3, element.getRole());
			smt.setString(4, element.getEmail());
					
			rep=smt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}

	@Override
	public int Update(Utilisateur element) {

		
		PreparedStatement smt=null;  		
		String chaineSQL="";
        int rep=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			chaineSQL="Update Utilisateur SET login=?,mdp=?,role=? WHERE ID_Utilisateur=?";
			
			smt=this.getCnn().prepareStatement(chaineSQL); 
			
			smt.setString(1, element.getLogin());
			smt.setString(2, element.getMdp());
			smt.setString(3, element.getRole());
	        smt.setInt(4, element.getId());;
			
			rep=smt.executeUpdate();
	
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;

	}

	@Override
	public int Delete(Utilisateur element) {
	PreparedStatement smt=null;
		
		String chaineSQL="";
        int rep=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			chaineSQL="Delete from Utilisateur WHERE ID_Utilisateur=?";			
			smt=this.getCnn().prepareStatement(chaineSQL);
			smt.setInt(1,  element.getId());			
			rep=smt.executeUpdate();		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;

	}

	public Utilisateur Retrieve (String identifiant, String mdp) {
		PreparedStatement smt=null;
		String chaineSQL="";
		Utilisateur rep=null;
		ResultSet rs=null;
		 

		try {
			chaineSQL="SELECT * FROM utilisateur WHERE Login=? AND Mdp=?";  //"Select * from Utilisateurs Where ID_UTILISATEUR = ?" 
			
			smt=this.getCnn().prepareStatement(chaineSQL);
			smt.setString(1, identifiant);
			smt.setString(2, mdp);
			System.out.println(smt.toString());
			rs=smt.executeQuery(); // faut enlever le chaineSQL dans le executeQuery il y est deja dans le smt
			
			while (rs.next())
			{
				rep = new Utilisateur(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4)) ;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}
	
	public Utilisateur RetrieveByEmail (String Email, String login) {
		PreparedStatement smt=null;
		String chaineSQL="";
		Utilisateur rep=null;
		ResultSet rs=null;
		 

		try {
			chaineSQL="SELECT * FROM utilisateur WHERE Login=? AND Email=? ";  //"Select * from Utilisateurs Where ID_UTILISATEUR = ?" 
			
			smt=this.getCnn().prepareStatement(chaineSQL);
			smt.setString(1, login);
			smt.setString(2, Email);
			System.out.println(smt.toString());
			rs=smt.executeQuery(); // faut enlever le chaineSQL dans le executeQuery il y est deja dans le smt
			
			while (rs.next())
			{
				rep = new Utilisateur(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4)) ;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}
	
	
	

	@Override
	public List<Utilisateur> RetrieveAll() {
		
		PreparedStatement smt=null;
		String chaineSQL="";
		List<Utilisateur> rep=new ArrayList<Utilisateur>();
		ResultSet rs=null;
		 

		try {
			chaineSQL="select * from Utilisateur";
			
			smt=this.getCnn().prepareStatement(chaineSQL);
			rs=smt.executeQuery(chaineSQL);
			
			while (rs.next())
			{
				rep.add(new Utilisateur(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4)) );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	@Override
	public Utilisateur Retrieve(int indice) {
		// TODO Auto-generated method stub
		return null;
	}







	

}
