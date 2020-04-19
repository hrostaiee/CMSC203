
public class ManagementCompany {

	// fields
	private final int MAX_PROPERTY = 5;
	private double mgmFeeper;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;

	
	/**
	 * No-arg constructor, setting Plot with 0,0 for x and y and 10 for width and depth
	 * setting the max number of properties array 
	 */
	public ManagementCompany() {

		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**Parameterize constructor using name, taxID and management fee 
	 * and setting plot and initializing the properties array
	 * @param name name of the company
	 * @param taxID tax id of company
	 * @param mgmFee the fee management charges each property.
	 * This number represent a % (for example 6 means 6%).
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeeper = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**Parameterized constructor using the Company information and the plot information
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeeper = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	
	/**Copy Constructor
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {

		this.mgmFeeper = otherCompany.mgmFeeper;
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}

	// other methods

	/**This method add a property to the properties array and return different codes
	 * if the property is either overlap existing one or go beyond the management
	 * plot or if the array is is full or if the passed property is null
	 * @param property object
	 * @return index which is code for different situation
	 */
	public int addProperty(Property property) {
		int index = 0;
		int i;
		boolean encomp;
		boolean overlap = false;
		// if the property is null return -2;
		if (property == null)
			index = -2;
		// if the property lies outside of the management pot return -3
		else if (!(encomp = plot.encompasses(property.getPlot())))
			index = -3;
		else {

			for (i = 0; i < properties.length; i++) {

				// if the plot of given property is overlapping with any of the existing
				// properties' plots, return -4
				for (int k = 0; k < i; k++) {
					if (properties[k] != null) {
						overlap = property.getPlot().overlaps(properties[k].getPlot());
						if (overlap)
							break;
					}
				}
				if (overlap)
					index = -4;
				// Add the property to the arrays of properties,
				// only if that index doesn't have any property yet;
				else {
					if (properties[i] == null) {
						properties[i] = property;
						index = i;
						break;
					}
					// return -1 if the array is full
					if (i == properties.length - 1)
						index = -1;
				}
			}

		}
		return index;

	}

	/**This method add a property to the management company using Property information
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public int addProperty(String propertyName, String city, double rent, String owner) {
		// creating a property objecting using the argument passed to the method
		Property property = new Property(propertyName, city, rent, owner);

		int index = 0;
		int i;
		boolean encomp;
		boolean overlap = false;
		// if the property is null return -2;
		if (property == null)
			index = -2;
		// if the property lies outside of the management pot return -3
		else if (!(encomp = plot.encompasses(property.getPlot())))
			index = -3;
		else {

			for (i = 0; i < properties.length; i++) {

				// if the plot of given property is overlapping with any of the existing
				// properties' plots, return -4
				for (int k = 0; k < i; k++) {
					if (properties[k] != null) {
						overlap = property.getPlot().overlaps(properties[k].getPlot());
						if (overlap)
							break;
					}
				}
				if (overlap)
					index = -4;
				// Add the property to the arrays of properties,
				// only if that index doesn't have any property yet;
				else {
					if (properties[i] == null) {
						properties[i] = property;
						index = i;
						break;
					}
					// return -1 if the array is full
					if (i == properties.length - 1)
						index = -1;
				}
			}

		}
		return index;

	}

	/**This method add a property to the management company using property information and plot information
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width,
			int depth) {
		// creating a property objecting using the argument passed to the method
		Property property = new Property(propertyName, city, rent, owner, x, y, width, depth);

		int index = 0;
		int i;
		boolean encomp;
		boolean overlap = false;
		// if the property is null return -2;
		if (property == null)
			index = -2;
		// if the property lies outside of the management pot return -3
		else if (!(encomp = plot.encompasses(property.getPlot())))
			index = -3;
		else {

			for (i = 0; i < properties.length; i++) {

				// if the plot of given property is overlapping with any of the existing
				// properties' plots, return -4
				for (int k = 0; k < i; k++) {
					if (properties[k] != null) {
						overlap = property.getPlot().overlaps(properties[k].getPlot());
						if (overlap)
							break;
					}
				}
				if (overlap)
					index = -4;
				// Add the property to the arrays of properties,
				// only if that index doesn't have any property yet;
				else {
					if (properties[i] == null) {
						properties[i] = property;
						index = i;
						break;
					}
					// return -1 if the array is full
					if (i == properties.length - 1)
						index = -1;
				}
			}

		}
		return index;

	}

	/**This method returns the information of property in the
	 * properties array on the given index
	 * @param i index of the array
	 * @return toString representation of the property
	 */
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	/**Get Max number of property can be added for the company
	 * @return
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	
	/**This method retruns total rent of all properties
	 * @return total total rent for all properties
	 */
	public double totalRent() {
		double total = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null)
				total += properties[i].getRentAmount();
		}
		return total;
	}

	/**This method return the maximum rent among the prperties
	 * @return max
	 */
	public double maxRentProp() {
		double max = properties[0].getRentAmount();
		for (int i = 1; i < properties.length; i++)
			if (properties[i] != null && properties[i].getRentAmount() > max)
				max = properties[i].getRentAmount();

		return max;
	}

	// I couldn't make this private as it's being useind the PropertyMgmDriverNoGui
	// class
	
	/**This method returns the index of element of properties array where the rent is max
	 * @return index
	 */
	public int maxRentPropertyIndex() {
		double max = properties[0].getRentAmount();
		int index = 0;
		for (int i = 1; i < properties.length; i++)
			if (properties[i] != null && properties[i].getRentAmount() > max) {
				max = properties[i].getRentAmount();
				index = i;
			}
		return index;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getName() {
		return name;
	}

	// toString
	public String toString() {
		String text = "";
		for (int i = 0; i < properties.length; i++) {
			text += properties[i].toString();
		}

		double totalMgmFee = (totalRent() * (mgmFeeper / 100));
		return "List of the properties for " + name + ", taxID: " + taxID
				+ "\n--------------------------------------------------------------" + text
				+ "\n--------------------------------------------------------------\n" + "Total Management Fee: $"
				+ totalMgmFee;

	}

}
