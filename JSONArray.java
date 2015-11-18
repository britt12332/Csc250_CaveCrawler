
public class JSONArray 
{
	private JSONVariable[] theVariables;
	private int currSize;
	
	public JSONArray()
	{
		this.theVariables = new JSONVariable[50];
		this.currSize = 0;
	}
	
	public void addVariable(JSONVariable jv)
	{
		if(this.currSize < this.theVariables.length)
		{
			this.theVariables[this.currSize] = jv;
			this.currSize++;
		}
	}
	
	public void display()
	{
		System.out.println("JSON Array - Num Vars: " + this.currSize);
		for(int i = 0; i < this.currSize; i++)
		{
			theVariables[i].display();
		}
	}
	
	

}