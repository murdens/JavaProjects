
public class Queen extends Piece {
	
	int column;
	int row;
	

	public Queen() {
		super();
		this.name = "queen";
	}
	
	
	 boolean isValidMove(Position newPosition){

		 if(!super.isValidMove(position)) {
			 return false;
		 }
		 
	      if(newPosition.column == this.column || newPosition.row == this.row ||
	      Math.abs(newPosition.column - this.column) == Math.abs(newPosition.row - this.row)){
	         return true;
	      }
	      else{
	         return false;
	      }
	   }

}
