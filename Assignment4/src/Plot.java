
/**
 * @author Hasib
 *
 */
/**
 * @author Hasib
 *
 */
/**
 * @author Hasib
 *
 */
public class Plot {

//Fields
	private int x; // Upper left Corner Value
	private int y; // Upper left Corner Value
	private int width; // Horizontal extent of plot;
	private int depth; // Vertical extent of a plot

	/**
	 * No-arg constructor setting width and depth to 1
	 */
	public Plot() {
		width = 1;
		depth = 1;
	}

	
	/**
	 * Copy Constructor, getting a Plot object and setting the values of x, y, width and depth
	 * to the current Plot
	 * @param p 
	 */
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}

	
	/**
	 * Parameterize Constructor passing top-left x and y positions and width and depth of the plot
	 * @param x top-left position of x-axis
	 * @param y top-left position of y-axis
	 * @param width	the length from the x position to the right
	 * @param depth the length from the y position to bottom
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}


	/**
	 * This method determine if a given Plot is overlapping the existing Plot
	 * @param plot instance of Plot object
	 * @return true if plots are overlapping and false otherwise
	 */
	public boolean overlaps(Plot plot) {

		// Getting top-left corner and bottom right corer coordinates for current plot
		int l1x = x;
		int l1y = y;
		int r1x = x + width;
		int r1y = y + depth;

		// Getting to left corner and bottom right corner coordinates for given plot
		int l2x = plot.x; // x for top left corner
		int l2y = plot.y; // y for to left corner
		int r2x = plot.x + plot.width; // get x for right bottom corner
		int r2y = plot.y + plot.depth; // get y for right bottom corner

		//if the two plot doesn't over lap, return false, else return true
		if ((l2x >= r1x || r2x <= l1x) || (l2y >= r1y || r2y <= l1y))
			return false;

		else
			return true;
	}

	
	/**
	 * This method determines if a given plot is inside of the the current plot (execlusive of edges)
	 * @param plot
	 * @return true if it's inside of the current plot, otherwise returns false
	 */
	public boolean encompasses(Plot plot) {
		// Getting top-left corner and bottom right corer coordinates for current plot
		int l1x = x;
		int l1y = y;
		int r1x = x + width;
		int r1y = y + depth;

		// Getting to left corner and bottom right corner coordinates for given plot
		int l2x = plot.x; // x for top left corner
		int l2y = plot.y; // y for to left corner
		int r2x = plot.x + plot.width; // get x for right bottom corner
		int r2y = plot.y + plot.depth; // get y for right bottom corner

		// if((r2x<=r1x && l2x>=l1x)&&(r2y >=r1y && l2y<=l1y))
		if ((r2x <= r1x && l2x >= l1x) && (r2y <= r1y && l2y >= l1y))
			return true;
		else
			return false;

	}

//getters and setters	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	
	/** toString method
	 */
	public String toString() {
		return "Upper left: " + x + "," + y + "): Width:" + width + ", Depth:" + depth;
	}
}
