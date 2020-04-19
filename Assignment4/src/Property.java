
public class Property {

	//Fields
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;


	/**
	 * No-arg constructor, setting the current plot to the default plot.
	 */
	public Property() {
		this.plot = new Plot();
	}


	/**Copy Constructor, setting the values of one Peroprty to this property and
	 * setting plot to the given property's plot
	 * @param p
	 */
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = p.plot;
	}


	/**Parameterized Constructor, setting property info and plot
	 * @param propertyName name of the property
	 * @param city name of city
	 * @param rentAmount amount of rent for the property
	 * @param owner owner of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}

	/**Parameterized Constructor with information of property and plot
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	//getters and setters
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	//toString
	public String toString() {
		return "\n\tPropertyName: " + propertyName + "\n\t Located in " + city + "\n\t Belonging to :" + owner
				+ "\n\t RentAmount: $" + rentAmount;
	}

}
