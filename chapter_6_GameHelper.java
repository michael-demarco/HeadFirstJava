import java,io.*;
import java.util.*;

public class GameHelper {
	
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int [] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader (
			 new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 ) return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}
	
	public ArrayList<String> placeDotCom(int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		String [] alphacoords = new String [comSize];		// holds 'f6' type coords
		String temp = null;									// temporary String for Concat
		int [] coords = new int[comSize];					// current candidate coords
		int attempts = 0;									// current attempts counter
		boolean success = false;							// flag = found a good location ?
		int location = 0;									// current starting location
		
		comCount++;											// nth dot com to placeDotCom
		int incr = 1;										// set horizontal increment
		if ((comCount % 2) == 1) {							// if odd dot com (place vertically)
			incr = gridLength;								// set vertical increment
		}
		
		while ( !success & attempts++ < 200 ) {				// main search loop (32)
			location = (int) (Math.random() * gridSize);	// get random starting point
			// System.out.print(" try " + location);
			int x = 0;
			
		
		
	 	