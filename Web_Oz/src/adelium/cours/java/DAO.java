package adelium.cours.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO <T>
{
	private Connection Cnn;
	public Connection getCnn() {
		return Cnn;
	}
	
	public DAO() throws ClassNotFoundException, SQLException {
		super();
		this.Cnn=Connection_FACTORY.getConnection();
	}
	
	public abstract int Create( T element);
	public abstract int Update( T element);
	public abstract int Delete( T element);
	public abstract T Retrieve( int indice);
	public abstract List<T> RetrieveAll();
	

}