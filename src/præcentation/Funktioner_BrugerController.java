package præcentation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
	private ProgressBar vente;

	@FXML
	private MenuItem opretHistorik;

	@FXML
	private Label bestilBesked;

	@FXML
	private MenuItem startHerning;
	@FXML
	private MenuItem startHolstebro;
	@FXML
	private MenuItem slutHerning;
	@FXML
	private MenuItem slutHolstebro;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* kommuneMenuting(); */
		// Bruges til aftomatisk at lave menu items fra flemmings array

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

	public void ting(){
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

	/*
	 * public void kommuneMenuting() { //Bruges til aftomatisk at lave menuItem
	 * Sats sats = Sats.i();
	 * 
	 * for (int i = 0; i < sats.getKommuner().length; i++) {
	 * 
	 * slutKommune.getItems().addAll(FXCollections.observableArrayList(new
	 * MenuItem(sats.getKommuner()[i]))); } }
	 */

	public void menuTekstTilHerningstart() {

		String menuItem;
		menuItem = startHerning.getText();

		startKommune.setText(menuItem);
	}

	public void menuTekstTilHolstebroslut() {

		String menuItem;
		menuItem = slutHolstebro.getText();

		slutKommune.setText(menuItem);
	}

	public void besked(String besked) {
		bestilBesked.setText(besked);
	}

}
