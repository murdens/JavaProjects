
public class Piece {

	Position position;
	String name;
	Game game = new Game();
	
	 boolean isValidMove(Position newPosition){
	      if(newPosition.row>0 && newPosition.column>0 
	         && newPosition.row<8 && newPosition.column<8){
	         return true;
	      }
	      else{
	         return false;
	      }
	   }
	 
	 	// Method that is responsible for actually moving the piece
	    // (that is, updating the position field within the field's class given a new position as a parameter)
	    public final void movePiece(Position newPosition){
	        this.position = newPosition;                                     
	    }
}

