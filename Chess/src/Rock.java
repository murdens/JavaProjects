
public class Rock extends Piece {
	
	int column;
	int row;
	
	public Rock() {
		super();
		this.name = "rock";
	}
	
	 boolean isValidMove(Position newPosition){
		 
		 if(!super.isValidMove(newPosition)) {
			 return false;
		 }
	      if(newPosition.column == this.column || newPosition.row == this.row){
	         return true;
	      }
	      else{
	         return false;
	      }
	   }

}
