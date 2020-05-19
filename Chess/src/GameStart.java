
public class GameStart {

	public static void main(String[] args) {
			
		Queen queen = new Queen();
		Position position = new Position(4, 4);
		
		  if (queen.isValidMove(position)) {
	            System.out.println("Yes, I can move there!");
	        } else {
	            System.out.println("No, it's impossible!");
	        }
		
	}

}
