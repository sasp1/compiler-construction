package pass;

public class ForStatements {

//	public int forLoop(int acc) {
//		for (int i = 5; i > 0; i--) {
//			acc = acc + i;
//		}
//		return acc;
//	}

	public int foreach(int acc) {
		int[] array = {0,1,2,3};
		for (int i : array) {
			acc = acc + i;
		}
		return acc;
	}
}
