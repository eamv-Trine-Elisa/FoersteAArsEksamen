package data;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CSV {
	
	public void lavCSVfil(ArrayList<String> resultatListe){
		int i = 1;
		
		
		try {
			FileWriter writer = new FileWriter("C:\\opt\\test.csv");

			for (i = 0; i < resultatListe.size(); i++) {
				writer.write("Bestil_ID");
				writer.write(";");
				writer.append(resultatListe.get(i));
			
			}
			

			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
