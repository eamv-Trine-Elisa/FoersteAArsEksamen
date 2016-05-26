package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataAcess {

	private ResultSet resultset = null;
	private Connection con;
	private String url = "jdbc:sqlserver://localhost:1433;instanceName=SQLExpress;databaseName=MFTS;integratedSecurity=true;";
	private boolean korrektIndsat = false;
	
	// Creating a singleton class.
	private static DataAcess instance = null;

	private DataAcess() {
		// Exists only to defeat instantiation.
	}

	public static DataAcess getInstance() {
		if (instance == null) {
			instance = new DataAcess();
		}
		return instance;
	}
	

	public ResultSet findeBestilIDfraKundenr(int kundenr) {

		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			resultset = statement.executeQuery("SELECT Bestil_ID FROM Bestilling WHERE Kundenr = '" + kundenr + "'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultset;
	}
	

	public ResultSet bestillingsOplysninger(String tabelNavn, int bestilID) {

		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			resultset = statement.executeQuery("SELECT * FROM "+ tabelNavn +" WHERE Bestil_ID = '" + bestilID + "'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultset;

	}
	
	public boolean indsætIBestilling(int kundenr) {
		
		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO Bestilling VALUES("+ kundenr +")");
			korrektIndsat = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			korrektIndsat = false;
		}
		
		
		return korrektIndsat;
		
	}
	public boolean indsætIBestilling_adresse(int bestilID, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune) {
		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO Bestilling_Adresse VALUES ("+ bestilID +",'"+ startVejOgNr +"',' "+ startBy +"','"+ startPostnr +"','"+ startKommune +"',"
					+ "' "+ slutVejOgNr +"',' "+ slutBy +"',' "+ slutPostnr +"',' "+ slutKommune +"')");
			
			korrektIndsat = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			korrektIndsat = false;
		}
		
		return korrektIndsat;	
	}
	
	public boolean indsætIBestilling_PHB(int bestilID, String antalPersoner,String hjælpemidler, String beregnetPris) {
		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO Bestilling_PHB VALUES ("+ bestilID +",'"+ antalPersoner +"','"+ hjælpemidler +"','"+ beregnetPris +"')");
			
			korrektIndsat = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			korrektIndsat = false;
		}
		
		return korrektIndsat;
	}
	
	public boolean indsætIBestilling_Tid(int bestilID, String dato,String måned, String afgang_ankomst,String klokkeslæt) {
		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO Bestilling_Tid VALUES ("+ bestilID +",'"+ dato +"','"+ måned +"','"+ afgang_ankomst +"','"+ klokkeslæt +"')");
			
			korrektIndsat = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			korrektIndsat = false;
		}
		
		
		return korrektIndsat;
		
	}

}
