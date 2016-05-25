package logik;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DataAcess;

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
					
					resultater.add(resultset.getString(i++));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultater;
	}
}
