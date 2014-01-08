package JSON;

public class Station 
{
	private String name;

	public Station()
	{
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString()
	{
		return name;
		
	}

}
