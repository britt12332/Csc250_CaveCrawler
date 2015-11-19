public class JSONObjectVariable extends JSONVariable
{
	private JSONObject value;
	
	public JSONObjectVariable(String name, JSONObject value)
	{
		super(name);
		this.value = value;
	}

	void display() 
	{
		System.out.println(this.name +" -> ");
		this.value.display();
	}

	@Override
	String exportToJSON() 
	{
	 System.out.println(this.name +" ->");	
	 return this.value.exportToJSON();
	}
}