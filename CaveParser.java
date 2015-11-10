
public class CaveParser 
{
	private String theJSON;
	
	public CaveParser(String json)
	{
		this.theJSON = json;
	}
	
	public static void parse(String json)
	{
		for(int i=1; i< json.length(); i++)
		{
			if(json.charAt(i) == '"')
			{
				System.out.println("JSONObject Start");
			}
			if(json.charAt(i) == '"' && json.charAt(i+1)==':')
			{
				System.out.println("JSONObject End");
			}
			
			if((json.charAt(i) == ':' && json.charAt(i+1)=='['))
			{
				System.out.println("JSONArray Start");
			}
			if(json.charAt(i) == ']')
			{
				System.out.println("JSONArray End");
			}
			
			
		}
		
	}
}
