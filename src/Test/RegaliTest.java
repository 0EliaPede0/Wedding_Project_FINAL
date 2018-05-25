package Test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Main.Regali;
import Main.Regalo;

public class RegaliTest {

	Regalo regalo = new Regalo(456, 456, 456, "Ciao Bello");
	Regalo regalo1 = new Regalo(456, 456, 456, "Lol che bello");
	Regalo regalo2 = new Regalo(456, 456, 456, "Visto che funziona tutto?");
	Regali regali = new Regali();
	
	@Test
	public void testGetElementi() throws Exception 
	{
		assertEquals(regali.getElementi(), 0);
	}	

	@Test
	public void testGetRegalo() throws Exception 
	{
		//in testa
		regali.inserisciInPosizione(regalo, 1);			//qui si prova anche inserisci in posizione e di conseguenza proveremo inserisci in coda e in testa
		assertEquals(regali.getRegalo(1), regalo);
		//in coda
		regali.inserisciInPosizione(regalo1, 2);		
		assertEquals(regali.getRegalo(2), regalo1);
		//in posizione
		regali.inserisciInPosizione(regalo2, 2);	
		assertEquals(regali.getRegalo(2), regalo2);
	}


	@Test
	public void testEliminaInPosizione() throws Exception 
	{
		regali.inserisciInPosizione(regalo, 1);		
		assertEquals(regali.getRegalo(1), regalo);		
		assertEquals(regali.getElementi(), 1);		//qui mostriamo che c'è il regalo e quindi gli elementi sono più di 0 (1)
		
		regali.eliminaInPosizione(1);
		assertEquals(regali.getElementi(), 0);		//qui gli elementi sono 0 quindi ha funzionato
		
		//ora testiamo anche elimina in coda e in testa
		
		regali.inserisciInPosizione(regalo, 1);			
		regali.inserisciInPosizione(regalo1, 2);
		regali.inserisciInPosizione(regalo2, 2);	
		regali.eliminaInPosizione(2);
		assertEquals(regali.getRegalo(2), regalo1); //elimino in posizione
		regali.eliminaInPosizione(1);
		assertEquals(regali.getRegalo(1), regalo1); //elimino in coda
		regali.eliminaInPosizione(1); //elimino in testa
		assertEquals(regali.getElementi(), 0);		//qui gli elementi sono 0 quindi ha funzionato
	}


}
