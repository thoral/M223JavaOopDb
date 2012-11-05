package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Buch {

	/*********************************
	 * Variablen
	 ********************************/
	private String title;
	private String isbn;
	private String suchbegriffe;
	private String autor;
	private String Kategorie;
	// Die id wird als Objekt weiter gegeben,
	// wenn die id nicht gesetzt ist, existiert das Objekt nicht
	private int id;

	/*********************************
	 * Methoden
	 ********************************/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSuchbegriffe() {
		return suchbegriffe;
	}

	public void setSuchbegriffe(String suchbegriffe) {
		this.suchbegriffe = suchbegriffe;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getKategorie() {
		return Kategorie;
	}

	public void setKategorie(String kategorie) {
		Kategorie = kategorie;
	}

	public int getId() {
		return id;
	}

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
			st.execute("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
					+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Buch gespeichert " + this.getTitle());
		System.out
				.println("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
						+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
	}

	

}
