package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAcess {

	
	ResultSet resultset = null;
	// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//MSSQLSERVER
	String url = "jdbc:sqlserver://localhost:1433;instanceName=SQLExpress;databaseName=MFTS;integratedSecurity=true;";

	//String url = "jdbc:sqlserver://10.153.246.10:1433;instanceName=SQLExpress;databaseName=IPSOS;user=Elisa;password=12345678";
	public void getConnection(){
		Connection con;
		
		try {
			con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			resultset = statement.executeQuery("SELECT * FROM Bestilling");
			
			while(resultset.next()){
				System.out.println(resultset);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	/*
	con.commit();
	con.rollback();
	con.close();
	con.connection();
	*/

	
	
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
	
}
