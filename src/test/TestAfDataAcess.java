package test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DataAcess;

public class TestAfDataAcess {

	static ResultSet resultset = null;
	ArrayList<String> testAfDen = new ArrayList<>();

	public static void main(String[] args) {

	//	testAfDataAcessMetodefindeBestilIDfraKundenr();
		
		testAfDataAcessMetodebestillingsOplysninger();
	}

	public static void testAfDataAcessMetodefindeBestilIDfraKundenr() {
		DataAcess da = DataAcess.getInstance();
		resultset = da.findeBestilIDfraKundenr(1);

		try {
			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int j = 1;
				while (j <= numberOfColumns) {
					System.out.println(resultset.getString(j));

					j++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testAfDataAcessMetodebestillingsOplysninger() {
		DataAcess da = DataAcess.getInstance();
		resultset = da.bestillingsOplysninger("Bestilling_Adresse", 1);

		try {
			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int j = 1;
				while (j <= numberOfColumns) {
					System.out.println(resultset.getString(j));

					j++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
