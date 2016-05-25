package logik;

import java.time.LocalDate;
import java.util.Random;

import sats.Sats;
import sats.UnknownKommuneException;

public class Beregner {

	private String fraKommune;
	private String tilKommune; 
	private int month; 
	private int day;
	private int antalPersoner;
	
	public double beregnPris(int antalPersoner, String startVejOgNr, String startBy, String startPostnr,
			String startKommune, String slutVejOgNr, String slutBy, String slutPostnr, String slutKommune, int dato,
			int måned) {
	
		this.month = måned;
		this.day = dato;
		this.antalPersoner = antalPersoner;
		
		return beregnPrisIalt();
	}
	
	private double beregnPrisIalt() {
		double beregnetPris= 0;
		double kilometer = setKilometer();
		double sats = getSats();
		double halvSats = sats/2;
		double pris = kilometer * sats;
		
		if(antalPersoner == 1){
			beregnetPris = pris;
			
		}else{
			beregnetPris = pris + (kilometer * halvSats * (antalPersoner -1));
		}

		
		return beregnetPris;
	}

	private int findÅr() {
		int år;
		
		år = LocalDate.now().getYear();
		
		return år;
	}

	private double setKilometer() {
		double kilometer = 0;
		Random random = new Random();
		
		kilometer = random.nextDouble()*100;
		
		return kilometer;
	}


	private double getSats(){
		Sats sats = Sats.i();
		double beregnetSats = 0;
		int year = findÅr();
		
		
		
		try {
		beregnetSats = sats.getSats(fraKommune, tilKommune, year, month, day);
			
		} catch (UnknownKommuneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beregnetSats;
	}
}
