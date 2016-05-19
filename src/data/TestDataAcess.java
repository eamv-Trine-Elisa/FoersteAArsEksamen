package data;

import java.util.ArrayList;

import logik.FindBestilIDFraKundenr;
import logik.FindOplysningerFraBestilnr;

public class TestDataAcess {

	public static void main(String[] args) {

		FindBestilIDFraKundenr fbIDfk = new FindBestilIDFraKundenr();
		
		ArrayList <String> list = new ArrayList <>();
		
		list.addAll(fbIDfk.findeBestilIDfraKundenr(1));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
		
		for (int j = 0; j < fbIDfk.findeBestilIDfraKundenr(1).size(); j++) {
			
			
			int ting = Integer.parseInt(fbIDfk.findeBestilIDfraKundenr(1).get(j));
	//	System.out.println(ting);
		}
		
		
		FindOplysningerFraBestilnr fofb = new FindOplysningerFraBestilnr();
		
		CSV csv = new CSV();
//		csv.lavCSVfil(fofb.bestillingAdresseOplysninger(ting));
		
		
	}

}
