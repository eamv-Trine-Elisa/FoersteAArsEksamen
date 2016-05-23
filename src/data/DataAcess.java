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
	String url = "jdbc:sqlserver://localhost:1433;instanceName=SQLExpress;databaseName=MFTS;integratedSecurity=true;";

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

}
