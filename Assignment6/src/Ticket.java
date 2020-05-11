import java.text.DecimalFormat;


/**
 * @author Hasib Rostaiee
 *
 */
public abstract class Ticket {
	private String movieName;	//name of Movie
	private String rating;		//Rating if PG or Adult
	private int day;			//Day
	private int time;			//Time
	private Format option;
	final double TAX = 0.096;
	private double ticketPrice;
	private String type;
	protected int id;
	protected MovieTicketManager ticketManager;
	
	private DecimalFormat currencyFormat = new DecimalFormat("$#,###,##0.00");
	

	//No-Arg Constructor
	public Ticket() {

	}
	
	//Constructor with all fields
	/** Constructor Method with all fields.
	 * @param movieName Name of the movie
	 * @param rating if Movie is PG or above
	 * @param day	Date for the movie
	 * @param time	Time for the movie	
	 * @param option	Enum value of the Format
	 * @param type		type of the ticket (i.e Adult, Kid, Employee..)
	 * @param id		Id of Employee or Movie Pass , for Kids and Adult ID is -1 by default;
	 */
	public Ticket(String movieName, String rating, int day, int time, String option, String type, int id) {
		setMovieName(movieName);
		setRating(rating);
		setDay(day);
		setTime(time);
		setType(type);
		setId(id);
		if(option=="IMAX")
			setOption(Format.IMAX);
		else if(option == "3D")
			setOption(Format.THREE_D);
		else setOption(Format.NONE);
	}
	//constructor withiout type and id which is needed for childTest
	public Ticket(String movieName, String rating, int day, int time, String option) {
		setMovieName(movieName);
		setRating(rating);
		setDay(day);
		setTime(time);
		if(option=="IMAX")
			setOption(Format.IMAX);
		else if(option == "3D")
			setOption(Format.THREE_D);
		else setOption(Format.NONE);
	}
	
	//constructor with id without option fromat
	public Ticket(String movieName, String rating, int day, int time, String option, int id) {
		setMovieName(movieName);
		setRating(rating);
		setDay(day);
		setTime(time);
		if(option=="IMAX")
			setOption(Format.IMAX);
		else if(option == "3D")
			setOption(Format.THREE_D);
		else setOption(Format.NONE);
	}
	
	//constructor with id and number of visited time
		public Ticket(String movieName, String rating, int day, int time, String option, int id, int visits) {
			setMovieName(movieName);
			setRating(rating);
			setDay(day);
			setTime(time);
			if(option=="IMAX")
				setOption(Format.IMAX);
			else if(option == "3D")
				setOption(Format.THREE_D);
			else setOption(Format.NONE);
			ticketManager.numThisMovie(id, movieName);
		}
		
	
	//constructor with all parameters and copynig the MovietTicketManager object
	public Ticket(String movieName, String rating, int day, int time, String option, String type, int id, MovieTicketManager m) {
		this(movieName, rating, day, time, option, type, id);
		ticketManager = m;
	}

	
	//abstract methods for calculatinig price and getiting id
	abstract double calculateTicketPrice();
	abstract int getId();

	
	//getters and setters
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Format getOption() {
		return option;
	}

	public void setOption(Format option) {
		this.option = option;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTAX() {
		return TAX;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	//Tostring method
	public String toString() {
		
		return 	type+" "+id 
				+" Movie: " + movieName + " Rating: " + rating + " Day: " + day
                + " Time: " + time + " Price: " + currencyFormat.format(ticketPrice);
	}
}
