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
		this.assertEquals(interfaceExtendingClass.method1(4), 4);
		this.assertEquals(interfaceExtendingClass.stringMethod(4), "4");
		this.assertEquals(interfaceExtendingClass.doubleMethod(4.0), 4.0);
		this.assertEquals(interfaceExtendingClass.method2(4), 6);
		this.assertEquals(interfaceExtendingClass.method3(4), 7);
	}
}
