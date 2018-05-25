package Test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Main.Regalo;

public class RegaloTest {

	Regalo regalo = new Regalo(456, 456, 456, "Ciao Bello");
	
	@Test
	public void testGetNomeAcquirenti() throws Exception 
	{
		assertEquals(regalo.getNomeAcquirenti(0), null);
	}

	@Test
	public void testGetCodice() throws Exception 
	{
		assertEquals(regalo.getCodice(), 456);
	}

	@Test
	public void testGetNumeroQuote() throws Exception
	{
		assertEquals(regalo.getNumeroQuote(), 456);
	}

	@Test
	public void testGetNumeroQuoteVendute() throws Exception 
	{
		assertEquals(regalo.getNumeroQuote(), 456);
	}

	@Test
	public void testGetCosto() throws Exception 
	{
		assertEquals(regalo.getCosto(), 456, 0);
	}

	@Test
	public void testGetDesrizione() throws Exception 
	{
		assertEquals(regalo.getDesrizione(), "Ciao Bello");
	}

}
