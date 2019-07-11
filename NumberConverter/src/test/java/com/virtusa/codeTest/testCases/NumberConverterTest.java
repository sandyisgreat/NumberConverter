package com.virtusa.codeTest.testCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.codeTest.NumberConverter;
import com.virtusa.codeTest.NumberConverterException;

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

	@Test(expected = NumberConverterException.class)
	public void testConvert() throws NumberConverterException {
		NumberConverter testSubject;
		int number = 0;
		String result;

		// test 1
		testSubject = createTestSubject();
		number = 0;
		result = testSubject.convert(number);
		Assert.assertEquals("zero", result);

		// test 2
		testSubject = createTestSubject();
		number = 121;
		result = testSubject.convert(number);
		Assert.assertEquals("one hundred twenty one", result);

//		// test 3
		testSubject = createTestSubject();
		number = -1;
		result = testSubject.convert(number);

		// test 4
		testSubject = createTestSubject();
		number = 123456789;
		result = testSubject.convert(number);
		Assert.assertEquals("one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine", result);

		// test 5
		testSubject = createTestSubject();
		number = 1001;
		result = testSubject.convert(number);
		Assert.assertEquals("one thousand one", result);

	}
}