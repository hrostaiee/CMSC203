
public class MoviePass extends Ticket{
	final double MORNING_FARE = 10.50;
	final double EVENING_FARE = 13.50;
	final double IMAX_COST = 3.00;
	final double THREE_D_COST = 2.50;

	
	public MoviePass() {
		super();
	}
	
	
	public MoviePass(String movieName, String rating, int day, int time, String option, String type, int id) {
		super(movieName, rating, day, time, option, type, id);
		setTicketPrice(calculateTicketPrice());
	}
	
	public MoviePass(String movieName, String rating, int day, int time, String option,String type, int id, MovieTicketManager m) {
		super(movieName, rating, day, time, option, type, id, m);
		setTicketPrice(calculateTicketPrice());
	}
	
	
	@Override
	double calculateTicketPrice() {
		// TODO Auto-generated method stub
		
		//First time price including tax
		double price = 9.99;
		
		boolean movieSeenToday =	ticketManager.numMoviesToday(id, getDay())!=0;
		boolean movieSeenBefore= 	ticketManager.numThisMovie(id, getMovieName())!=0;
		boolean isIMAXor3D =		this.getOption().equals(Format.IMAX) || this.getOption().equals(Format.THREE_D);
		
		//If it's not first time watching
		if(ticketManager.numVisits(id)>0) {

		price = 0;
		
		//if any of the above condition is true, the calculate adult price, otherwise, it's free
		 if(movieSeenToday || movieSeenBefore || isIMAXor3D )
		 {
			if(super.getTime()<18)
				price+=MORNING_FARE;
			else price+=EVENING_FARE;
			
			//Determine if ticket has IMAX or 3D option and add to the ticket price
			if(getOption().equals(Format.IMAX))
				price+=IMAX_COST;
			
			if(getOption().equals(Format.THREE_D))
				price+=THREE_D_COST;
			
			price+= (price*TAX);
		}
		}
		return price;
	}

	@Override
	int getId() {
		// TODO Auto-generated method stub
		return id;
	}

public String toString() {
		
		return 
				super.toString();
	}
}
