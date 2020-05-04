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

		// already there
		suite.addTestSuite(FactorialTest.class);
		suite.addTestSuite(GCDTest.class);
		suite.addTestSuite(SeriesTest.class);
		suite.addTestSuite(ClassesTest.class);
		suite.addTestSuite(HelloWorldTest.class);

		// operators -- STEP 0!
		suite.addTestSuite(DivisionTest.class);
		suite.addTestSuite(RemainderTest.class);
		suite.addTestSuite(ShiftLeftTest.class);
		suite.addTestSuite(ShiftRightTest.class);
		suite.addTestSuite(ShiftRightUnsignTest.class);
		suite.addTestSuite(UnaryPlusTest.class);
		suite.addTestSuite(IAndTest.class);
		suite.addTestSuite(IXorTest.class);
		suite.addTestSuite(IOrTest.class);
		suite.addTestSuite(IUComTest.class);

		// assignment
		suite.addTestSuite(PlusAssignTest.class);
		suite.addTestSuite(RemAssignTest.class); // step 5
		suite.addTestSuite(MinusAssignTest.class); // step 5
		suite.addTestSuite(MultAssignTest.class); // step 5
		suite.addTestSuite(DivisionAssignTest.class); // step 5
//
		suite.addTestSuite(LogicalOrTest.class); // step 5
		suite.addTestSuite(BlockTest.class); // step 5
//		suite.addTestSuite(ForStatementsTest.class);
		suite.addTestSuite(ExceptionHandlingTest.class);
		suite.addTestSuite(ConditionalTest.class);
		suite.addTestSuite(MultilineCommentTest.class);
		return suite;
	}

	/**
	 * Runs the test suite using the textual runner.
	 */

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
