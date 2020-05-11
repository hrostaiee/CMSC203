import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hasib Rostaiee
 *
 */
public class TwoDimRaggedArrayUtility {


	//No-arg Constructor
	public TwoDimRaggedArrayUtility() {
	};
	
	
	/**
	 * This methods reads data from a file and add them to a ragged array
	 * @param file - the file object to be passed in the method
	 * @return salesArray - the array of data which is read from the file
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(File file) throws java.io.FileNotFoundException {
		String[][] tempArray = new String[10][10];
		Scanner inputFile = new Scanner(file); 
		int row =0;
		int col =0;
		
		//Reading data into a temperrory string array
		while(inputFile.hasNextLine()) {
			String[] currentRow = inputFile.nextLine().split(" ");
			for(col =0; col<currentRow.length; col++) {
				tempArray[row][col] = currentRow[col];
			}
			row++;
		}
		inputFile.close();
		
		//Reading data fro the temp arrary in to the actual array to be returned on this method
		double[][] salesArray = new double[row][];
		
		for (row = 0; row < salesArray.length; row++) {
			for (col = 0; tempArray[row][col] != null; col++) {	}			
			salesArray[row] = new double[col];
			for (col = 0; col < salesArray[row].length; col++) {
				salesArray[row][col] = Double.parseDouble(tempArray[row][col]);
			}
			
		}
		return salesArray;

	}

	/** This methods writes data of a tow dimension array in to a file
	 * @param arrayData - the array which the data need to be written to the file
	 * @param outputFile - name of the file object
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] arrayData, File outputFile) throws FileNotFoundException {
		
		PrintWriter file = new PrintWriter(outputFile);
		
		for (int row = 0; row < arrayData.length; row++) {
			
			for (int col = 0; col < arrayData[row].length; col++) {
				
				file.print((col != 0) ? " " + arrayData[row][col] : arrayData[row][col]);
			}
			file.println();
		}
		file.close();
	}

	/**Returns the total of all the elements of the two dimensional array
	 * @param arrayData - the two dimensional array getting total of
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] arrayData) {
		double total =0;
		
		for (int row = 0; row < arrayData.length; row++) {
			for (int col = 0; col < arrayData[row].length; col++) {
				total += arrayData[row][col];
			}
		}
		return total;
	}

	/** Returns the average of the elements in the two dimensional array
	 * @param data - the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of elements/num of elements)
	 */
	public static double getAverage(double[][] data) {
		
		int count = 0;
		double total = 0;
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				count++;
			}
		}

		return total/count;
		
	}

	/**Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return rowTotal - the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;

		for (int col = 0; col < data[row].length; col++) {

			rowTotal += data[row][col];
		}

		return rowTotal;
	}

	/**Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data -  the two dimensional array
	 * @param col -  the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
	
	double columnTotal = 0;

	for (int row = 0; row < data.length; row++) {

		if (col < data[row].length) {
			columnTotal += data[row][col];
		}
	}

	return columnTotal;
	}

	/**Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		
		int tempCol = 0;
		double highest = data[0][0];
		while (tempCol < data.length) {

			if (tempCol < data[row].length) {
				highest = data[row][tempCol];
				break;
			} else {
				tempCol++;
			}

		}

		for (int col = 0; col < data[row].length; col++) {

			if (data[row][col] > highest) {
				highest = data[row][col];
			}

		}

		return highest;
		
	}

	/**Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data -the two dimensional array
	 * @param row - the row index to find the largest element of (0 refers to the first row)
	 * @return -the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		int highest = 0;
		int tempCol = 0;
		double highestElement = data[0][0];
		while (tempCol < data.length) {

			if (tempCol < data[row].length) {
				highestElement = data[row][tempCol];
				break;
			} else {
				tempCol++;
			}

		}

		for (int col = 0; col < data[row].length; col++) {

			if (data[row][col] > highestElement) {
				highestElement = data[row][col];
				highest = col;
			}

		}

		return highest;

	}

	/**Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the smallest element of (0 refers to the first row)
	 * @return lowestValue - the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		int tempCol = 0;
		double lowestValue = data[0][0];
		while (tempCol < data.length) {

			if (tempCol < data[row].length) {
				lowestValue = data[row][tempCol];
				break;
			} else {
				tempCol++;
			}

		}

		for (int col = 0; col < data[row].length; col++) {

			if (data[row][col] < lowestValue) {
				lowestValue = data[row][col];
			}

		}

		return lowestValue;
	}

	/**Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the smallest element of (0 refers to the first row)
	 * @return lowestIndex - the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowestIndex = 0;
		int tempCol = 0;
		double lowestElement = data[0][0];
		while (tempCol < data.length) {

			if (tempCol < data[row].length) {
				lowestElement = data[row][tempCol];
				break;
			} else {
				tempCol++;
			}

		}

		for (int col = 0; col < data[row].length; col++) {

			if (data[row][col] < lowestElement) {
				lowestElement = data[row][col];
				lowestIndex = col;
			}
		}

		return lowestIndex;
	}

	/**Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the largest element of (0 refers to the first column)
	 * @return highestValue - the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		int temRow = 0;
		double highestValue = data[0][0];
		while (temRow < data.length) {

			if (col < data[temRow].length) {
				highestValue = data[temRow][col];
				break;
			} else {
				temRow++;
			}

		}

		for (int row = 0; row < data.length; row++) {

			if (col < data[row].length)  {
				if (data[row][col] > highestValue) {
					highestValue = data[row][col];
				}
			}

		}

		return highestValue;
	}

	/**Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the largest element of (0 refers to the first column)
	 * @return highestIndex - the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		int highestIndex = 0;
		int tempRow = 0;
		double highestElement = data[0][0];
		while (tempRow < data.length) {

			if (col < data[tempRow].length) {
				highestElement = data[tempRow][col];
				break;
			} else {
				tempRow++;
			}

		}

		for (int row = 0; row < data.length; row++) {

			if (col < data[row].length) {
				if (data[row][col] > highestElement) {
					highestElement = data[row][col];
					highestIndex = row;
				}
			}

		}

		return highestIndex;

	}

	/**Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the smallest element of (0 refers to the first column)
	 * @return lowestValue - the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		int tempRow = 0;
		double lowestValue = data[0][0];
		while (tempRow < data.length) {

			if (col < data[tempRow].length) {
				lowestValue = data[tempRow][col];
				break;
			} else {
				tempRow++;
			}

		}

		for (int row = 0; row < data.length; row++) {

			if (col < data[row].length) {
				if (data[row][col] < lowestValue) {
					lowestValue = data[row][col];
				}
			}
		}

		return lowestValue;
	}

	/**Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the smallest element of (0 refers to the first column)
	 * @return smallest - the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		int smallest = 0;
		int temRow = 0;
		double lowestElement = data[0][0];
		while (temRow < data.length) {

			if (col < data[temRow].length) {
				lowestElement = data[temRow][col];
				break;
			} else {
				temRow++;
			}

		}

		for (int row = 0; row < data.length; row++) {

			if (col < data[row].length) {
				if (data[row][col] < lowestElement) {
					lowestElement = data[row][col];
					smallest = row;
				}
			}

		}

		return smallest;
	}

	/**Returns the largest element in the two dimensional array
	 * @param data - the two dimensional array
	 * @return highestValue - the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		
		double highestValue = data[0][0];

		for (int row = 0; row < data.length; row++) {

			for (int col = 0; col < data[row].length; col++) {

				if (data[row][col] > highestValue) {

					highestValue = data[row][col];
				}			
			}
		}

		return highestValue;
	}

	/**Returns the smallest element in the two dimensional array 
	 * @param data - the two dimensional array 
	 * @return lowestValue - the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestValue = data[0][0];

		for (int row = 0; row < data.length; row++) {

			for (int col = 0; col < data[row].length; col++) {

				if (data[row][col] < lowestValue) {

					lowestValue = data[row][col];
				}			
			}
		}

		return lowestValue;
	}
}
