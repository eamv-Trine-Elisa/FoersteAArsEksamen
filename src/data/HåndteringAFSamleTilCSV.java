package data;

import java.util.ArrayList;

public class HåndteringAFSamleTilCSV {
	
	public void findAlleBestillingerOgExporterCSV(int kundenr){
		ArrayList<String> overføre = new ArrayList<>();
		ArrayList<String> samledeOplysninger = new ArrayList<>();

		int bestilID = 0;

		FindBestilIDFraKundenr fbIDfk = new FindBestilIDFraKundenr();
		FindOplysningerFraBestilID fofb = new FindOplysningerFraBestilID();
		CSV csv = CSV.getInstance();

		overføre.addAll(fbIDfk.findeBestilIDfraKundenr(kundenr));
		
		for (int i = 0; i < overføre.size(); i++) {

			bestilID = Integer.parseInt(overføre.get(i));
			samledeOplysninger.addAll(fofb.bestillingPHBOplysninger(bestilID));
			samledeOplysninger.addAll(fofb.bestillingTidOplysninger(bestilID));
			samledeOplysninger.addAll(fofb.bestillingAdresseOplysninger(bestilID));
			
		}
		csv.lavCSVfil(samledeOplysninger);

	}
}
