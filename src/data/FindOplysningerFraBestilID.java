package data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindOplysningerFraBestilID {

	private ArrayList<String> resultater = new ArrayList<>();
	private ResultSet resultset = null;

	
	public ArrayList<String> bestillingAdresseOplysninger(int bestilID) {

		try {
			DataAcess da = DataAcess.getInstance();
			resultset = da.bestillingsOplysninger("Bestilling_Adresse", bestilID);

			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int i = 1;
				while (i <= numberOfColumns) {

					resultater.add(resultset.getString(i));
					
				i++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resultater);
		return resultater;
	}
	public ArrayList<String> bestillingTidOplysninger(int bestilID) {

		try {
			DataAcess da = DataAcess.getInstance();
			resultset = da.bestillingsOplysninger("Bestilling_Tid", bestilID);

			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int i = 1;
				while (i <= numberOfColumns) {

					resultater.add(resultset.getString(i));
					
				i++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resultater);
		return resultater;
	}
	public ArrayList<String> bestillingPHBOplysninger(int bestilID) {

		try {
			DataAcess da = DataAcess.getInstance();
			resultset = da.bestillingsOplysninger("Bestilling_PHB", bestilID);

			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int i = 1;
				while (i <= numberOfColumns) {

					resultater.add(resultset.getString(i));
					
				i++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resultater);
		return resultater;
	}
}
