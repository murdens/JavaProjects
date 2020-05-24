//import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Theatre theatre = new Theatre("The Grand", 8, 12);
		theatre.getSeats();
		
		if (theatre.reserveSeat("B11")) {
			System.out.println("Please pay");
		} else {
			System.out.println("Sorry seat is taken");
		}
		
//		List<Theatre.Seat> seatCopy = new ArrayList<theatre.seats>;  // can create 'shallow' copy of an ArrayList objects but it is not independent (need public classes)
																	 //	references the same objects.
		
		//Theatre.Seat minSeat = Collections.min(seatCopy);
		//Theatre.Seat maxSeat = Collections.max(seatCopy);
		// Collections.shuffle
			

	}
	

}

// generic sort method - sort any list of theatre seats as longs as they implement the comparable interface.
//	public static void sortList(List<? extends Theatre.Seat> list){
//		for(int = i; i<list.size() -1 ; i++) { 
//			for(int = j; j<list.size(); j++) { //inner loop checking fewer and fewer each time - good if memory at premium
//				if(list.get(i).compareTo(list.get(j)) <0) {
//					Collections.swap(list, i, j);
//				}
//			}
//		}
//	}
