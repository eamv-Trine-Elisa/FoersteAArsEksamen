package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAcess {

	
	ResultSet resultset = null;
	// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url = "jdbc:sqlserver://10.153.246.10:1433;instanceName=SQLExpress;databaseName=IPSOS;user=Elisa;password=12345678";
	
	public void getConnection(){
		Connection con = DriverManager.getConnection(url);
		Statement statement = con.createStatement();
		resultset = statement.executeQuery("arg0");
	}
	
	con.commit();
	con.rollback();
	con.close();
	con.connection();
	

	
	
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
