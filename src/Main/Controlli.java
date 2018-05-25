package Main;

import java.util.Scanner;

public class Controlli 
{
	public int controlloInputInt()
	{
		Scanner tastiera = new Scanner(System.in);
		int controllo = 0;
		do
		{
		try 
		{
			controllo  = tastiera.nextInt();
			break;
		} 
		catch (java.util.InputMismatchException e) 
		{
			System.out.println("Inserimento sbagliato... RIPROVA");
			tastiera.nextLine();
		}	
		}while(true);
		
		return controllo;
	}
	
	
	
	
}
