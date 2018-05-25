package Main;

public class RegaliException extends Exception 
{
	private String messaggio;
	
	public RegaliException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
