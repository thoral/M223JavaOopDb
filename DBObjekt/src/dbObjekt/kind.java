package dbObjekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class kind extends dbObjekt
{
	
	String name;
	String klasse;

	/*public kind(int id, String  n)
	{
		this.id_kind = id;
		this.name = n;
		System.out.println("1.");
		save();
	}
*/
	public kind(String n, String kl) {
		
		this.name = n;
		this.klasse = kl;
		System.out.println("2.");
		save();
		
	}
	
	public void save() {
		System.out.println("sgf");
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
			st.execute("INSERT INTO `bibliothek`.`kind` ( `name`, `klasse`) VALUES ( '" + name + "', '" + klasse + "');");
		/*	st.execute("INSERT INTO `bibliothek`.`kind` ( `name`, `klasse`) VALUES (NULL, '"
					+ id_kind + "', '" + name + "', '" + klasse + "');");
					*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
