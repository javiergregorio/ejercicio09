package es.cic.taller.ejercicio09;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;

import es.cic.taller.ejercicio09.mus.Carta;
import es.cic.taller.ejercicio09.mus.Tapete;

public class TapeteForm extends FormLayout {
	
	private HorizontalLayout horizontalLayout = new HorizontalLayout();
	
	private Image imagen1 = new Image();
	private Image imagen2 = new Image();
	private Image imagen3 = new Image();
	private Image imagen4 = new Image();
	
	
	private MyUI myUI;
	
	public TapeteForm(MyUI myUI) {
		this.myUI = myUI;

		horizontalLayout.addComponents(imagen1, imagen2, imagen3, imagen4);
		
		addComponents(horizontalLayout);
	}
	
	
	private Resource getImageResource(String recurso) {
		String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +
                "/images/" + recurso));
        return resource;
	}


	public void setTapete(Tapete tapete) {

		cargaCarta(tapete.getCarta1(), imagen1);
		cargaCarta(tapete.getCarta2(), imagen2);
		cargaCarta(tapete.getCarta3(), imagen3);
		cargaCarta(tapete.getCarta4(), imagen4);
	}


	private void cargaCarta(Carta carta, Image imagen) {

		imagen.setSource(getImageResource(carta.getNombreFichero()));
		imagen.setWidth("100px");
		imagen.setHeight("200px");
	}
	
}
