package data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindOplysningerFraBestilID {

	private ArrayList<String> resultater = new ArrayList<>();
	private ResultSet resultset1 = null;
	private ResultSet resultset2 = null;
	private ResultSet resultset3 = null;

	
	public ArrayList<String> bestillingAdresseOplysninger(int bestilID) {

		try {
			DataAcess da = DataAcess.getInstance();
			resultset1 = da.bestillingsOplysninger("Bestilling_Adresse", bestilID);

			while (resultset1.next()) {
				ResultSetMetaData metadata = resultset1.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int i = 1;
				while (i <= numberOfColumns) {

					resultater.add(resultset1.getString(i));
					
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
			resultset2 = da.bestillingsOplysninger("Bestilling_Tid", bestilID);

			while (resultset2.next()) {
				ResultSetMetaData metadata = resultset2.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int i = 1;
				while (i <= numberOfColumns) {

					resultater.add(resultset2.getString(i));
					
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
			resultset3 = da.bestillingsOplysninger("Bestilling_PHB", bestilID);

			while (resultset3.next()) {
				ResultSetMetaData metadata = resultset3.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int i = 1;
				while (i <= numberOfColumns) {

					resultater.add(resultset3.getString(i));
					
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
