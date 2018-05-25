package Main;

public class Nodo 
{
	private Regalo info;
	private Nodo link;
	
	public Nodo(Regalo persona)
	{
		setInfo(persona);
		link=null;
	}

	public Regalo getInfo() 
	{
		return info;
	}

	public void setInfo(Regalo info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}