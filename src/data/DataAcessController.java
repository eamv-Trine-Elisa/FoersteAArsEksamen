package data;

import java.util.ArrayList;

import logik.FindBestilIDFraKundenr;
import logik.FindOplysningerFraBestilnr;

public class DataAcessController {

	public static void main(String[] args) {

		findAlleBestillingerOgExporterCSV(2);

	}

	public static void findAlleBestillingerOgExporterCSV(int kundenr) {
		ArrayList<String> overføre = new ArrayList<>();

		int bestilID = 0;


		FindBestilIDFraKundenr fbIDfk = new FindBestilIDFraKundenr();
		FindOplysningerFraBestilnr fofb = new FindOplysningerFraBestilnr();
		CSV csv = CSV.getInstance();

		overføre.addAll(fbIDfk.findeBestilIDfraKundenr(kundenr));

		for (int i = 0; i < overføre.size(); i++) {

			bestilID = Integer.parseInt(fbIDfk.findeBestilIDfraKundenr(kundenr).get(i));

			csv.lavCSVfil(fofb.bestillingAdresseOplysninger(bestilID));
		}

	}

}
