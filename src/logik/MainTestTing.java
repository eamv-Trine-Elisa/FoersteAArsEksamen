package logik;

import java.time.LocalDate;
import java.util.Random;

import sats.Sats;
import sats.UnknownKommuneException;

public class MainTestTing {

	static String fraKommune = "Herning";
	static String tilKommune = "Holstebro";
	static int month = 5;
	static int day = 30;
	static int antalPersoner = 4;
	
	public static void main(String[] args) {
		System.out.println(beregnPrisIalt());

	}

	public static double beregnPrisIalt() {
		double beregnetPris = 0;
		double kilometer = setKilometer();
		double sats = getSats();
		double halvSats = sats / 2;
		double pris = kilometer * sats;

		if (antalPersoner == 1) {
			beregnetPris = pris;

		} else {
			beregnetPris = pris + (kilometer * halvSats * (antalPersoner - 1));
		}
		
		System.out.println(pris + " pris på 1");
		System.out.println(kilometer * halvSats * (antalPersoner - 1)+" halv sats");
System.out.println(beregnetPris + " beregnet pris");
		return beregnetPris;
	}

	public static int findÅr() {
		int år;

		år = LocalDate.now().getYear();

		return år;
	}

	public static double setKilometer() {
		double kilometer = 0;
		Random random = new Random();

		kilometer = random.nextDouble() * 100;
System.out.println(kilometer +" kilometer");
		return kilometer;
	}

	public static double getSats() {
		Sats sats = Sats.i();
		double beregnetSats = 0;
		int year = findÅr();

		try {
			beregnetSats = sats.getSats(fraKommune, tilKommune, year, month, day);

		} catch (UnknownKommuneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(beregnetSats + " beregnetsats");
		return beregnetSats;
	}

}