package pass;

public class ForStatements {
	public int forLoop(int acc) {
		acc = 0;
		for (int i = 5; i > 0; i--) {
			acc = acc + i;
		}
		return acc;
	}
	
	public int foreach(int acc) {
		int[] array = {0,1,2,3,4};
		for (int i : array) {
			acc = acc + i;
		}
		return acc;
	}

}
