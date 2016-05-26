package data;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

public class CSV {
	
	
	// Creating a singleton class.
	private static CSV instance = null;

	private CSV() {
		// Exists only to defeat instantiation.
	}

	public static CSV getInstance() {
		if (instance == null) {
			instance = new CSV();
		}
		return instance;
	}
	
	
	public void lavCSVfil(ArrayList<String> resultatListe){		
	
		try {
			
			FileWriter writer = new FileWriter("C:\\opt\\test.csv");
			System.out.println(resultatListe.size());
			for (int j = 0; j < 2 ; j++) { // resultatListe.size() - laver alt for mange
				
				writer.write("Bestil ID");
				writer.write(";");
				writer.write("Start Vej og nr");
				writer.write(";");
				writer.write("Start By");
				writer.write(";");
				writer.write("Start Postnr.");
				writer.write(";");
				writer.write("Start Kommune");
				writer.write(";");
				writer.write("Slut Vej og nr.");
				writer.write(";");
				writer.write("Slut By");
				writer.write(";");
				writer.write("Slut Postnr.");
				writer.write(";");
				writer.write("Slut Kommune");
				writer.write(";");
			}
			
			writer.write('\n');
			
				for (int i = 0; i < resultatListe.size(); i++) {
					writer.append(resultatListe.get(i));
					writer.write(";");
				}

				writer.write("\n");			

				writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
