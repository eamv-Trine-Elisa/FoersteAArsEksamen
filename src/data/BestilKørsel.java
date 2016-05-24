package data;

public class BestilKørsel {

	private String antalPersoner;
	private String startVejOgNr;
	private String startBy;
	private String startPostnr;
	private String startKommune;
	private String slutVejOgNr;
	private String slutBy;
	private String slutPostnr;
	private String slutKommune;
	private String dato;
	private String måned;
	private String klokkeslæt;
	private String afgang_ankomst;
	private String hjælpemidler;
	private String beregnetPris;
	private int kundenr;

	public boolean bestilKørsel(String antalPersoner, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune, String dato,
			String måned, String klokkeslæt, String afgang_ankomst, String hjælpemidler, String beregnetPris,
			int kundenr) {

		// hvis det hele ryger ind i databasen return true
		return false;
	}

}
