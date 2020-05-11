
public class Adult extends Ticket{

	//Variables to hold different fares and cost of IMAX and 3D
	final double MORNING_FARE = 10.50;
	final double EVENING_FARE = 13.50;
	final double IMAX_COST = 3.00;
	final double THREE_D_COST = 2.50;
	
	//No Arg Constructor
	public Adult() {
		super();
	}
	
	//Constructor which using super class's constructor method
	public Adult(String movieName, String rating, int day, int time, String option, String type, int id) {
		super(movieName, rating, day, time, option, type, id);
		super.setTicketPrice(calculateTicketPrice());
	}
	
	///Copy constructor
	public Adult(String movieName, String rating, int day, int time, String option, String type, int id, MovieTicketManager m) {
		super(movieName, rating, day, time, option, type, id, m);
		super.setTicketPrice(calculateTicketPrice());
	}
	
	@Override
	double calculateTicketPrice() {
		// TODO Auto-generated method stub
		double price =0;
		
		//Determine if movie time is Day or Evening
		if(getTime()<18)
			price+=MORNING_FARE;
		else price+=EVENING_FARE;
		
		//Determine if ticket has IMAX or 3D option and add to the ticket price
		if(getOption().equals(Format.IMAX))
			price+=IMAX_COST;
		if(getOption().equals(Format.THREE_D))
			price+=THREE_D_COST;
		
		price+= (price*TAX);
		
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
