import java.util.*;


public class Theatre {

	private final String theatreName;
	private List<Seat> seats = new ArrayList<Seat>(); // can use collections to keep generic so can cast Set like HashSet, List(incl Array), Queue, Deque - cannot go lower like TreeSet. 

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows -1);
		for ( char row = 'A'; row <= lastRow; row++) {
			for(int seatNum = 1; seatNum<=seatsPerRow;seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber){
		Seat requestSeat = new Seat(seatNumber); // Seat object extends comparable , compares seatNumber to seat objects.
		int foundSeat = Collections.binarySearch(seats, requestSeat, null);  // faster/efficient way to find a match in a sorted list (ArrayList is sorted) 
		if(foundSeat >= 0) {
			return seats.get(foundSeat).reserve(); // found seat in list and calls reserve method.
		} else {
			System.out.println("There is no seat "+ seatNumber);
			return false;
		}
//		
//		for(Seat seat : seats) {
//			if(seat.getSeatNumber().equals(seatNumber)) {
//				requestSeat = seat;
//				break;
//			}
//		}
//		
//		if(requestSeat == null) {
//			System.out.println("There is no seat "+ seatNumber);
//			return false;
//		}
//		
//		return requestSeat.reserve();
	}
	
	// for testing
	public void getSeats() {
		for(Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	private class Seat implements Comparable<Seat> {
		private final String seatNumber;
		private boolean reserved = false;
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
	
		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}

		
		public boolean reserve() {
			if(!this.reserved) {
				this.reserved = true;
				System.out.println("Seat "+ seatNumber + " reserved.");
				return true;
			} else {
				return false;
			}
		}
		
		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean cancel() {
			if(this.reserved) {
				this.reserved = false;
				System.out.println("Reservation of seat" + seatNumber + "cancelled.");
				return true;
			} else {
				return false;
			}
		}
	}
	

}
