

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		//Student add adult tickets
		ticketList.addTicket("Becoming", "PG", 3,11,"NONE","Adult",0);
		//Student add children tickets
		ticketList.addTicket("The Half of It", "PG", 4,13,"NONE","Child",0);
		//Student add employee tickets
		ticketList.addTicket("Den of Thieves", "R", 5,19,"3D","Employee",12345);
		//Student add MoviePass member tickets
		ticketList.addTicket("Sleepless", "R", 5,21,"IMAX","MoviePass",44233);
	}

	@After
	public void tearDown() throws Exception {
		//Student set ticketList to null;
		ticketList=null;
	}
	

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//Student test Employees' number of visits
		ticketList.addTicket("Solo", "R", 5,19,"3D","Employee",12345);
		assertEquals(2,ticketList.numVisits(12345));
		//Student test MoviePass members' number of visits
		ticketList.addTicket("Sleepless", "R", 5,21,"IMAX","MoviePass",44233);
		assertEquals(2,ticketList.numVisits(44233));
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {

		//Student test Employees' number of views
		assertEquals(1,ticketList.numThisMovie(12345,"Den of Thieves"));
		//Student test MoviePass members' number of views
		ticketList.addTicket("Sleepless", "R", 5,21,"IMAX","MoviePass",44233);
		assertEquals(2,ticketList.numThisMovie(44233,"Sleepless"));
	}

}
