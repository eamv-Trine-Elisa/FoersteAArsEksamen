package logik;

import data.DataAcessController;

public class MFTScontroller implements MFTScontroller_interface {

	private Converter converter = new Converter();
	private DataAcessController dataController = new DataAcessController();


	@Override
	public String udfyldBestillingsblanket(String antalPersoner, String startVejOgNr, String startBy,
			String startPostnr, String startKommune, String slutVejOgNr, String slutBy, String slutPostnr,
			String slutKommune, String dato, String måned) {

		Beregner beregner = new Beregner();

		double beregnetPrisIdouble = 0;
		int personAntal = converter.antalPersonerStringToInt(antalPersoner);
		int datoDag = converter.datoStringToInt(dato);
		int datoMåned = converter.månedStringToInt(måned);

		beregnetPrisIdouble = beregner.beregnPris(personAntal, startVejOgNr, startBy, startPostnr, startKommune,
				slutVejOgNr, slutBy, slutPostnr, slutKommune, datoDag, datoMåned);

		String beregnetPris = converter.beregnetPrisDoubleToString(beregnetPrisIdouble);

		return beregnetPris;
	}

	@Override
	public boolean bestilKørsel(String antalPersoner, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune, String dato,
			String måned, String klokkeslæt, String afgang_ankomst, String hjælpemidler, String beregnetPris,
			String kundenr) {

		boolean bestilt = false;

		int kundeNr = converter.kundenrStringToInt(kundenr);

		bestilt = dataController.bestillingAfKørsel(antalPersoner, startVejOgNr, startBy, startPostnr, startKommune,
				slutVejOgNr, slutBy, slutPostnr, slutKommune, dato, måned, klokkeslæt, afgang_ankomst, hjælpemidler,
				beregnetPris, kundeNr);

		return bestilt;
	}

	@Override
	public void lavCSVfil(String kundenr) {

		int kundeNr = converter.kundenrStringToInt(kundenr);
		
		dataController.lavCSVfil(kundeNr);

	}

}
