package logik;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DataAcess;

public class FindBestilIDFraKundenr {

	private ArrayList<String> bestillingsNr = new ArrayList<>();
	private ResultSet resultset = null;

	
	public ArrayList<String> findeBestilIDfraKundenr(int kundenr) {

		DataAcess da = DataAcess.getInstance();
		resultset = da.findeBestilIDfraKundenr(kundenr);

		try {
			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				
				int j = 1;
				while (j <= numberOfColumns) {
					bestillingsNr.add(resultset.getString(j));
					System.out.println(resultset.getString(j));

					j++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bestillingsNr;
	}

}
