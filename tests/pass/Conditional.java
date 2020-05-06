package pass;

public class Conditional {
	public int conditional(boolean x, int returnVal1, int returnVal2) {
		return x ? returnVal1 : returnVal2;
	}

	public int nestedConditional(boolean x, boolean y, int returnVal1, int returnVal2) {
		return x ? (y ? returnVal1 : -1 ) : returnVal2;
	}

	public String nestedConditionalString(boolean x, boolean y, String returnVal1, String returnVal2) {
		return x ? returnVal1 : (y ? returnVal2 : "else else" );
	}
}
