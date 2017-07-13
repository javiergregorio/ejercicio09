package es.cic.taller.ejercicio09.mus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TapeteTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPuntuacion() {
			
		 /* Preparo el test*/
		Baraja baraja = new Baraja();
		Tapete tapete = baraja.getTapete();
		
		
		Carta carta1 = tapete.getCarta1();
		Carta carta2 = tapete.getCarta2();
		Carta carta3 = tapete.getCarta3();
		Carta carta4 = tapete.getCarta4();
		
		int resultadoEsperado = 
				carta1.getNumero().getValor() +
				carta2.getNumero().getValor() + 
				carta3.getNumero().getValor() + 
				carta4.getNumero().getValor();
		
		/*Ejecuto el test*/
		int puntuacion = tapete.getPuntuacion();
		
		/*Verifico el test*/
		assertEquals(resultadoEsperado, puntuacion);
	}
	
	@Test
	public void testComparaMayor() {
	
		/* Preparo el test*/
		Tapete tapete1 = new Tapete();
		tapete1.setCarta1(new Carta(Numero.CINCO, Palo.BASTOS));
		tapete1.setCarta2(new Carta(Numero.REY, Palo.BASTOS));
		tapete1.setCarta3(new Carta(Numero.TRES, Palo.BASTOS));
		tapete1.setCarta4(new Carta(Numero.SOTA, Palo.BASTOS));
		
		Tapete tapete2 = new Tapete();
		tapete2.setCarta1(new Carta(Numero.CINCO, Palo.BASTOS));
		tapete2.setCarta2(new Carta(Numero.REY, Palo.BASTOS));
		tapete2.setCarta3(new Carta(Numero.TRES, Palo.BASTOS));
		tapete2.setCarta4(new Carta(Numero.CABALLO, Palo.BASTOS));
		
		/*Ejecuto el test*/
		int resultado = Tapete.compararMayor(tapete1, tapete2);
		
		/*Verifico el test*/
		assertTrue("Espero un número positivo si el segundo jugador gana a Grande", resultado > 0);
		
	}
	
	
	@Test
	public void testComparaMenor() {
	
		/* Preparo el test*/
		Tapete tapete1 = new Tapete();
		tapete1.setCarta1(new Carta(Numero.CINCO, Palo.ESPADAS));
		tapete1.setCarta2(new Carta(Numero.REY, Palo.BASTOS));
		tapete1.setCarta3(new Carta(Numero.TRES, Palo.OROS));
		tapete1.setCarta4(new Carta(Numero.SOTA, Palo.BASTOS));
		
		Tapete tapete2 = new Tapete();
		tapete2.setCarta1(new Carta(Numero.CINCO, Palo.OROS));
		tapete2.setCarta2(new Carta(Numero.REY, Palo.BASTOS));
		tapete2.setCarta3(new Carta(Numero.TRES, Palo.BASTOS));
		tapete2.setCarta4(new Carta(Numero.REY, Palo.ESPADAS));
		
		/*Ejecuto el test*/
		int resultado = Tapete.compararMenor(tapete1, tapete2);
		
		/*Verifico el test*/
		assertTrue("Espero un número negativo si el primer jugador gana a Pequeña", resultado < 0);
		
	}
	

}
