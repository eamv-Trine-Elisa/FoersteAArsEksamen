package data;

import java.util.ArrayList;

import logik.FindBestilIDFraKundenr;
import logik.FindOplysningerFraBestilID;

public class DataAcessController {

	public static void main(String[] args) {

//		bestillingTest();
		findAlleBestillingerOgExporterCSV(3);
		

	}

	public static void findAlleBestillingerOgExporterCSV(int kundenr) {
		ArrayList<String> overføre = new ArrayList<>();

		int bestilID = 0;


		FindBestilIDFraKundenr fbIDfk = new FindBestilIDFraKundenr();
		FindOplysningerFraBestilID fofb = new FindOplysningerFraBestilID();
		CSV csv = CSV.getInstance();

		overføre.addAll(fbIDfk.findeBestilIDfraKundenr(kundenr));

		for (int i = 0; i < overføre.size(); i++) {

			bestilID = Integer.parseInt(fbIDfk.findeBestilIDfraKundenr(kundenr).get(i));

			csv.lavCSVfil(fofb.bestillingAdresseOplysninger(bestilID));
		}

	}
	
//	public static void bestillingTest(){
//		DataAcess da = DataAcess.getInstance();
////		da.indsætIBestilling(3);
//		da.indsætIBestilling_adresse(6, "start vej og nr", "Start by", "start postnr", "startKommune", 
//				"slutVejOgNr", "slutBy", "slutPostnr", "slutKommune");
//		da.indsætIBestilling_PHB(6, "antalPersoner", "hjælpemidler", "beregnetPris");
//		da.indsætIBestilling_Tid(6, "dato", "måned", "afgang_ankomst", "klokkeslæt");
//		
//	}
//	
//	
//	public static void bestillingTest(){
//		BestilKørsel bk = new BestilKørsel();
//		
//		bk.bestilKørsel("antalPersoner", "startVejOgNr", "startBy", "startPostnr", "startKommune", "slutVejOgNr", "slutBy",
//				"slutPostnr", "slutKommune", "dato", "måned", "klokkeslæt", "afgang_ankomst", "hjælpemidler", "beregnetPris", 3);
//	}
//	
//	
	

}
