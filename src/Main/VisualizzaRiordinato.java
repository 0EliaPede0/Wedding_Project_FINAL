package Main;

public class VisualizzaRiordinato 
{
	public void ordineCostoAltoBasso(Regali lista) throws RegaliException
	{
		boolean controllo = true;
		int elementi = lista.getElementi()+1;
		Regali listatemp = new Regali();
		for (int i = 1; i < elementi; i++) 
		{
			listatemp.inserisciInPosizione(lista.getRegalo(i), i);
		}
		elementi--;
	do
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (listatemp.getRegalo(i).getCosto() < listatemp.getRegalo(i+1).getCosto())
			{
				listatemp.inserisciInPosizione(listatemp.getRegalo(i+1), i);
				listatemp.eliminaInPosizione(i+2);
				controllo = false;
			}
			else
			{
			}
		}
	}while(controllo == false);			//false = controllo non passato, non in ordine
		elementi++;
		for (int i = 1; i < elementi; i++) 
		{
			listatemp.getRegalo(i).toStringPede(i);
		}
		System.out.println("Visualizzazione completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	public void ordineAlfabetico(Regali lista) throws RegaliException
	{
		boolean controllo = true;
		int elementi = lista.getElementi()+1;
		Regali listatemp = new Regali();
		for (int i = 1; i < elementi; i++) 
		{
			listatemp.inserisciInPosizione(lista.getRegalo(i), i);
		}
		elementi--;
	do
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (listatemp.getRegalo(i).getDesrizione().compareTo(listatemp.getRegalo(i+1).getDesrizione()) > 0)
			{
				listatemp.inserisciInPosizione(listatemp.getRegalo(i+1), i);
				listatemp.eliminaInPosizione(i+2);
				controllo = false;
			}
			else
			{
			}
		}
	}while(controllo == false);			//false = controllo non passato, non in ordine
		elementi++;
		for (int i = 1; i < elementi; i++) 
		{
			listatemp.getRegalo(i).toStringPede(i);
		}
		System.out.println("Visualizzazione completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	
	
	
	
	
}
