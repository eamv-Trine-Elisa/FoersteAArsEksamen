package data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindBestilIDFraKundenr {

	private ArrayList<String> bestillingsID = new ArrayList<>();
	private ResultSet resultset = null;

	
	public ArrayList<String> findeBestilIDfraKundenr(int kundenr) {

		DataAcess da = DataAcess.getInstance();
		resultset = da.findeBestilIDfraKundenr(kundenr);

		try {
			ResultSetMetaData metadata = resultset.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			
			while (resultset.next()) {
				
				int j = 1;
				while (j <= numberOfColumns) {
					
					if(!bestillingsID.contains(j)){
						bestillingsID.add(resultset.getString(j));

					}
					
					j++;
				}
			}


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(bestillingsID);
		return bestillingsID;
	}

}
