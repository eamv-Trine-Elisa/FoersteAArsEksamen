package data;

public class DataAcessController {

	public void lavCSVfil(int kundenr) {

		HåndteringAFSamleTilCSV hastCSV = new HåndteringAFSamleTilCSV();
		hastCSV.findAlleBestillingerOgExporterCSV(kundenr);
	}

	
	public boolean bestillingAfKørsel(String antalPersoner, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune, String dato,
			String måned, String klokkeslæt, String afgang_ankomst, String hjælpemidler, String beregnetPris,
			int kundenr) {

		boolean kørselBestilt = false;

		BestilKørsel bestilKørsel = new BestilKørsel();

		kørselBestilt = bestilKørsel.bestilKørsel(antalPersoner, startVejOgNr, startBy, startPostnr, startKommune,
				slutVejOgNr, slutBy, slutPostnr, slutKommune, dato, måned, klokkeslæt, afgang_ankomst, hjælpemidler,
				beregnetPris, kundenr);

		return kørselBestilt;
	}
}
