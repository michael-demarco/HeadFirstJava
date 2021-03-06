import java.util.*;
public class DotComBust {
	
	//declare and initialize the variables we'll need 
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		// first make some dot coms and give them locations
		// make three DotCom objects, give 'em names, and stick 'em in the ArrayList
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		//print brief instructions for the user
		System.out.println("Your goal is to sink the three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		//repeat with all the DotComs in the list
		for (DotCom dotComToSet : dotComsList){
			// ask the helper for a DotCom location
			ArrayList<String> newLocation = helper.placeDotCom(3);
			// call the setter method on this DotCom to give it the location you just got from the helper
			dotComToSet.setLocationCells(newLocation);
		} // close for loop
	} //close setUpGame method
	
	private void startPlaying() {
		// as long as the DotCom list is NOT Empty
		while(!dotComsList.isEmpty()) {
			// get user input
			String userGuess = helper.getUserInput("Enter a guess");
			// call our own checkUserGuess method
			checkUserGuess(userGuess);
		} // close while
		// call our own finishGame method
	} // close startPlaying method
	
	private void checkUserGuess(String userGuess) {
		// increment the number of guesses the user has made
		numOfGuesses++;
		// assume it's a 'miss,' unless told otherwise
		String result = "miss";
		
		// repeat with all the DotComs in the list
		for (DotCom dotComToTest : dotComsList) {
			// ask the DotCom to check the user guess, looking for a hit (or kill)
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				// get out of the loop early, no point in testing the others
				break;
			}
			if (result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		} // close for
	// print the result for the user
	System.out.println(result);
	} // close method
	
	private void finishGame() {
		// print a message telling the user how he did in the game
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are sancing with your options.");
		}
	} // close method
	
	public static void main (String[] args) {
		// create the game object
		DotComBust game = new DotComBust();
		// tell the game object to set up the game
		game.setUpGame();
		// tell the game object to start the main game loop (keeps asking for user input and checking the guess)
		game.startPlaying();
	} // close method
}