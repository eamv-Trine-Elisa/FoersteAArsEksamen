package data;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CSV {
	
	public void lavCSVfil(ArrayList<String> resultatListe){
	//	int i = 1;
		
		
		try {
			FileWriter writer = new FileWriter("C:\\opt\\test.csv");

			writer.write("Bestil ID");
			writer.write(";");
			writer.write("Start vej og nr");
			writer.write(";");
			writer.write("1");
			writer.write(";");
			writer.write("Bestil ID2");
			writer.write(";");
			writer.write("Bestil ID3");
			writer.write(";");
			writer.write("Bestil ID4");
			writer.write(";");
			writer.write("Bestil ID5");
			writer.write(";");
			writer.write("Bestil ID6");
			writer.write(";");
			writer.write("Bestil ID7");
			writer.write(";");
			writer.write('\n');
			
			for (int i = 0; i < resultatListe.size(); i++) {

				writer.append(resultatListe.get(i));
				writer.write(";");
				
			
			}
			

			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
