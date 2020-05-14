import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

	private Scanner scanner;
	private String movie;
	private static List<String> movies = new ArrayList<String>();
	private int guessCount = 0;
	private String correctGuesses;
	private String wrongGuesses;
	private boolean gameWon = false;
	
	public PlayGame() {
		gameWon=false;
		guessCount=0;
		correctGuesses = "";
		wrongGuesses = "";
		movie="";
	}
	
	public void setUpGame() {
		
		File file = new File("C:\\downloads\\movies.txt");
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			movies.add(line);			
		}
		
		int arraySize = movies.size();
		//randomly select number for index search
		int randomNumber = (int) (Math.random() * arraySize);
		
		// select movie title
		movie = movies.get(randomNumber);
	}
	
	public String getMovie() {
		return movie;
	}

	public void startPlaying() {
		
	String guessLetter = getGuess();
	
	guessCount++;
	
	if (movie.toLowerCase().contains(guessLetter)) {
		correctGuesses += guessLetter;
	}
	else {
		wrongGuesses += guessLetter + " "; 
	}
	
	finishGame();
	}
	
	
	private String getGuess() {
		
		System.out.println("");
		System.out.println("Choose a letter");		
	
		scanner = new Scanner(System.in);
		
		String guess = scanner.next().trim().toLowerCase();
			
		 if(!guess.matches("[a-z]")){
	            System.out.println("That is not a letter.");
	            return getGuess();
	        }
	        else if(wrongGuesses.contains(guess) || correctGuesses.contains(guess)){
	            System.out.println("You already guessed that letter.");
	            return getGuess();
	        }
	        
	 	return guess;
		
	}


	public String cryptoMovie() {
		
		if(correctGuesses.equals("")) {
		return movie.replaceAll ( "[a-z0-9]", " _ " );
		}
		else {
			return movie.replaceAll("[a-z0-9&&[^"+correctGuesses+"]]", " _ ");
		}
		
	}
	

     public boolean finishGame() {
	 
	    if(guessCount >= 10) {
		return true;
	    }
	 
	    if(!cryptoMovie().contains(" _")) {
		gameWon=true;
		return true;
	    }
	 return false;
	 
 }
 
     public boolean getWon() {
	 return gameWon;
    }
}