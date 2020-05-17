

public class GuessTheMovie {
	
	
	public static void main(String[] args) {																																																																																																																																																																																			
		
				
	PlayGame playGame = new PlayGame("C:\\Downloads\\movies.txt");
	
	System.out.println("Guess The Movie");
	System.out.println("You have 10 guesses to reveal the title of a Movie");
	
	while(!playGame.finishGame()) {
		System.out.println("You are guessing: " + playGame.cryptoMovie());
		System.out.println("You have had " + playGame.getGuessCount() + " guesses");
		System.out.println("Your incorrect letter guesses are: " + playGame.getWrongGuesses());
		playGame.startPlaying();
	}
	
	if(playGame.getWon()) {
		 System.out.println("Congratulation you won!");
         System.out.println("You have guessed " + playGame.getMovie()+".");
		
	}
	
	else {
		 System.out.println("Sorry you lost!");
		 System.out.println("The movie was " + playGame.getMovie()+".");
	}
  }
}