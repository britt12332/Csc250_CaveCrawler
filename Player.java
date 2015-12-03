import java.util.Scanner;
import java.io.*;


public class Player 
{
	private String name;
	private Scanner input;
	private Room currentRoom;
	
	public Player(String name)
	{
		this.name = name;
		this.input = new Scanner(System.in);
		this.currentRoom = null;
	}
	
	public void setCurrentRoom(Room r)
	{
		this.currentRoom = r; 
	}
	
	public void displayToUser(String msg)
	{
		System.out.println(msg);
	}
	
	public void showPrompt()
	{
		System.out.print("> ");
		String userResponse = this.input.nextLine();
		System.out.println(userResponse);
		
		//*******
		//We need to process the players command to move to a new room
		if(userResponse.equalsIgnoreCase("look"))
		{
			this.currentRoom.displayDetailsToUser();
		}
		else if(userResponse.equals("create exit"))
		{
			this.displayToUser("***** Creating Exit *****");
			this.displayToUser("Please enter the name of the exit:" );
			System.out.print("> ");
			userResponse = this.input.nextLine();
			String exitName = userResponse;
			
			this.displayToUser("Please enter the name of the return exit:" );
			System.out.print("> ");
			userResponse = this.input.nextLine();
			String returnExit = userResponse;
			
			this.displayToUser("Please enter the name of the new Room" );
			System.out.print("> ");
			userResponse = this.input.nextLine();
			String newRoomName = userResponse;
			
			//Add the new room to our CaveCore
			int newRoomID = CaveCore.addRoomToCave(newRoomName, returnExit, this.currentRoom.getId());
			
			//finally add the exit that leads to the new room here!
			this.currentRoom.addExit(exitName, newRoomID);
			
			this.displayToUser("New Room Created");
			this.showPrompt();
		}
		else if(userResponse.equals("save"))
		{
			String savedData = "";
			this.displayToUser("Saving the Cave");
			this.displayToUser(CaveCore.theCave.toJSON().exportToJSON());
			savedData = CaveCore.theCave.toJSON().exportToJSON();
			
			File file = new File("C:\\Users\\brittany\\workspace1\\CaveCrawler\\bin\\caveJSON");
			DataOutputStream outstream = null;
			try 
			{
				outstream = new DataOutputStream(new FileOutputStream(file,false));
			} 
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
			String body = savedData;
			try 
			{
				outstream.write(body.getBytes());
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			try
			{
				outstream.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			this.currentRoom.takeExit(userResponse);
		}
		
	}
}