package model;

/*****************************
 imports
*****************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class rezept {
	
/******************************
 Variable
 ******************************/
	private int id;
	private String rezept;
	private String kategorie;
	private String saison;

	
	/************************
	 Methoden getter setter
	 ************************/
	public String getRezept() {
		return rezept;
	}
	public void setRezept(String rezept) {
		this.rezept = rezept;
	}
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	public String getSaison() {
		return saison;
	}
	public void setSaison(String saison) {
		this.saison = saison;
	}
	public int getId() {
		return id;
	}
	
/*********************************
	 Methoden save
***********************************/
	public void save() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//Variable wir definiert um eine Verbindung zu DB herstellen zutellen
		// Datentyp variable 
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/bibliothek", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.execute("INSERT INTO `java_rezept`.`rezept` (`id`, `rezept`, `kategorie`, `saison`) VALUES (NULL, '"
					+ rezept + "', '" + saison + "', '" + kategorie + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Rezept gespeichert " + this.getRezept());
		System.out
				.println("INSERT INTO `java_rezept`.`rezept` (`id`, `rezept`, `kategorie`, `saison`) VALUES (NULL, '"
						+ rezept + "', '" + saison + "', '" + kategorie + "');");
	}
		
}
	
	

