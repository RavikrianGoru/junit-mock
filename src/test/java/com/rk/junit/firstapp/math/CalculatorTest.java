package com.rk.junit.firstapp.math;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


public class CalculatorTest {

	private Calculator calculator;

	@BeforeAll
	public static void setUp() throws Exception {
		System.out.println("*****BeforeAll*****");
	}

	@BeforeEach
	public void setUpEach() throws Exception {
		System.out.println("=====BeforeEach=====");
		calculator = new Calculator();
	}

	@Test
	@Tag("DEV")
	@DisplayName("Sample test for addTwo method")
	public void testAddTwo() throws Exception {
		Assertions.assertEquals(5, calculator.addTwo(2, 3), "Regulart addtion should work");
	}

	@Test
	@Tag("DEV")
	@DisplayName("Sample test for subTwo method")
	public void testSubTwo() throws Exception {
		Assertions.assertEquals(2, calculator.subTwo(5, 3), "Regulart subtraction should work");
	}

	@Test
	@Tag("DEV")
	@DisplayName("Sample test to multiplyTwo method")
	public void testMultiplyTwo() throws Exception {
		Assertions.assertEquals(10, calculator.multiplyTwo(2, 5), "Regulart multiply should work");
	}

	@RepeatedTest(3)
	@DisplayName("Sample test to multiplyTwo method handling with zero")
	public void testZeroHandlingInMultiplyTwo() throws Exception {
		Assertions.assertEquals(10, calculator.multiplyTwo(2, 5), "Regulart multiply should work");
	}

	@Test
	@Tag("DEV")
	@DisplayName("Sample test to divideTwo method for ArithmeticException")
	public void testException() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			calculator.divideTwo(5, 0);
		});
		
		
		Throwable exception = Assertions.assertThrows(ArithmeticException.class, () -> {
			calculator.divideTwo(5, 0);
		});
		Assertions.assertEquals(exception.getMessage(), "/ by zero");
	}

	@Test
	@DisplayName("Sample test and disabled")
	@Tag("PROD")
	@Disabled("Sample test and disabled:why this is diabled")
	public void testX() {
		Assertions.assertEquals(10, calculator.multiplyTwo(2, 5), "Regulart multiply should work");
	}

	@Test
	@Tag("PROD")
	@DisplayName("Sample test to try grouped assertion")
	public void testGroupedAssertions() throws Exception {
		Assertions.assertAll("All operations", () -> {
			Assertions.assertEquals(10, calculator.addTwo(5, 5));
		}, () -> {
			Assertions.assertEquals(1, calculator.divideTwo(5, 5));
		}, () -> {
			Assertions.assertEquals(25, calculator.multiplyTwo(5, 5));
		});
	}

	@Test
	@DisplayName("Sample test with assertimeout")
	public void testDoActionWithinTime() throws Exception {
		Assertions.assertTimeout(Duration.ofSeconds(11), () -> calculator.doAction());
	}

	@Test
	@DisplayName("Sample test with assertimeout")
	public void testDoActionWithinTimeAndReturn() throws Exception {
		int result = Assertions.assertTimeout(Duration.ofSeconds(11), () -> {
			return calculator.doAction();
		});
	}

	@TestFactory
	@DisplayName("Sample DynamicTest example")
	public Stream<DynamicTest> doDynamicTest() throws Exception {

		int[][] data = new int[][] { { 1, 2, 2 }, { 4, 5, 20 }, { 4, 10, 40 } };
		return Arrays.stream(data).map(entry -> {
			int m1 = entry[0];
			int m2 = entry[1];
			int expected = entry[2];
			
			return DynamicTest.dynamicTest(m1 + " * " + m2 + " = " + expected, 
					() -> {
							Assertions.assertEquals(expected, calculator.multiplyTwo(m1, m2));
							});
		});
	}

	
	//1
	public static int[][] data()
	{
		return new int[][] {{1,2,3},{4,5,9},{6,7,13}};
	}

	@ParameterizedTest
	@MethodSource(value="data")
	@DisplayName("Sample ParmeterizedTest with @MethodSource example")
	public void doParamaterizedTest1(int[] data) throws Exception
	{
		int m1=data[0];
		int m2= data[1];
		int expected=data[2];
		Assertions.assertEquals(expected, calculator.addTwo(m1, m2));
	}
	

	//2
	@ParameterizedTest
	@ValueSource(ints = {5,6,11})
	@DisplayName("Sample ParmeterizedTest with @ValueSource example")
	public void doParamaterizedTest2(int x) throws Exception
	{
		Assertions.assertNotEquals(x, 0);
	}

	
	
	@Test
	@DisplayName("Sample test to use Assumtions")
	public void testOnDev() throws Exception
	{
		System.setProperty("env","DEV");
		Assumptions.assumeTrue("DEV".equalsIgnoreCase(System.getProperty("env")));
		//remainder of test will proceed
	}
	
	@Test
	@DisplayName("Sample test to use Assumtions")
	public void testOnProd() throws Exception
	{
		System.setProperty("env","DEV");
		Assumptions.assumeTrue("PROD".equalsIgnoreCase(System.getProperty("env")));
		//remainder of test will be aborted
		Assertions.assertNotEquals(5, 5);
	}

	@AfterEach
	public void tearUpEach() throws Exception {
		System.out.println("=====AfterEach=====");
		calculator = null;
	}

	@AfterAll
	public static void tearUp() throws Exception {
		System.out.println("*****AfterAll*****");
	}
}
