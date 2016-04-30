package adelium.cours.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_FACTORY {
	
	Connection Cnn=null;
	private static String url="jdbc:mysql://localhost:3306/formation";
	private static String user="root";
	private static String pwd="";
	
	private Connection_FACTORY()
	{
		
	}
	
	private static Connection _Cnn=null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		if (_Cnn==null) //si pas de connexion, il en crée une
		{
		
		Class.forName("com.mysql.jdbc.Driver");
		_Cnn=DriverManager.getConnection(url,user,pwd); 
	
		}
		return _Cnn;
	}
	}


