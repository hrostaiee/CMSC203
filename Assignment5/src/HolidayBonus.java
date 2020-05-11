
/**
 * @author Hasib Rostaiee
 *
 */
public class HolidayBonus {

	/**
	 * No-arg Constructor
	 */
	public HolidayBonus() {
		
	}
	
	/**Calculates the holiday bonus for each store
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return allBonuses - an array of the bonuses for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] allBonuses = new double[data.length];
		
		for (int row = 0; row < allBonuses.length; row++) {
			
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] >= 0) {
					
					if (data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col))
						allBonuses[row] += high;
					else if (data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col))
						allBonuses[row] += low;
					else 
						allBonuses[row] += other;

				}
			}
		}
		return allBonuses;
	}

	/**Calculates the total holiday bonuses
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return holidayBonuses - the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] allBonuses = calculateHolidayBonus(data, high, low, other);
		double holidayBonuses = 0;
		
		for (int row = 0; row < allBonuses.length; row++) {
			holidayBonuses += allBonuses[row];
		}
		return holidayBonuses;
	}
}
