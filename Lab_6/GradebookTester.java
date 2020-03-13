import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	GradeBook grades1, grades2;

	@BeforeEach
	void setUp() throws Exception {
		grades1 = new GradeBook(3);
		grades2 = new GradeBook(3);
		grades1.addScore(92.2);
		grades1.addScore(78.2);

		grades2.addScore(76.2);
		grades2.addScore(80);
		grades2.addScore(100);

	}

	@AfterEach
	void tearDown() throws Exception {
		grades1 = null;
		grades2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(grades1.toString().equals("92.2 78.2 0.0 "));
		assertTrue(grades2.toString().equals("76.2 80.0 100.0 "));
		
	}

	@Test
	void testSum() {
		assertEquals(grades1.sum(),170.4);
		assertEquals(grades2.sum(),256.2);
	}

	@Test
	void testMinimum() {
		assertEquals(grades1.minimum(),78.2);
		assertEquals(grades2.minimum(),76.2);
	}

	@Test
	void testFinalScore() {
		assertEquals(grades1.finalScore(),(170.4-78.2));
		assertEquals(grades2.finalScore(),(256.2-76.2));
	}

	@Test
	void testGetScoreSize() {
		assertEquals(grades1.getScoreSize(), 2);
		assertEquals(grades2.getScoreSize(), 3);
	}

	@Test
	void testToString() {
		assertTrue(grades1.toString().equals("92.2 78.2 0.0 "));
		assertTrue(grades2.toString().equals("76.2 80.0 100.0 "));
	}

}
