package pass;


interface InterfacePass { 
	public int method1(int x);
	public String stringMethod(int x);
//	public double doubleMethod(double x);
}

interface ThirdInterface { 
	public int method3(int x); 
}

interface SecondInterface extends ThirdInterface { 
	public int method2(int x); 
}


public class InterfaceExtendingClass implements pass.InterfacePass, SecondInterface {
	public int interfacePass(int i) {
		return i;
	}
	
	public int method1(int x) { 
		return x; 
	}
	
	public String stringMethod(int x) {
		return "" + x; 
	}

//	public double doubleMethod(double x) {
//		return x;
//	}
	
	public int method2(int x) { 
		return x + 2; 
	}
	
	public int method3(int x) { 
		return x + 3; 
	}
	
//	public static void main(String[] args) {
//	    InterfaceExtendingClass tmp = new InterfaceExtendingClass(); 
//	    System.out.println(tmp.method1(4));
//	}
}

