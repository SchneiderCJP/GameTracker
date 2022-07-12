import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Welcome message is displayed
		System.out.println("******************************************");
		System.out.println("Welcome to The Game Tracker!");
		System.out.println("******************************************");
		System.out.println("");
		
		// Scanner is initiated.
		Scanner inp = new Scanner (System.in);
		
		// Game Name variable is initated.
		String gName = "";
				
		// The user is asked to input the speed limit.
		System.out.println("Please enter the name of the game that you would like to play: ");
				
		// The name of the game is collected and assigned to a variable.
		gName = inp.next();
		
		while ( gName.equals("")) {
			
			System.out.println ("You must input a name for the game.");
			System.out.print("Please try again and enter the name of the game you would like to play: ");
			gName = inp.next();
			
		}
		
		// Spaces out the program on console.
		System.out.println("");
	
		String gPlayers = "";
		// The user is asked to input the speed limit.
		System.out.println("Please enter the name of the players playing " + gName + " , seperated by a comma: ");
						
		// The name of the game is collected and assigned to a variable.
		gPlayers = inp.next();
				
		while ( gName.equals("")) {
			
			System.out.println ("You must input the name of atleast one player playing " + gName + " .");
			System.out.print("Please try again and enter the name of the players playing " + gName + " , seperated by a comma: ");
			gName = inp.next();
			
		}
		
		// Spaces out the program on console.
		System.out.println("");
		
		int gRounds = -1;
		// The user is asked to input the speed limit.
		System.out.println("Please enter the total number of rounds for your game of " + gName + ".");
						
		// The name of the game is collected and assigned to a variable.
		gRounds = inp.nextInt();
		
		while ( gRounds < 0) {
			
			System.out.println ("You must have at least one or more rounds of " + gName + " to play.");
			System.out.print("Please try again and enter the total number of rounds for your game of" + gName + ".");
			gName = inp.next();
			
		}
		
		// Spaces out the program on console.
		System.out.println("");
		
		// Sets the game to the class function.
		GameInfo game = new GameInfo(gName, gPlayers, gRounds);     
		System.out.println("Your game of " + gName + " has now been registered.");
		
		// Provides a space on the console.
		System.out.println("");
		
		// Displays instructions on how to input player's points data.
		System.out.println("For the duration of the round, input any points that a "
				+ "player earns by typing the players name, "
				+ "followed by the points that they have earned. ");
		System.out.println(" When you have reached the end of the round, input 'end' as the name to end the round. ");
		
		// Provides a space on the console.
		System.out.println("");
		
		//Sets the variables
		String pName = "";
		Double pPoints = 0.0;
		int totalR = gRounds;
		
		// Creates a while loop that goes through each of the rounds the user specified.
		while (totalR != 0)
		{
			// Checks if the user inputed "end" or else it continues asking the user to input user point data.
			while (!pName.equals("end")){
				
				// asks for the name of the player that they would like to add points to and assigns to variable.
				System.out.println("Enter the name of the player: ");
				pName = inp.next();
				
				// Checks if the user inputed "end" or else it continues on to ask the user to input the points the player recieved
				//and assigns to variable.
				if(!pName.equals("end")) {
					System.out.println("Enter the number of points the player has earned: ");
					pPoints = inp.nextDouble();
					// users function to add points to game data.
					game.addPoints(pName, pPoints);
				}
				else
				{
					break;
				}
				
				
			}
			
			// ends the round and displays a message.
			game.endRound();
			totalR--;
			pName = "";
			System.out.println(" That was the end of round " + (gRounds-totalR) + " .");
			
			// checks to see if it is the last round, if it is not, with a space in between it displays a message.
			if (totalR != 0)
			{
				System.out.println("");
				System.out.println("Your next round will now begin!");
			}
		}
		
		// Provides a space.
		System.out.println("");
		
		//Displays a message that the winner is being calculated
		System.out.println("The winner will now be calculated. . . ");
		
		// Provides a space.
		System.out.println("");
		
		// If else to see how many winners there are and displays the appropriate message.
		if (game.getTotalW() == 1)
		{
			System.out.println("The winner of the " + gRounds + " round(s) of " + gName + " is " + game.getWinner() + ".");
		}
		else if (game.getTotalW() == 2) {
			System.out.println("There is a tie! The winners of the " + gRounds + " round(s) of " + gName + " is " + game.getWinner() + ".");
		}
		else
		{
			System.out.println("The players with the highest scores per the " + gRounds + " round(s) of " + gName + " is " + game.getWinner() + ".");
		}

		// Provides a space.
		System.out.println("");
		
		//Provides a closing message.
		System.out.println("What a great game!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//inp is closed
		inp.close();
		
	}

}
