package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

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
		
		Statement st = createStatement();
		
		ResultSet rs = null;
		try {
			
					
					
			st.executeUpdate("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
					+ title + "', '" + isbn + "', '" + suchbegriffe + "');", 1);
			System.out.println(Statement.RETURN_GENERATED_KEYS);
			rs = st.getGeneratedKeys();
			System.out.println(rs.getMetaData().getCatalogName(1) );
			rs.first();
			id = rs.getInt(1);
			System.out.println(rs.getMetaData().getColumnName(1));
			
			/*st.execute("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
					+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
		*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Buch gespeichert " + this.getTitle());
		System.out
				.println("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
						+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
	}
						// id
	public void load(int nr) {
		Statement  st = createStatement();
		ResultSet rs = null;
		
		try {
			
			st.executeQuery("SELECT * FROM  `bibliothek`.`buecher` "+" WHERE `id' ="+nr);
		
			//System.out.println(rs.getMetaData().getCatalogName(1) );
			title = rs.getString("title");
			isbn = rs.getString("isbn");
			suchbegriffe = rs.getString("suchbegriffe");
			rs.first();
			id = rs.getInt(1);
			System.out.println(rs.getMetaData().getColumnName(1));
			
			/*st.execute("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
					+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
		*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private Statement createStatement(){
		
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
		
		return st;
		
		
	}

}
