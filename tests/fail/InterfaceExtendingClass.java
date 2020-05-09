package fail;

interface InterfacePass { 
	public int method1(int x);
	public String stringMethod(int x);
	public double doubleMethod(double x); 
}

public class InterfaceExtendingClass implements InterfacePass {
	public int interfacePass(int i) {
		return i;
	}
	
	public int method1(int x) { 
		return x; 
	}
	
	public String stringMethod(int x) {
		return "" + x; 
	}
}

