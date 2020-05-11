import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketManager implements MovieTicketManagerInterface{

	//List of Tickets
	 private ArrayList<Ticket> ticketList = new ArrayList<>();
	 private NumberFormat currencyFormat =new DecimalFormat("$#,###,##0.00");
	 

	 
	 //Get List of Tickets
	 public ArrayList<Ticket> getTicketList(){
	        return ticketList;
	    }

	@Override
	public int numVisits(int id) {
		// TODO Auto-generated method stub
		  int visits = 0;

		  //count number of tickets in the array for the specific ID and for each occurance add 1 to the visit
		  for (Ticket ticket : ticketList) {
	            if (ticket.getId() == id) {
	                visits++;
	            }
	        }

		return visits;
	}

	@Override
	public int numThisMovie(int id, String movieName) {
		// TODO Auto-generated method stub
		int numOfVisitis = 0;
		
		//count number of time the movie is watched in the array for the specific ID and for each occorance add 1 to the visit
		for (Ticket ticket : ticketList) {
            boolean seenMovie = ticket.getMovieName()==movieName;
            if (ticket.getId() == id && seenMovie) {
            	numOfVisitis++;
            }
        }
		return numOfVisitis;
	}

	@Override
	public int numMoviesToday(int id, int date) {
		// TODO Auto-generated method stub
		int numOfVisitis = 0;
		
		for (Ticket ticket : ticketList) {
            if (ticket.getId() == id && ticket.getDay() == date) {
            	numOfVisitis++;
            }
        }
		return numOfVisitis;
	}

	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		// TODO Auto-generated method stub
		Ticket ticket = null;
		
		//Add ticket based on the person type
		
		if(type == "Adult" || type =="ADULT")
			ticket = new Adult(movieN,rating, d, t, f,type, id, this);
		
		else if (type == "Child" || type =="CHILD") {
			
			if(rating =="PG" || rating == "G")
				ticket = new Child(movieN,rating, d, t, f, type, id, this);
			else System.out.println("CAN NOT GET TICKET OF THIS MOVIE FOR CHILD BECAUE OF RATING");
		}
		
		else if (type == "Employee" || type =="EMPLOYEE")
			ticket = new Employee(movieN, rating, d, t, f, type, id, this);
		
		else if (type == "MoviePass" || type =="MOVIEPASS")
			ticket = new MoviePass(movieN, rating, d, t, f, type, id, this);
		
		//	if ticket is not not null, add it to the list and return price of ticket
		if(ticket != null) {
			ticketList.add(ticket);
			return ticket.getTicketPrice();
		}
		
		return -1;
	}

	@Override
	public double totalSalesMonth() {
		// TODO Auto-generated method stub
		double total = 0;
		
		   for (Ticket ticket : ticketList) {
	            total += ticket.getTicketPrice();
	        }
		
		return total;
	}

	@Override
	public String monthlySalesReport() {
		// TODO Auto-generated method stub
		return "TEST";
    }
	
	@Override
	public ArrayList<String> get3DTickets() {
		// TODO Auto-generated method stub
		sortByDay();

        ArrayList<String> tickets3D = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            if (ticket.getOption().equals(Format.THREE_D)) {
            	tickets3D.add(ticket.toString() + "\n");
            }
        }
        return tickets3D;
	}

	@Override
	public ArrayList<String> getAllTickets() {
		// TODO Auto-generated method stub
		  sortByDay();

	        ArrayList<String> tickets = new ArrayList<>();

	        for (Ticket ticket : ticketList) {
	            tickets.add(ticket.toString() + "\n");
	        }
	        return tickets;
		
	}

	@Override
	public ArrayList<String> getMoviePassTickets() {
		// TODO Auto-generated method stub
		   sortById();

	        ArrayList<String> moviePassTickets = new ArrayList<>();

	        for (Ticket ticket : ticketList) {
	            if (ticket instanceof MoviePass) {
	                moviePassTickets.add(ticket.toString() + "\n");
	            }
	        }
	        return moviePassTickets;
	    
	}

	@Override
	public void readFile(File file) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner inputFile = new Scanner(file);
        while(inputFile.hasNextLine()) {
            String[] movies = inputFile.nextLine().split(":");
            String movieName = movies[0];
            String rating = movies[1];
            int day = Integer.parseInt(movies[2]);
            int time = Integer.parseInt(movies[3]);
            String option = movies[4];
            String type = movies[5];
            int id = Integer.parseInt(movies[6]);
            addTicket(movieName, rating, day, time, option, type, id);
        }
	}
	
	//sort ticket list array by Day
	private void sortByDay() {
        Ticket ticket;
        for (int i = 1; i < ticketList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (ticketList.get(j).getDay() < ticketList.get(j - 1).getDay()) {
                    ticket = ticketList.get(j);
                    ticketList.set(j, ticketList.get(j - 1));
                    ticketList.set(j - 1, ticket);
                }
            }
        }

    }
	
	//sort ticket list array by ID
	private void sortById() {
        Ticket ticket;
        for (int i = 1; i < ticketList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (ticketList.get(j).getId() < ticketList.get(j - 1).getId()) {
                    ticket = ticketList.get(j);
                    ticketList.set(j, ticketList.get(j - 1));
                    ticketList.set(j - 1, ticket);
                }
            }
        }
	}

}
