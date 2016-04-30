package adelium.cours.java;

import java.sql.Date;

public class Objet {
		
		private int Id;
		private String Designation;
		private String Prix;
		private String Categorie;
		private String Lieu;
		private Date date; // = Date.valueOf(LocalDate.now());//Date -> java.sql 
		private String Email = "oz_try@try.fr";
		
		
		
		
		



		public Objet(String designation, String prix, String categorie, String lieu, Date date, String email) {
			super();
			Designation = designation;
			Prix = prix;
			Categorie = categorie;
			Lieu = lieu;
			this.date = date;
			Email = email;
		}

		
		public Objet(int id, String designation, String prix, String categorie, String lieu, Date date, String email) {
			super();
			Id = id;
			Designation = designation;
			Prix = prix;
			Categorie = categorie;
			Lieu = lieu;
			this.date = date;
			Email = email;
		}
		

	


		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getDesignation() {
			return Designation;
		}

		public void setDesignation(String designation) {
			Designation = designation;
		}

		public String getPrix() {
			return Prix;
		}

		public void setPrix(String prix) {
			Prix = prix;
		}

		public String getCategorie() {
			return Categorie;
		}

		public void setCategorie(String categorie) {
			Categorie = categorie;
		}

		public String getLieu() {
			return Lieu;
		}

		public void setLieu(String lieu) {
			Lieu = lieu;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Objet [Id=");
			builder.append(Id);
			builder.append(", Designation=");
			builder.append(Designation);
			builder.append(", Prix=");
			builder.append(Prix);
			builder.append(", Categorie=");
			builder.append(Categorie);
			builder.append(", Lieu=");
			builder.append(Lieu);
			builder.append(", date=");
			builder.append(date);
			builder.append("]");
			return builder.toString();
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}
	
		
		
	}
		
		


