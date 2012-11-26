package dbObjekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import sun.tracing.dtrace.DTraceProviderFactory;

public class buecher extends dbObjekt
{
	
	private String isbn;
	private String suchbegriffe;
	private String title;
	
	
	public buecher( String isbn, String su, String t)
	{
		this.isbn = isbn;
		this.suchbegriffe = su;	
		this.title = t;
		System.out.printf("ausgabe :" + isbn ,su, t);
		save();
	}
	
	public void save() 
	{

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
			st.execute("INSERT INTO `bibliothek`.`buecher` (`titel`, `isbn`, `suchbegriffe`) VALUES ( '"
					+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
			/*st.execute("INSERT INTO `bibliothek`.`buecher` (`id`, `titel`, `isbn`, `suchbegriffe`) VALUES (NULL, '"
					+ title + "', '" + isbn + "', '" + suchbegriffe + "');");
		*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
		
		
	}
	
	


