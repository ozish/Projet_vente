package adelium.cours.java;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Objet extends DAO<Objet> {

	public DAO_Objet() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int Create(Objet obj) {
		// TODO Auto-generated method stub
		PreparedStatement smt=null;  
		
		String chaineSQL="";
        int rep=0;
               		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			chaineSQL="insert into objet_vente (Designation,Prix,Categories,Lieu,Date,Email) values(?,?,?,?,?,?)";			
			smt=this.getCnn().prepareStatement(chaineSQL, Statement.RETURN_GENERATED_KEYS); //retourne le Id auto incrementé lors de l'envoie de la chaine sql
			
			smt.setString(1, obj.getDesignation());
			smt.setInt(2, Integer.parseInt(obj.getPrix()));
			smt.setString(3, obj.getCategorie());
			smt.setString(4, obj.getLieu());
			smt.setDate(5, obj.getDate());
			smt.setString(6, obj.getEmail());
			
					
			rep=smt.executeUpdate();
			// rep contient le nbre d'enreigistrement effectué/ligne
			ResultSet generatedKey = smt.getGeneratedKeys(); //getGeneratedKeys retourne le *id auto incrementé
			generatedKey.next();
			//on sait que y a q'une ligne ou on insere donc 1 seule .next()
			obj.setId(generatedKey.getInt(1));
			// lit dans la 1ere colonne avec la ligne correspondante a celle crée et retourne ici l'ID objet
			
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
	public int Update(Objet obj) {

		
		PreparedStatement smt=null;  		
		String chaineSQL="";
        int rep=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			chaineSQL="Update Objet SET Designation=?,Prix=?,Categories=?,Lieu=?,Date=? Email=? WHERE ID_Objet=?";
			
			smt=this.getCnn().prepareStatement(chaineSQL); 
			
			smt.setString(1, obj.getDesignation());
			smt.setString(2, obj.getPrix());
			smt.setString(3, obj.getCategorie());
			smt.setString(4, obj.getLieu());
			smt.setDate(5, obj.getDate());
			smt.setString(6, obj.getEmail());
			smt.setInt(7, obj.getId());
			
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
	public int Delete(Objet obj) {
	PreparedStatement smt=null;
		
		String chaineSQL="";
        int rep=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			chaineSQL="Delete from objet_vente WHERE ID_Objet=?";			
			smt=this.getCnn().prepareStatement(chaineSQL);
			smt.setInt(1,  obj.getId());			
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

	public Objet Retrieve (String critere, String email) {
		PreparedStatement smt=null;
		String chaineSQL="";
		Objet rep=null;
		ResultSet rs=null;
		 

		try {
			chaineSQL="SELECT * FROM objet_vente WHERE" + critere + " = ? ";  //"Select * from Utilisateurs Where ID_UTILISATEUR = ?" 
			
			smt=this.getCnn().prepareStatement(chaineSQL);
			smt.setString(1, critere);
			smt.setString(2, email);
			System.out.println(smt.toString());
			rs=smt.executeQuery(); // faut enlever le chaineSQL dans le executeQuery il y est deja dans le smt
			
			while (rs.next())
			{
				rep = new Objet(rs.getString("Designation"),rs.getString("Prix"),rs.getString("Categories"),rs.getString("Lieu"),rs.getDate("Date"),rs.getString("Email")) ;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}
	
	public Objet RetrieveByEmail (String Email, String login) {
		PreparedStatement smt=null;
		String chaineSQL="";
		Objet rep=null;
		ResultSet rs=null;
		 

		try {
			chaineSQL="SELECT * FROM Objet WHERE Login=? Email=? ";  //"Select * from Utilisateurs Where ID_UTILISATEUR = ?" 
			
			smt=this.getCnn().prepareStatement(chaineSQL);
			smt.setString(1, login);
			smt.setString(2, Email);
			System.out.println(smt.toString());
			rs=smt.executeQuery(); // faut enlever le chaineSQL dans le executeQuery il y est deja dans le smt
			
			while (rs.next())
			{
				rep = new Objet(rs.getString("Designation"),rs.getString("Prix"),rs.getString("Categories"),rs.getString("Lieu"),rs.getDate("Date"),rs.getString("Email")) ;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}
	
	
	

	@Override
	public List<Objet> RetrieveAll() {
		
		PreparedStatement smt=null;
		String chaineSQL="";
		List<Objet> rep=new ArrayList<Objet>();
		ResultSet rs=null;
		 

		try {
			chaineSQL="select * from objet_vente";
			
			smt=this.getCnn().prepareStatement(chaineSQL);
			rs=smt.executeQuery(chaineSQL);
			
			while (rs.next())
			{
				rep.add(new Objet(rs.getString("Designation"),rs.getString("Prix"),rs.getString("Categories"),rs.getString("Lieu"),rs.getDate("Date"),rs.getString("Email")) );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	@Override
	public Objet Retrieve(int indice) {
		// TODO Auto-generated method stub
		return null;
	}







	

}
