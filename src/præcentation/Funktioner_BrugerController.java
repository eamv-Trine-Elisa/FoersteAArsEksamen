package præcentation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import data.CSV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;
import logik.MFTScontroller;
import sats.Sats;

public class Funktioner_BrugerController implements Initializable {

	MFTScontroller mfts = new MFTScontroller();

	private boolean beskedIkkebesked = false;

	private String kundenummer;
	private String datoDag;
	private String datoMåned;
	private String afGang_anKomst;
	private String klokkeslæt;
	private String startVej;
	private String startBY;
	private String startPostnummer;
	private String startKommuner;
	private String slutVej;
	private String slutBY;
	private String slutPostnummer;
	private String slutKommuner;
	private String personer;
	private String hjælp;
	private String prisen;

	@FXML
	private Label navn;
	@FXML
	private TextField kundenr;

	@FXML
	private TextField dagDato;
	@FXML
	private TextField månedDato;

	@FXML
	private RadioButton afgang;
	@FXML
	private RadioButton ankomst;
	@FXML
	private ToggleGroup afgang_ankomst;
	@FXML
	private TextField tid;

	@FXML
	private TextField startVejOgNr;
	@FXML
	private TextField startBy;
	@FXML
	private TextField startPostnr;
	@FXML
	private MenuButton startKommune;

	@FXML
	private TextField slutVejOgNr;
	@FXML
	private TextField slutBy;
	@FXML
	private TextField slutPostnr;
	@FXML
	private MenuButton slutKommune;

	@FXML
	private TextField antalPersoner;
	@FXML
	private TextArea hjælpemidler;

	@FXML
	private TextField beregnetPris;
	@FXML
	private Button bestil;
	@FXML
	private Button udregnPris;

	@FXML
	private MenuItem opretHistorik;

	@FXML
	private Label bestilBesked;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void håndterBestilKnap() {
		this.kundenummer = kundenr.getText();
		this.datoDag = dagDato.getText();
		this.datoMåned = månedDato.getText();
		this.klokkeslæt = tid.getText();
		this.startVej = startVejOgNr.getText();
		this.startBY = startBy.getText();
		this.startPostnummer = startPostnr.getText();
		this.startKommuner = startKommune.getText();
		this.slutVej = slutVejOgNr.getText();
		this.slutBY = slutBy.getText();
		this.slutPostnummer = slutPostnr.getText();
		this.slutKommuner = slutKommune.getText();
		this.personer = antalPersoner.getText();
		this.hjælp = hjælpemidler.getText();
		this.prisen = beregnetPris.getText();

		if (afgang.isSelected()) {
			this.afGang_anKomst = afgang.getText();

		} else {
			this.afGang_anKomst = ankomst.getText();
		}

		 bestilling();

		if (beskedIkkebesked == true) {
			besked("Bestillling gennemført");
		} else {
			besked("Bestilling ikke gennemført");
		}
	}

	public void bestilling() {
		beskedIkkebesked = mfts.bestilKørsel(personer, startVej, startBY, startPostnummer, startKommuner, slutVej,
				slutBY, slutPostnummer, slutKommuner, datoDag, datoMåned, klokkeslæt, afGang_anKomst, hjælp, prisen,
				kundenummer);
	}

	public void lavHistorik() {
		mfts.lavCSVfil(kundenr.getText());
		besked("CSV fil oprettet");
	}

	public void findPris() {
		String pris = mfts.udfyldBestillingsblanket(personer, startVej, startBY, startPostnummer, startKommuner,
				slutVej, slutBY, slutPostnummer, slutKommuner, datoDag, datoMåned);

		beregnetPris.setText(pris);
	}

	public void beskedNårPrisFindes() {
		besked("Pris er ved at blive fundet");
	}

	public void prisUdregning() {
		int personerItal = Integer.parseInt(antalPersoner.getText());

		this.datoDag = dagDato.getText();
		this.datoMåned = månedDato.getText();
		this.startVej = startVejOgNr.getText();
		this.startBY = startBy.getText();
		this.startPostnummer = startPostnr.getText();
		this.startKommuner = startKommune.getText();
		this.slutVej = slutVejOgNr.getText();
		this.slutBY = slutBy.getText();
		this.slutPostnummer = slutPostnr.getText();
		this.slutKommuner = slutKommune.getText();
		this.personer = antalPersoner.getText();

		if (dagDato.getText().isEmpty() || månedDato.getText().isEmpty() || startVejOgNr.getText().isEmpty()
				|| startBy.getText().isEmpty() || startPostnr.getText().isEmpty() || startKommune.getText().isEmpty()
				|| slutVejOgNr.getText().isEmpty() || slutBy.getText().isEmpty() || slutPostnr.getText().isEmpty()
				|| slutKommune.getText().isEmpty()) {

			besked("Oplysninger mangler");

		} else {

			if (personerItal > 0 && personerItal < 6) {

				findPris();

				bestil.setDisable(false);
				besked("Pris fundet");

			} else {
				besked("Person antal skal være under 5");
			}
		}
	}

	public void besked(String besked) {
		bestilBesked.setText(besked);
	}

	
	
	// Det der kommer ned af, er de kommuner man kan vælge for at få en pris...
	@FXML
	private MenuItem startAarhus;

	public void menuTekstTilAarhusStart() {
		String menuItem = startAarhus.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startFavrskov;

	public void menuTekstTilFavrskovStart() {
		String menuItem = startFavrskov.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startHedensted;

	public void menuTekstTilHedenstedStart() {
		String menuItem = startHedensted.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startHerning;

	public void menuTekstTilHerningStart() {
		String menuItem = startHerning.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startHolstebro;

	public void menuTekstTilHolstebroStart() {
		String menuItem = startHolstebro.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startHorsens;

	public void menuTekstTilHorsensStart() {
		String menuItem = startHorsens.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startIkast_Brande;

	public void menuTekstTilIkast_BrandeStart() {
		String menuItem = startIkast_Brande.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startLemvig;

	public void menuTekstTilLemvigStart() {
		String menuItem = startLemvig.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startNorddjurs;

	public void menuTekstTilNorddjursStart() {
		String menuItem = startNorddjurs.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startOdder;

	public void menuTekstTilOdderStart() {
		String menuItem = startOdder.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startRanders;

	public void menuTekstTilRandersStart() {
		String menuItem = startRanders.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startRingkøbing_Skjern;

	public void menuTekstTilRingkøbing_SkjernStart() {
		String menuItem = startRingkøbing_Skjern.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startSamsø;

	public void menuTekstTilSamsøStart() {
		String menuItem = startSamsø.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startSilkeborg;

	public void menuTekstTilSilkeborgStart() {
		String menuItem = startSilkeborg.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startSkanderborg;

	public void menuTekstTilSkanderborgStart() {
		String menuItem = startSkanderborg.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startSkive;

	public void menuTekstTilSkiveStart() {
		String menuItem = startSkive.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startStruer;

	public void menuTekstTilStruerStart() {
		String menuItem = startStruer.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem startSyddjurs;

	public void menuTekstTilSyddjursStart() {
		String menuItem = startSyddjurs.getText();
		startKommune.setText(menuItem);
	}

	
	//Slut Kommunerne begynder
	
	@FXML
	private MenuItem startViborg;

	public void menuTekstTilViborgStart() {
		String menuItem = startViborg.getText();
		startKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutAarhus;

	public void menuTekstTilAarhusSlut() {
		String menuItem = slutAarhus.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutFavrskov;

	public void menuTekstTilFavrskovSlut() {
		String menuItem = slutFavrskov.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutHedensted;

	public void menuTekstTilHedenstedSlut() {
		String menuItem = slutHedensted.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutHerning;

	public void menuTekstTilHerningSlut() {
		String menuItem = slutHerning.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutHolstebro;

	public void menuTekstTilHolstebroSlut() {
		String menuItem = slutHolstebro.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutHorsens;

	public void menuTekstTilHorsensSlut() {
		String menuItem = slutHorsens.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutIkast_Brande;

	public void menuTekstTilIkast_BrandeSlut() {
		String menuItem = slutIkast_Brande.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutLemvig;

	public void menuTekstTilLemvigSlut() {
		String menuItem = slutLemvig.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutNorddjurs;

	public void menuTekstTilNorddjursSlut() {
		String menuItem = slutNorddjurs.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutOdder;

	public void menuTekstTilOdderSlut() {
		String menuItem = slutOdder.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutRanders;

	public void menuTekstTilRandersSlut() {
		String menuItem = slutRanders.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutRingkøbing_Skjern;

	public void menuTekstTilRingkøbing_SkjernSlut() {
		String menuItem = slutRingkøbing_Skjern.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutSamsø;

	public void menuTekstTilSamsøSlut() {
		String menuItem = slutSamsø.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutSilkeborg;

	public void menuTekstTilSilkeborgSlut() {
		String menuItem = slutSilkeborg.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutSkanderborg;

	public void menuTekstTilSkanderborgSlut() {
		String menuItem = slutSkanderborg.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutSkive;

	public void menuTekstTilSkiveSlut() {
		String menuItem = slutSkive.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutStruer;

	public void menuTekstTilStruerSlut() {
		String menuItem = slutStruer.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutSyddjurs;

	public void menuTekstTilSyddjursSlut() {
		String menuItem = slutSyddjurs.getText();
		slutKommune.setText(menuItem);
	}

	@FXML
	private MenuItem slutViborg;

	public void menuTekstTilViborgSlut() {
		String menuItem = slutViborg.getText();
		slutKommune.setText(menuItem);
	}

}