package pass;

public class Conditional {
	public int conditional(boolean x, int returnVal1, int returnVal2) {
		return x ? returnVal1 : returnVal2;
	}

	public int nestedConditional(boolean x, boolean y, int returnVal1, int returnVal2) {
		return x ? y ? returnVal1 : -1  : returnVal2;
	}

	public int nestedConditionalExtreme(boolean x, boolean y, int returnVal1, int returnVal2) {
		return x ? y ? returnVal1 : -1  : x ? returnVal1 : returnVal2;
	}

	public String nestedConditionalString(boolean x, boolean y, String returnVal1, String returnVal2) {
		return x ? returnVal1 : (y ? returnVal2 : "else else" );
	}

	public int conditionalExampleFromReport () {
		return false ? true ? 0 : -1 : true ? -2 : -3;
	}

	public int anotherTest () {
		return true ? false ? 0 : -1 : true ? -2 : -3;
	}

	public int return1() {
		return 1;
	}

	public int return2() {
		return 2;
	}

	public int checkIfMethodsCanBeUsed(boolean b){
		return b ? return1() : return2();
	}

}
