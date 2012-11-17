package dbObjekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class kind extends dbObjekt
{
	int id_kind;
	String name;
	String klasse;

	public kind(int id, String  n)
	{
		this.id_kind = id;
		this.name = n;
	}

	public kind(String n, String kl) {
		
		this.name = n;
		this.klasse = kl;
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
			st.execute("INSERT INTO `bibliothek`.`kind` (`id`, `name`, `klasse`) VALUES (NULL, '"
					+ id_kind + "', '" + name + "', '" + klasse + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Kind gespeichert " + this.getTitle());
		System.out
				.println("INSERT INTO `bibliothek`.`kind` (`id_kind`, `name`, `klasse`) VALUES (NULL, '"
						+ id_kind + "', '" + name + "', '" + klasse + "');");
	}
	
	
}
