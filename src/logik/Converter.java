package logik;

public class Converter {

	public int antalPersonerStringToInt(String antalPersoner) {
		return Integer.parseInt(antalPersoner);
	}

	public int datoStringToInt(String dato) {
		return Integer.parseInt(dato);
	}

	public int månedStringToInt(String måned) {
		return Integer.parseInt(måned);
	}

	public String beregnetPrisDoubleToString(double beregnetPris) {
		return String.valueOf(beregnetPris);
	}

	public int kundenrStringToInt(String kundenr) {
		return Integer.parseInt(kundenr);
	}

}
