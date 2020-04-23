// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * JUnit test suite for running the j-- programs in tests/pass.
 */

public class JMinusMinusTestRunner {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(FactorialTest.class);
		/*suite.addTestSuite(GCDTest.class);
		suite.addTestSuite(SeriesTest.class);
		suite.addTestSuite(ClassesTest.class);
		suite.addTestSuite(DivisionTest.class);
		suite.addTestSuite(RemainderTest.class);
		suite.addTestSuite(ShiftLeftTest.class);
		suite.addTestSuite(ShiftRightTest.class);
		suite.addTestSuite(UnaryPlusTest.class);
		suite.addTestSuite(IAndTest.class);
		suite.addTestSuite(IXorTest.class);
		suite.addTestSuite(IOrTest.class);
		suite.addTestSuite(IUComTest.class);
		suite.addTestSuite(NotEqualTest.class);*/
		//suite.addTestSuite(LogicalOrTest.class);
		//suite.addTestSuite(ForLoopTest.class);
		//suite.addTestSuite(ForEachTest.class);
//		suite.addTestSuite(HelloWorldTest.class);
//		suite.addTestSuite(ForStatementsTest.class);
		return suite;
	}

	/**
	 * Runs the test suite using the textual runner.
	 */

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
