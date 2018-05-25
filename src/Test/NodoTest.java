package Test;
import static org.junit.Assert.*;
import org.junit.Test;

import Main.Nodo;
import Main.Regalo;

public class NodoTest {

	Regalo regalo = new Regalo(456, 456, 456, "Ciao bello");
	Nodo nodo = new Nodo(regalo);
	
	@Test
	public void testGetInfo() throws Exception 
	{
		assertEquals(nodo.getInfo(), regalo);
	}

	@Test
	public void testGetLink() throws Exception 
	{
		assertEquals(nodo.getLink(), null);
	}

}
