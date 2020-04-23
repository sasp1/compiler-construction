package junit;

import junit.framework.TestCase;
//import pass.InterfacePass;
//import pass.InterfaceExtendingClass;

public class InterfaceTest extends TestCase {
//	private InterfacePass interfacePass;

	protected void setUp() throws Exception {
		super.setUp();
//		interfacePass = new InterfaceExtendingClass();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIOr() {
//		this.assertEquals(interfacePass.interfacePass(1), 1);
//		this.assertEquals(interfacePass.interfacePass(15), 15);
	}
}