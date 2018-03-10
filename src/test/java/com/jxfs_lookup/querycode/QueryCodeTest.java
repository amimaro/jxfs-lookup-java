package com.jxfs_lookup.querycode;

import com.jxfs_lookup.main.JxfsLookup;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple query.
 */
public class QueryCodeTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public QueryCodeTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(QueryCodeTest.class);
	}

	/**
	 * Query code test
	 */
	public void testApp() {
		JxfsLookup jxfsLookup = new JxfsLookup();
		assertTrue(jxfsLookup.querycode("1024").size() > 0);
		assertTrue(jxfsLookup.querycode(1024).size() > 0);
		assertTrue(jxfsLookup.querycode("0").size() > 0);
		assertTrue(jxfsLookup.querycode(0).size() > 0);
		assertTrue(jxfsLookup.querycode("900").size() > 0);
		assertTrue(jxfsLookup.querycode(900).size() > 0);
	}
}
