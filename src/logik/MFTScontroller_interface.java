package logik;

public interface MFTScontroller_interface {

	public String udfyldBestillingsblanket(String antalPersoner, String startVejOgNr, 
			String startBy, String startPostnr, String startKommune, String slutVejOgNr, String slutBy, 
			String slutPostnr, String slutKommune, String dato, String måned);
	
	public boolean bestilKørsel (String antalPersoner, String startVejOgNr, String startBy, String startPostnr, String startKommune, String slutVejOgNr, 
			String slutBy, String slutPostnr, String slutKommune, String dato, String måned, String klokkeslæt, String afgang_ankomst, 
			String hjælpemidler, String beregnetPris, String kundenr);
	
	public void lavCSVfil(int kundenr);
}
