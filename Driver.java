
import java.io.File;
import java.util.Scanner;


public class Driver 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/bin/caveJSON"));
		String theJSON = "";
		while(input.hasNextLine())
		{
			theJSON = theJSON + input.nextLine();
		}
		System.out.println(theJSON);
		CaveParser.parse(theJSON);
		/*
		Room caveEntrance = new Room("The Cave Entrance");
		Room room2 = new Room("Room #2");
		caveEntrance.addExit("north", room2);
		room2.addExit("south", caveEntrance);
		
		Player thePlayer = new Player("The Follower");
		caveEntrance.addThePlayer(thePlayer);
		*/
	}
	
}
