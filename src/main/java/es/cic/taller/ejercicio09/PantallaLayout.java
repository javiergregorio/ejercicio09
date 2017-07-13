package es.cic.taller.ejercicio09;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import es.cic.taller.ejercicio09.mus.Baraja;
import es.cic.taller.ejercicio09.mus.Carta;
import es.cic.taller.ejercicio09.mus.Tapete;

public class PantallaLayout extends GridLayout {

	private TapeteForm tapete1;
	private TapeteForm tapete2;
	private TapeteForm tapete3;
	private TapeteForm tapete4;
	
	private MyUI myUI;
	
	private Baraja baraja;
	
	public PantallaLayout(MyUI myUI, Baraja baraja) {
		this.myUI = myUI;
		this.baraja = baraja;
		Tapete manoTapete1 = baraja.getTapete();
		
		tapete1 = new TapeteForm(myUI);
		tapete1.setTapete(manoTapete1);

		
		Tapete manoTapeteDorso = new Tapete();
		manoTapeteDorso.setCarta1(Carta.getDorso());
		manoTapeteDorso.setCarta2(Carta.getDorso());
		manoTapeteDorso.setCarta3(Carta.getDorso());
		manoTapeteDorso.setCarta4(Carta.getDorso());
		
		tapete2 = new TapeteForm(myUI);
		tapete2.setTapete(manoTapeteDorso);
		
		tapete3 = new TapeteForm(myUI);
		tapete3.setTapete(manoTapeteDorso);
		
		tapete4 = new TapeteForm(myUI);
		tapete4.setTapete(manoTapeteDorso);

		
		Button boton1 = new Button("MUS");
		boton1.addClickListener( e -> {
        	
        });
		Button boton2 = new Button("No MUS");
		Button boton3 = new Button("Paso");
		Button boton4 = new Button("Envido");
		Button boton5 = new Button("Ordago");
		
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		HorizontalLayout horizontalLayout1 = new HorizontalLayout();
		HorizontalLayout horizontalLayout2 = new HorizontalLayout();
		
		horizontalLayout1.addComponents(boton1, boton2);
		horizontalLayout2.addComponents(boton3, boton4, boton5);
		
		verticalLayout.addComponents(horizontalLayout1, horizontalLayout2);
		
		setRows(3);
		setColumns(3);
		
		
		addComponent(verticalLayout, 2, 2);
		addComponent(tapete1, 1, 2);
		addComponent(tapete2, 1, 0);
		addComponent(tapete3, 0, 1);
		addComponent(tapete4, 2, 1);

	}
	
	
	
}
