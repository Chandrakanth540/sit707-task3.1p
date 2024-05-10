package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S223798216";
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Chandrakanth";
		Assert.assertNotNull("Student name is ", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
	    // January min boundary area: min+1
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
	    // January min boundary area: min-1
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testOtherMonths() {
	    // Test for other months of 2024
	    for (int month = 2; month <= 12; month++) {
	        int rand_day_1_to_30 = 1 + new Random().nextInt(30); // Assuming all months have 30 days
	        DateUtil date = new DateUtil(rand_day_1_to_30, month, 2024);
	        System.out.println("testOtherMonths > " + date);
	        date.increment();
	        System.out.println(date);
	    }
	}
	
	@Test
	public void testPreviousDate() {
	    int[][] testCases = {
	        {1, 6, 1994, 31, 5, 1994},
	        {2, 6, 1994, 1, 6, 1994},
	        {15, 6, 1994, 14, 6, 1994},
	        {30, 6, 1994, 29, 6, 1994},
	        {31, 6, 1994, -1, -1, -1}, // Invalid date
	        {15, 1, 1994, 14, 1, 1994},
	        {15, 2, 1994, 14, 2, 1994},
	        {15, 11, 1994, 14, 11, 1994},
	        {15, 12, 1994, 14, 12, 1994},
	        {15, 6, 1700, 14, 6, 1700},
	        {15, 6, 1701, 14, 6, 1701},
	        {15, 6, 2023, 14, 6, 2023},
	        {15, 6, 2024, 14, 6, 2024}
	    };

	    for (int[] testCase : testCases) {
	        int day = testCase[0];
	        int month = testCase[1];
	        int year = testCase[2];
	        int expectedDay = testCase[3];
	        int expectedMonth = testCase[4];
	        int expectedYear = testCase[5];

	        DateUtil date = new DateUtil(day, month, year);
	        System.out.println("Testing date: " + date);

	        

	        if (expectedDay == -1) {
	            System.out.println("Invalid date");

	        } else {
	        	date.decrement();
	            System.out.println("Expected date: " + expectedDay + "-" + expectedMonth + "-" + expectedYear);
	            Assert.assertEquals(expectedDay, date.getDay());
	            Assert.assertEquals(expectedMonth, date.getMonth());
	            Assert.assertEquals(expectedYear, date.getYear());
	        }
	    }
	}
	@Test
	public void testNextDate() {
	    int[][] testCases = {
	        {1, 6, 1994, 2, 6, 1994},
	        {2, 6, 1994, 3, 6, 1994},
	        {28, 2, 2020, 29, 2, 2020}, // Leap year
	        {29, 2, 2020, 1, 3, 2020},   // Leap year
	        {28, 2, 2021, 1, 3, 2021},   // Not a leap year
	        {29, 2, 2021, -1, -1, -1} ,   // Not a leap year (invalid date)
	        {31, 12, 2023, 1, 1, 2024}, // Last day of the year
	        {30, 4, 2022, 1, 5, 2022},   // Last day of April
	        {31, 5, 2022, 1, 6, 2022},   // Last day of May
	        {28, 2, 2021, 1, 3, 2021},   // Last day of February (non-leap year)
	        {29, 2, 2020, 1, 3, 2020},   // Last day of February (leap year)
	        {15, 1, 2000, 16, 1, 2000},   // Random date
	        {15, 6, 2024, 16, 6, 2024}
	    };

	    for (int[] testCase : testCases) {
	        int day = testCase[0];
	        int month = testCase[1];
	        int year = testCase[2];
	        int expectedDay = testCase[3];
	        int expectedMonth = testCase[4];
	        int expectedYear = testCase[5];

	        DateUtil date = new DateUtil(day, month, year);
	        System.out.println("Testing date: " + date);

	        

	        if (expectedDay == -1) {
	            System.out.println("Invalid date");
	        } else {
	        	date.increment();
	            System.out.println("Expected date: " + expectedDay + "-" + expectedMonth + "-" + expectedYear);
	            Assert.assertEquals(expectedDay, date.getDay());
	            Assert.assertEquals(expectedMonth, date.getMonth());
	            Assert.assertEquals(expectedYear, date.getYear());
	        }
	    }
	    }
	}
