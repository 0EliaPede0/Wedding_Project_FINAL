package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Regalo implements Serializable 
{
	int codice;
	double costo;
	int numeroQuote;
	int numeroQuoteVendute;
	String desrizione;
	String[] nomeAcquirenti;
	
	public Regalo() 
	{
	}
	
	public Regalo(int codice, double costo, int numeroQuote, String desrizione) 
	{
		this.codice = codice;
		this.costo = costo;
		this.numeroQuote = numeroQuote;
		numeroQuoteVendute = 0;
		this.desrizione = desrizione;
		nomeAcquirenti = new String[numeroQuote];
	}	
	public String getNomeAcquirenti(int i) 
	{
		return nomeAcquirenti[i];
	}

	public void setNomeAcquirenti(Regali lista, String nomeAcquirenti, Regalo R, int quotecomprate, int posizione) throws RegaliException, IOException 
	{
		if(numeroQuoteVendute == numeroQuote)
		{
			//elimina oggetto e lo salva su file
			R.StringToFilePede(posizione);
			lista.eliminaInPosizione(posizione);
			R = null;
			System.out.println("Oggetto totalmente comprato, quindi viene eliminato dalla lista");
			System.out.println("--------------------------------------------------");
			System.out.println();
		}
		else
		{
		int i=0;
		do
		{
		if (this.nomeAcquirenti[i]==null)
		{
		this.nomeAcquirenti[i] = nomeAcquirenti;	
		break;
		}
		else
		{
			i++;
		}
		}while (true);
		numeroQuoteVendute=numeroQuoteVendute + quotecomprate;
		}
		if(numeroQuoteVendute == numeroQuote)
		{
			//elimina oggetto e lo salva su file
			R.StringToFilePede(posizione);
			lista.eliminaInPosizione(posizione);
			R = null;
			System.out.println("Oggetto totalmente comprato, quindi viene eliminato dalla lista");
			System.out.println("--------------------------------------------------");
			System.out.println();
		}
		else
		{
			System.out.println("Quote comprate");
			System.out.println("--------------------------------------------------");
			System.out.println();
		}
	}
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getNumeroQuote() {
		return numeroQuote;
	}

	public void setNumeroQuote(int numeroQuote) {
		this.numeroQuote = numeroQuote;
	}

	public int getNumeroQuoteVendute() {
		return numeroQuoteVendute;
	}

	public void setNumeroQuoteVendute(int numeroQuoteVendute) {
		this.numeroQuoteVendute = numeroQuoteVendute;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDesrizione() {
		return desrizione;
	}

	public void setDesrizione(String desrizione) {
		this.desrizione = desrizione;
	}

	public String toString() 
	{
		return "Regalo [codice=" + codice + ", costo=" + costo + ", numeroQuote=" + numeroQuote
				+ ", numeroQuoteVendute=" + numeroQuoteVendute + ", desrizione=" + desrizione + "]";
	}

	public void toStringPede(int posizione) 
	{		
		System.out.println("N in lista " + posizione + ") codice=" + codice + ", costo=" + costo + ", numeroQuote=" + numeroQuote + ", numeroQuoteVendute=" + numeroQuoteVendute );
		System.out.println("Desrizione=		" + desrizione );
		int i=0;
		while(nomeAcquirenti[i] != null)
		{
			System.out.println((nomeAcquirenti[i]));
			i++;
		}
		System.out.println("--------------------------------------------------"); System.out.println();		//spazio per separare la lista degli elementi con annessi 50 puntini di separazione
	}
	public void StringToFilePede(int posizione) throws IOException 
	{		
		PrintWriter file_output =new PrintWriter ( new BufferedWriter (new FileWriter ("Regali venduti.txt", true )));
		
		file_output.println("N in lista " + posizione + ") codice=" + codice + ", costo=" + costo + ", numeroQuote=" + numeroQuote + ", numeroQuoteVendute=" + numeroQuoteVendute );
		file_output.println("Desrizione=		" + desrizione );
		int i=0;
		while(nomeAcquirenti[i] != null)
		{
			file_output.println((nomeAcquirenti[i]));
			i++;
		}
		file_output.println("--------------------------------------------------"); System.out.println();		//spazio per separare la lista degli elementi con annessi 50 puntini di separazione
		file_output . close ();
	}



	

	

}
