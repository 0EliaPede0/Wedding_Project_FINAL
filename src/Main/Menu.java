package Main;

import java.io.IOException;
import java.util.Scanner;

public class Menu 
{
	public void voce1(Regali lista) throws RegaliException 		//aggiugni alla lista
	{
		Controlli controlli = new Controlli();
		int a = 0, b = 0, c = 0;
		String descrizione = null;
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci codice regalo");	//in teoria sarebbe consigliabile mettere un controllo sul codice in modo che non vi siano duplicati ma in qualsiasi caso non ci baseremo sul codice ma sul numero in lista e quindi il codice piò essere identificativo di più regali
		a = controlli.controlloInputInt();
		System.out.println("Inserisci prezzo regalo");
		b = controlli.controlloInputInt();
		System.out.println("Inserisci quote regalo");
		c = controlli.controlloInputInt();
		System.out.println("Inserisci la descrizione del regalo");
		descrizione = tastiera.nextLine();
		Regalo R = new Regalo(a, b, c, descrizione);
		//--------------------------------------------------
		lista.inserisciInPosizione(R, lista.getElementi()+1);
		System.out.println("Inserimento avvenuto correttamente");
		System.out.println();
	}
	
	public void voce2(Regali lista, int posizione) 		//visualizza elemento dalla lista
	{
		try 
		{
			lista.getRegalo(posizione).toStringPede(posizione);
		} 
		catch (RegaliException e)
		{
			System.out.println("Posizione non valida, riprova da capo");
		}
	}
	
	public void voce3(Regali lista,  int posizione) 		//togli dalla lista
	{
		try 
		{
			lista.eliminaInPosizione(posizione);
			System.out.println("Eliminazione avvenuta correttamente");
			System.out.println();
		} 
		catch (RegaliException e) 
		{
			System.out.println("Posizione non valida, riprova da capo");
		}

	}
	
	public void voce4(Regali lista) 		//visualizza tutti gli elementi della lista
	{
		Scanner tastiera = new Scanner(System.in);
		Menu menu = new Menu();
		int i=lista.getElementi();
		for (int j = 1; j <= i; j++) 
		{
			menu.voce2(lista, j);
		}
		System.out.println("Visualizzazione completa"); System.out.println();
		System.out.println("Premi invio per continuare");
		tastiera.nextLine();
	}
	
	public void voce5(Regali lista) throws RegaliException			//ricerca in base al codice
	{
		Controlli controlli = new Controlli();
		int codice;
		System.out.println("Inserisci il codice dell'oggetto"); System.out.println();
		Scanner tastiera = new Scanner(System.in);
		codice = controlli.controlloInputInt();
		
		int i = 1;
		int elementi = lista.getElementi();
		while(i != elementi+1)
		{
			if(codice == lista.getRegalo(i).codice)
			{
				lista.getRegalo(i).toStringPede(i);
				i++;
			}
			else
			{i++;}			
		}
		System.out.println("Ricerca completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	public void voce6 (Regali lista, Regalo R, int posizione) throws RegaliException, IOException //compra un certo numero di quote

	{
		Controlli controlli = new Controlli();
		Scanner tastiera = new Scanner(System.in);
		int quotecomprate = 0;	
		do
		{
			System.out.println("Inserisci il numero di quote che desideri comprare");
			quotecomprate = controlli.controlloInputInt();
		if ((R.getNumeroQuoteVendute() + quotecomprate) > R.getNumeroQuote() || quotecomprate <= 0) 
		{
			System.out.println("Inserimento non valido hai provato a comprare troppo, riprova...");
		} 
		else 
		{
			String nome = null;
			System.out.println("Bravo, puoi comprare. inserisci il tuo nome:");
			nome = tastiera.nextLine();
			R.setNomeAcquirenti(lista, nome, R, quotecomprate, posizione);
			break;
		}
		}while(true);

		
	}
	
	
	
	
	
	
	
	
}
