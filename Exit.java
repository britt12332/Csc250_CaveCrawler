
public class Exit 
{
	private String name = "";
	private static int destinationID = -1;
	
	public Exit(JSONObject obj)
	{
		this.name = ((JSONStringVariable)obj.getVariableForName("name")).getValue();
		this.destinationID = ((JSONNumberVariable)obj.getVariableForName("destinationID")).getValue();
	}

	public String getName() 
	{
		return name;
	}

	public static int getDestinationID() 
	{
		return destinationID;
	}
}