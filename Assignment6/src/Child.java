
public class Child extends Ticket{

	final double MORNING_FARE = 5.75;
	final double EVENING_FARE = 10.75;
	final double IMAX_COST = 2.00;
	final double THREE_D_COST = 1.50;
	
	public Child() {
		super();
	}
	
	public Child(String movieName, String rating, int day, int time, String option, String type, int id) {
		super(movieName, rating, day, time, option,type, id);
		setTicketPrice(calculateTicketPrice());
	}
	
	public Child(String movieName, String rating, int day, int time, String option, String type, int id, MovieTicketManager m) {
		super(movieName, rating, day, time, option,type, id, m);
		setTicketPrice(calculateTicketPrice());
	}
	
	//This constructor is used by ChildTest file
	public Child(String movieName, String rating, int day, int time, String option) {
		super(movieName, rating, day, time, option);
		setTicketPrice(calculateTicketPrice());
	}

	
	
	@Override
	double calculateTicketPrice() {
		// TODO Auto-generated method stub
		double price =0;
		
		//Determine if movie time is Day or Evening
				if(getTime()< 18)
					price+=MORNING_FARE;
				else price+=EVENING_FARE;
				
				//Determine if ticket has IMAX or 3D option and add to the ticket price
				if(getOption().equals(Format.IMAX))
					price+=IMAX_COST;
				
				if(getOption().equals(Format.THREE_D))
					price+=THREE_D_COST;
				
				price+=(price*TAX);
				
				return price;
		
		
	}

	@Override
	int getId() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	public String toString() {
		return super.toString();
	}
}
