import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameHelper {
	
	private Scanner scanner;
	private String movie;
	private static List<String> movies = new ArrayList<String>();
	
	// constructor for helper class to set up movie list
	public GameHelper(String path) {
		
		File file = new File(path);
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
	}
	
	// method to chose random
	public String getRandomMovie() {
				
		int arraySize = movies.size();
		//randomly select number for index search
		int randomNumber = (int) (Math.random() * arraySize);
		
		// select movie title
		return movie = movies.get(randomNumber);
	}
			
}