package junit;

import junit.framework.TestCase;
import pass.InterfaceExtendingClass;

public class InterfaceExtendingClassTest extends TestCase {
	private InterfaceExtendingClass interfaceExtendingClass;

	protected void setUp() throws Exception {
		super.setUp();
		interfaceExtendingClass = new InterfaceExtendingClass();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDivide() {
		assertEquals(interfaceExtendingClass.method1(4), 4);
		assertEquals(interfaceExtendingClass.stringMethod(4), "4");
		assertEquals(interfaceExtendingClass.doubleMethod(4.0), 4.0);
		assertEquals(interfaceExtendingClass.method2(4), 6);
		assertEquals(interfaceExtendingClass.method3(4), 7);
	}
}
