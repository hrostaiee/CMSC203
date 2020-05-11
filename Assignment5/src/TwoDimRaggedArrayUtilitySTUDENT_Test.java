

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{7.2, 2.5, 1.3, 5.8},{5.9, 2.2},{8.1, 2.56, 3.5},{10, 6.9, 5.1, 2.8}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
		
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(63.86,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.91,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.01);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(16.8,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,0),.01);
		assertEquals(8.1,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),.01);
		assertEquals(24.8,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,3),.01);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(31.2,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,0),.01);
		assertEquals(14.16,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),.01);
		assertEquals(8.6,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,3),.01);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(10,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.01);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT,outputFile);
	}

	

}
