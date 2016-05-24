package logik;

public class MFTScontroller implements MFTScontroller_interface{
	
	Converter converter = new Converter();

	@Override
	public String udfyldBestillingsblanket(String antalPersoner, String startVejOgNr, String startBy,
			String startPostnr, String startKommune, String slutVejOgNr, String slutBy, String slutPostnr,
			String slutKommune, String dato, String måned) {
		
		converter.antalPersonerStringToInt(antalPersoner);
		converter.datoStringToInt(dato);
		converter.månedStringToInt(måned);
		
		
		//return String beregnetPris
		return null;
	}

	@Override
	public boolean bestilKørsel(String antalPersoner, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune, String dato,
			String måned, String klokkeslæt, String afgang_ankomst, String hjælpemidler, String beregnetPris,
			String kundenr) {
		
		converter.kundenrStringToInt(kundenr);
		
		
		return false;
	}

}
