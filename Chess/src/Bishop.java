
public class Bishop extends Piece {
	
	int column;
	int row;
	

	public Bishop() {
		super();
		this.name = "bishop";
	}
	
	
	boolean isValidMove(Position newPosition){

		 if(!super.isValidMove(position)) {
			 return false;
		 }
	    
	      if(Math.abs(newPosition.column - this.column) == Math.abs(newPosition.row - this.row)){
	         return true;
	      }
	      else{
	         return false;
	      }
	   }

}
