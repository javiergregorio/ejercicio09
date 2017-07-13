package es.cic.taller.ejercicio09.mus;

import java.util.ArrayList;
import java.util.List;

public class Tapete {
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Carta carta4;
	
	public Carta getCarta1() {
		return carta1;
	}
	public void setCarta1(Carta carta1) {
		this.carta1 = carta1;
	}
	public Carta getCarta2() {
		return carta2;
	}
	public void setCarta2(Carta carta2) {
		this.carta2 = carta2;
	}
	public Carta getCarta3() {
		return carta3;
	}
	public void setCarta3(Carta carta3) {
		this.carta3 = carta3;
	}
	public Carta getCarta4() {
		return carta4;
	}
	public void setCarta4(Carta carta4) {
		this.carta4 = carta4;
	}
	
	public int getPuntuacion() {
		return 
				carta1.getNumero().getValor() +
				carta2.getNumero().getValor() + 
				carta3.getNumero().getValor() + 
				carta4.getNumero().getValor();
	}
	
	public static int compararMayor(Tapete tapete1, Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenas(tapete2);
		
		int resultado = 0;
		
		for (int i = 0 ; i< listaCartasTapete1.size(); i++) {
			int numero1 = listaCartasTapete1.get(i).getNumero().getNumeroReal();
			int numero2 = listaCartasTapete2.get(i).getNumero().getNumeroReal();
			
			if (numero1 != numero2) {
				resultado = numero2 - numero1;
				break;
			}
		}
		return resultado;		
	}	
	
	public static int compararMenor(Tapete tapete1, Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenas(tapete2);
		
		int resultado = 0;
		
		for (int i = listaCartasTapete1.size() - 1; i >= 0; i--) {
			int numero1 = listaCartasTapete1.get(i).getNumero().getNumeroReal();
			int numero2 = listaCartasTapete2.get(i).getNumero().getNumeroReal();
			
			if (numero1 != numero2) {
				resultado = numero1 - numero2;
				break;
			}
		}
		return resultado;		
	}
	
	
	public static boolean hayPares() {
		
		List<Carta> listaCartas = new ArrayList<>();
		
		for (int i = 0; i < listaCartas.size(); i++) {
			
			
		}
		
		
		return true;
	}
	
	
	
	public static int juego(Tapete tapete1, Tapete tapete2) {
		
		int puntuacion1 = tapete1.getPuntuacion();
		int puntuacion2 = tapete2.getPuntuacion();
		
		int resultado = 0;
		
		if ((puntuacion1 | puntuacion2) > 30) {
			if (puntuacion1 != puntuacion2) {
				resultado = puntuacion1 - puntuacion2;
				
			}
		}
		
		
		return resultado;
	}
	
	
	
	
	private static List<Carta> getCartasOrdenas(Tapete tapete) {
		List<Carta> listaCartas = new ArrayList<>();
		listaCartas.add(tapete.getCarta1());
		listaCartas.add(tapete.getCarta2());
		listaCartas.add(tapete.getCarta3());
		listaCartas.add(tapete.getCarta4());
		
		for (int i = 0; i < listaCartas.size() - 1; i++) {
			int indiceMayor = i;
			for (int j = i + 1; j < listaCartas.size(); j++) {
				if (listaCartas.get(j).getNumero().getNumeroReal() > 
					listaCartas.get(indiceMayor).getNumero().getNumeroReal()) {
					indiceMayor = j;
				}
				
			}
			Carta aux = listaCartas.get(i);
			listaCartas.set(i, listaCartas.get(indiceMayor));
			listaCartas.set(indiceMayor, aux);

		}
		return listaCartas;
	}
	
}
