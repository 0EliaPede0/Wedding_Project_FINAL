package Main;

import java.io.*;

public class SaveRestore 
{
	public void saveProject(Regali lista) throws IOException, RegaliException			//non mi interessa gestire le eccezioni in quanto genero sempre tutto da 0
	{
		ObjectOutputStream out =new ObjectOutputStream ( new BufferedOutputStream (new FileOutputStream ("Data.dat" )));
		int elementi = lista.getElementi(); 
		out.writeObject(elementi);		
		elementi++;
		for (int i = 1; i < elementi; i++)
		{
			out.writeObject(lista.getRegalo(i));			
		}
		out.close();
	}
	
	public boolean loadProject(Regali lista) throws RegaliException			//qua lo gestisco in quanto mi serve sapere se posso caricare o no i dati  
	{
		try
		{
			int elementi = 0;
			ObjectInputStream in =new ObjectInputStream ( new BufferedInputStream (new FileInputStream ("Data.dat" )));
			elementi = (int) in.readObject();
			elementi++;
			Regalo rTemp = new Regalo();
			for (int i = 1; i < elementi; i++) 
			{
				rTemp = (Regalo) in.readObject();
				lista.inserisciInPosizione(rTemp, i);
			}
			in.close();
			return true;
		}
		catch (FileNotFoundException e)			//niente file
		{
			return false;
		}
		catch (IOException e)			//problemi di collegamento (fisici)
		{
			return false;
		}	
		catch (ClassNotFoundException e)			//problemi di corruzione
		{
			return false;
		}
	}
	
	
	
	
}
