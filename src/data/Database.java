package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void lavDB() {
		Connection con = null;
		Statement sql = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:hsqldb:file:/opt/mindb/mintestdb", "SA", "");
			sql = con.createStatement();
			sql.executeUpdate("SET WRITE_DELAY 0");// Den skal sættes til 0 for
													// at kunne commit
		
			/*CREATE DATABASE IF NOT EXISTS MFTS

			CREATE TABLE IF NOT EXISTS MFTS.Kunder(
			Navn nvarchar(255),
			Kundenr int NOT NULL PRIMARY KEY IDENTITY(1,1) UNIQUE
			);

				INSERT INTO MFTS.Kunder
				VALUES ("Anders",1);

				INSERT INTO MFTS.Kunder
				VALUES ("Hans",2);

				INSERT INTO MFTS.Kunder
				VALUES ("Trine",3);

				INSERT INTO MFTS.Kunder
				VALUES ("Elisa",4);

				INSERT INTO MFTS.Kunder
				VALUES ("Flemming",5);


			CREATE TABLE IF NOT EXISTS MFTS.Bestillinger(
			Kundenr int NOT NULL FOREIGN KEY REFERENCES Kunder(Kundenr),
			Bestil_ID int NOT NULL PRIMARY KEY IDENTITY(1,1) UNIQUE
			);


			CREATE TABLE IF NOT EXISTS MFTS.Bestillinger_PHB(
			Bestil_ID FOREIGN KEY REFERENCES Bestillinger(Bestil_ID),
			Person_antal nvarchar(255),
			Hjælpemidler nvarchar(255),
			Beregnet_pris nvarchar(255)
			);


			CREATE TABLE IF NOT EXISTS MFTS.Bestillinger_Tid(
			Bestil_ID FOREIGN KEY REFERENCES Bestillinger(Bestil_ID),
			Dato nvarchar(255),
			Måned nvarchar(255),
			Afgang_Ankomst nvarchar(255),
			Tid nvarchar(255)
			);


			CREATE TABLE IF NOT EXISTS MFTS.Bestillinger_Adresse(
			Bestil_ID FOREIGN KEY REFERENCES Bestillinger(Bestil_ID),
			Start_Vej_og_Nr nvarchar(255),
			Start_By nvarchar(255),
			Start_Postnr nvarchar(255),
			Start_Kommune nvarchar(255),
			Slut_Vej_Og_Nr nvarchar(255),
			Slut_By nvarchar(255),
			Slut_Postnr nvarchar(255),
			Slut_Kommune nvarchar(255)
			);*/


			while (rs.next()) {
				System.out.println((rs.getString(1)));
			}
			con.commit();
			con.close();
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}
}
