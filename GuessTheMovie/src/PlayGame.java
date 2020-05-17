
import java.util.Scanner;

public class PlayGame {

	private Scanner scanner;
	private String movie;
	private int guessCount;
	private String correctGuesses;
	private String wrongGuesses;
	private boolean gameWon = false;
	

	// class constructor, calls class to set up game.
	public PlayGame(String path) {
		GameHelper helper = new GameHelper(path);
		movie = helper.getRandomMovie();
		gameWon=false;
		guessCount=0;
		correctGuesses = "";
		wrongGuesses = "";
	}
	
	//	Method to assess game play
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
	
		
	// method to obtain user input
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


	// method to display movie
	public String cryptoMovie() {
		
		if(correctGuesses.equals("")) {
		return movie.replaceAll ( "[a-z0-9]", " _ " );
		}
		else {
			return movie.replaceAll("[a-z0-9&&[^"+correctGuesses+"]]", " _ ");
		}
		
	}
	

	// method to check scoring of game and declare winner/loser.
     public boolean finishGame() {
	 
	    if(guessCount >= 12) {
		return true;
	    }
	 
	    if(!cryptoMovie().contains(" _")) {
		gameWon=true;
		return true;
	    }
	 return false;
	 
 }
 
    
// Getter methods
     
 	public String getMovie() {
 		return movie;
 	}
   
     
     public int getGuessCount() {
 		return guessCount;
 	}
 	

 	public String getWrongGuesses() {
 		return wrongGuesses;
 	}
     
     
     public boolean getWon() {
	 return gameWon;
    }
}