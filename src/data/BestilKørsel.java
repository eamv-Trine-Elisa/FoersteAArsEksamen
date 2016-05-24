package data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class BestilKørsel {

	private DataAcess da = DataAcess.getInstance();
	private int bestilID;
	private boolean indsatKorrekt = false;
	private boolean indsatAdresse = false;
	private boolean indsatPHB = false;
	private boolean indsatTid = false;

	
	public boolean bestilKørsel(String antalPersoner, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune, String dato,
			String måned, String klokkeslæt, String afgang_ankomst, String hjælpemidler, String beregnetPris,
			int kundenr) {
		
		indsættelseIBestilling(kundenr);
		bestilID = findNyesteBetilID(kundenr);
				
		indsatAdresse = da.indsætIBestilling_adresse(bestilID, startVejOgNr, startBy, startPostnr, startKommune,
				slutVejOgNr, slutBy, slutPostnr, slutKommune);
		indsatPHB = da.indsætIBestilling_PHB(bestilID, antalPersoner, hjælpemidler, beregnetPris);
		indsatTid = da.indsætIBestilling_Tid(bestilID, dato, måned, afgang_ankomst, klokkeslæt);

		if (indsatAdresse == true && indsatPHB == true && indsatTid == true) {
			indsatKorrekt = true;
		} else {
			indsatKorrekt = false;
		}

		return indsatKorrekt;
	}

	private void indsættelseIBestilling(int kundenr){
		da.indsætIBestilling(kundenr);
	}
	
	private int findNyesteBetilID(int kundenr) {
		ArrayList<Integer> bestilIDListe = new ArrayList<>();
		ResultSet resultset = null;

		resultset = da.findeBestilIDfraKundenr(kundenr);

		try {
			while (resultset.next()) {
				ResultSetMetaData metadata = resultset.getMetaData();
				int numberOfColumns = metadata.getColumnCount();

				int j = 1;
				while (j <= numberOfColumns) {
					bestilIDListe.add(resultset.getInt(j));

					j++;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int størst = 0;
		
		for (int i = 0; i < bestilIDListe.size(); i++) {
			
			
			if(størst < bestilIDListe.get(i)){
				størst = bestilIDListe.get(i);
//				System.out.println(størst);
			}
		}
		
		return størst;
	}
}
