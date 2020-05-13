import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

	Scanner scanner;
	String movie;
	String cryptoMovie;
	static List<String> movies = new ArrayList<String>();
	int guessCount = 0;
	
	
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
	
		cryptoMovie = movie.replaceAll ( "[a-z0-9]" , " _" );
		System.out.println("Guess The Movie");
		System.out.println("You are guessing: " + cryptoMovie );
		
	}
	

	public void startPlaying() {
		
		System.out.println("");
		System.out.println("Choose a letter");		
	
		scanner = new Scanner(System.in);
		
		String guess = scanner.next();
		//System.out.println(guess);
		checkGuess(guess, movie, cryptoMovie);
	}
	
	private void checkGuess(String guess, String movie, String cryptoMovie) {
		
		guessCount++;
		
		//System.out.println(guessCount);
	}

}

