package adelium.cours.java;

public class Utilisateur {
	
	private int Id;
	private String login;
	private String mdp;
	private String role;
	private String Email;
	
	



	public Utilisateur (String login,String mdp){
		this.login=login;
		this.mdp=mdp;
	}
		
	
	public Utilisateur (String login,String mdp,String role){
		this.login=login;
		this.mdp=mdp;
		this.role=role;
	}
	
	public Utilisateur (int Id,String login,String mdp,String role){
		this.Id=Id;
		this.login=login;
		this.mdp=mdp;
		this.role=role;
	}

	public Utilisateur(String login, String mdp, String role, String email) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.role = role;
		Email = email;
	}
	
	public Utilisateur(int id, String login, String mdp, String role, String email) {
		super();
		Id = id;
		this.login = login;
		this.mdp = mdp;
		this.role = role;
		Email = email;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [Id=");
		builder.append(Id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", mdp=");
		builder.append(mdp);
		builder.append(", role=");
		builder.append(role);
		builder.append(", Email=");
		builder.append(Email);
		builder.append("]");
		return builder.toString();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;

	}
}
