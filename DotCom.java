import java.util.*;

public class DotCom {
	// DotCom's instance variables:
	// - an ArrayList of cell locations
	private ArrayList<String> locationCells;
	// - the DotCom's name
	private String name;
	
	// a setter method that updates the DotCom's location. (Random location provided by the gameHelper placeDotCom() method.)
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
	
	// basic setter method
	public void setName(String n) {
		name = n;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		/* The ArrayList indexOf() method in action!
		If the user guess is one of the 
		entries in the ArrayList, indexOf()
		will return its ArrayList location. If
		not, indexOf() will return -1.
		*/
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			// Using ArrayList's remove() method to delete an entry
			locationCells.remove(index);
			
			// Using the isEmpty() method to see if all of the locations have been guessed
			if (locationCells.isEmpty()) {
				result = "kill";
				// Tell the user when a DotCOm has been sunk
				System.out.println("Ouch! You sunk " + name + " : ( ");
			} else {
				result = "hit";
			} // close if
		} // close if
		return result;
		
	} // close method
} // close class

		
		
