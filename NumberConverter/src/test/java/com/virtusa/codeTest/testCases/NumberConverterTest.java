package com.virtusa.codeTest.testCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.codeTest.NumberConverter;

public class NumberConverterTest {

	@Before
	public void setUp() throws Exception {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private NumberConverter createTestSubject() {
		return new NumberConverter();
	}

	@Test
	public void testConvert() throws Exception {
		NumberConverter testSubject;
		int number = 0;
		String result;

		// test 1
		testSubject = createTestSubject();
		number = 0;
		result = testSubject.convert(number);
		Assert.assertEquals("", result);

		// test 2
		testSubject = createTestSubject();
		number = 1;
		result = testSubject.convert(number);
		Assert.assertEquals("", result);

		// test 3
		testSubject = createTestSubject();
		number = 0;
		result = testSubject.convert(number);
		Assert.assertEquals("", result);

		// test 4
		testSubject = createTestSubject();
		number = -1;
		result = testSubject.convert(number);
		Assert.assertEquals("", result);

		// test 5
		testSubject = createTestSubject();
		number = 1;
		result = testSubject.convert(number);
		Assert.assertEquals("", result);

		Assert.fail();
	}
}