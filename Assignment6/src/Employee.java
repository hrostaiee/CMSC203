
public class Employee extends Ticket{

	final double MORNING_FARE = 5.25;
	final double EVENING_FARE = 7.20;
	final double IMAX_COST = 1.50;
	final double THREE_D_COST = 1.25;
	

	public Employee() {
		super();
	}
	
	public Employee(String movieName, String rating, int day, int time, String option,String type, int id) {
		super(movieName, rating, day, time, option,type, id);
		setTicketPrice(calculateTicketPrice());
	}
	
	public Employee(String movieName, String rating, int day, int time, String option,String type, int id, MovieTicketManager m) {
		super(movieName, rating, day, time, option,type, id, m);
		setTicketPrice(calculateTicketPrice());
	}
	
	//This is used by EmployeeTest
	public Employee(String movieName, String rating, int day, int time, String option, int id, int visit) {
	super(movieName, rating, day, time, option, id);
		setTicketPrice(calculateTicketPrice());
	}
	
	@Override
	double calculateTicketPrice() {
		// TODO Auto-generated method stub
		double price = 0;
		
		
		//Determine if movie time is Day or Evening and if it' has been watched more than 2 times
		 if(ticketManager.numVisits(id) > 2)
		 {
				if(getTime() < 18)
					price+=MORNING_FARE;
				else price+=EVENING_FARE;
				
				//Determine if ticket has IMAX or 3D option and add to the ticket price
				if(getOption().equals(Format.IMAX))
					price+=IMAX_COST;
				
				if(getOption().equals(Format.THREE_D))
					price+=THREE_D_COST;
				
				
				price+=(price*TAX);
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
