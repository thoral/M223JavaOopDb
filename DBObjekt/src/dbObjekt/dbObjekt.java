package dbObjekt;

import java.util.List;
import java.awt.event.ActionListener;
import java.sql.*;

public class dbObjekt {

	
	/*
	 * Eigenschaften
	 */
	protected int id;	
	protected int id_user;
	
	
	
	public void connect()
	{
		
	}
	
	public void save()
	{
		
	}
	
	public void validate()
	{
		
	}
	
	 public void load()
	{
		
		Statement  st = createStatement();
		ResultSet rs = null;
		
		try {
			
			String query = "SELECT * FROM  `bibliothek`.`buecher` ";
			rs = st.executeQuery(query);
			while ( rs.next() )
			{
				  System.out.printf( "%s, %s, %s, %s  %n", rs.getString(1),
				                     rs.getString(2), rs.getString(3), rs.getString(4) );
				 
				 
				  //comp.addListElement("Test " );
						  
			}
			//System.out.println(rs.getString(1));
			/*
			while ( rs.next() )
			{
				title = rs.getString("title");
				isbn = rs.getString("isbn");
				suchbegriffe = rs.getString("suchbegriffe");
				//rs.first();
				//id = rs.getInt(1);
			
			}
			*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static Statement createStatement(){
		
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
