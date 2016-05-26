package logik;

public class MainTestTing {

	public static void main(String[] args) {

		MFTScontroller mftsc = new MFTScontroller();
//		String pris = mftsc.udfyldBestillingsblanket("2", "startVejOgNr", "startBy", "startPostnr", "Herning",
//				"slutVejOgNr", "slutBy", "slutPostnr", "Holstebro", "26", "5");
//		System.out.println(pris);
//
//		boolean indsæt = mftsc.bestilKørsel("2", "Førstevej 5", "Herning", "7400", "Herning", "AndenVej 6", "Holstebro", "1337",
//				"Holstebro", "26", "5", "13:30", "afgang", "Kørestol", pris, "3");
//		System.out.println(indsæt);
		

		Converter c = new Converter();
		String f = c.beregnetPrisDoubleToString(58888.85697423);
		
		System.out.println(f);

	}

}