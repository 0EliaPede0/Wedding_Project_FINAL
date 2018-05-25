package Main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws RegaliException, IOException 
	{
		VisualizzaRiordinato ordina = new VisualizzaRiordinato();
		Controlli controlli = new Controlli();
		Menu menu = new Menu();
		SaveRestore SaveRestore = new SaveRestore();
		Regali Lista= new Regali();			//creo la lista
		if (SaveRestore.loadProject(Lista) == true) 
		{
			System.out.println("Caricamento avvenuto con successo");
			System.out.println();
			System.out.println();
		} 
		else 
		{
			System.out.println("Dati non trovati/esistenti o corrotti");
			System.out.println();
			System.out.println();
		}
		Scanner tastiera = new Scanner(System.in);
		int controllo = 0;
		int posizione = 0;
		do
		{
			System.out.println("Voci selezionabili del menu inserendo il numero desiderato: (in caso inserisci un altro numero il programma termina)");
			System.out.println("1)  Aggiungi regalo");
			System.out.println("2)  Visualizza un elemento dalla lista");
			System.out.println("3)  Togli un elemento dalla lista");
			System.out.println("4)  Visualizza tutti gli elementi dalla lista in ordine cronologico");
			System.out.println("5)  Esegui una ricerca in base al codice");
			System.out.println("6)  Compra un certo numero di quote");
			System.out.println("7)  Salvataggio manuale. (Quando si chiude il programma avviene automaticamente)");
			System.out.println("8)  Visualizza tutti gli elementi dalla lista in ordine di prezzo (Alto --> basso)");
			System.out.println("9)  Visualizza tutti gli elementi dalla lista in ordine alfabetico");
			
			controllo = controlli.controlloInputInt();

			switch (controllo) 
			{
			case 1:
				menu.voce1(Lista);
				break;
				
			case 2:
				posizione = 0;
				System.out.println("Inserisci la posizione dell'oggetto che ti interessa visualizzare");
				posizione = controlli.controlloInputInt(); 
				menu.voce2(Lista, posizione);
				break;
				
			case 3:
				posizione = 0;
				System.out.println("Inserisci la posizione dell'oggetto che ti interessa eliminare");
				posizione = controlli.controlloInputInt(); 
				menu.voce3(Lista, posizione);
				break;
				
			case 4:
				menu.voce4(Lista);
				break;
				
			case 5:
				menu.voce5(Lista);
				break;
				
			case 6:
			
				int numeroRegalo = 0;
				System.out.println("Inserisci il numero dell'oggetto che ti interessa");

				do
				{
				numeroRegalo = controlli.controlloInputInt();			
				
				if(numeroRegalo > Lista.getElementi())
				{
					System.out.println("Numero errato riprova");
				}
				else 
				{
					try 
					{
						Lista.getRegalo(numeroRegalo);
						break;
					} 
					catch (RegaliException e)
					{
						System.out.println("Posizione non valida, riprova da capo");
					}
				}
				}while(true);
				menu.voce6(Lista, Lista.getRegalo(numeroRegalo), numeroRegalo);
				break;
				
			case 7:
				SaveRestore.saveProject(Lista);
				System.out.println("Salvataggio eseguito, premi invio per continuare");
				tastiera.nextLine();
				break;
				
			case 8:
				ordina.ordineCostoAltoBasso(Lista);
				System.out.println("Premi invio per continuare");
				tastiera.nextLine();
				break;
			
			case 9:
				ordina.ordineAlfabetico(Lista);
				System.out.println("Premi invio per continuare");
				tastiera.nextLine();
				break;
			
				
			default: 
			System.out.println("Programma terminato");
			controllo = -1;
				break;
			}			
		}while(controllo != -1);
		SaveRestore.saveProject(Lista);
		
		
		
		
		
		
		
		
		


	
	
	
	
	
	
	
	
	}

	
}
