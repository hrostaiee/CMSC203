
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {

	ManagementCompany mgmComp;

	@Before
	public void setUp() throws Exception {
		// student create a management company
		mgmComp = new ManagementCompany("Choice Inc.", "0012345", 7.25);

		// student add three properties, with plots, to mgmt co
		Property p1 = new Property("ParkPlaceII", "Montgomery Village", 1500, "Hasib", 1, 1, 1, 1);
		Property p2 = new Property("Spring Lake", "Bethesda", 2300, "Tom", 2, 2, 2, 3);
		Property p3 = new Property("Lakeview", "Rockville", 1250, "John", 5, 5, 3, 2);
		mgmComp.addProperty(p1);
		mgmComp.addProperty(p2);
		mgmComp.addProperty(p3);
	}

	@After
	public void tearDown() {
		// student set mgmt co to null
		mgmComp = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		// student should add property with 4 args & default plot (0,0,1,1)
		Property p4 = new Property("New View", "Rockville", 2350, "Adela");
		// this property will be added to index 3
		assertEquals(mgmComp.addProperty(p4), 3);
		// student should add property with 8 args
		Property p5 = new Property("The Town Center", "Bethesda", 3400, "Jassica", 3, 2, 7, 3);
		// this property can not be added due to overlapping with existing properties
		assertEquals(mgmComp.addProperty(p5), -4);
		// changing the position of p5
		p5 = new Property("The Town Center", "Bethesda", 3400, "Jassica", 4, 2, 7, 3);
		// the property again can not be added due to not withing management's plot
		assertEquals(mgmComp.addProperty(p5), -3);
		// chaning property position again to fit within plot of compnay and not overlap
		p5 = new Property("The Town Center", "Bethesda", 3400, "Jassica", 4, 2, 6, 3);
		// the property should be added to index 4
		assertEquals(mgmComp.addProperty(p5), 4);
		// student should add property that exceeds the size of the mgmt co array and
		// can not be added, add property should return -1
		Property p6 = new Property("On Cloud", "Sky", 1400, "No Body", 1, 6, 2, 3);
		assertEquals(mgmComp.addProperty(p6), -1);
	}

	@Test
	public void testMaxRentProp() {
		// student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmComp.maxRentProp(), 2300, 0);
	}

	@Test
	public void testTotalRent() {
		// student should test if totalRent returns the total rent of properties
		assertEquals(mgmComp.totalRent(), 5050, 0);
	}

}
