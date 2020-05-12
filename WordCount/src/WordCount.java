
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCount {

	
	public static void main(String[] args) {
		File file = new File("C:\\alien.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int words = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			words += line.split("").length;
		}
		System.out.println("The file contains:" + words + " words.");
	}
}
