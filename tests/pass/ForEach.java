package pass;

public class ForEach {
	public int foreach(int acc) {
		int[] array = {0,1,2,3,4};
		for(int i : array) {
			acc = acc + i;
		}
		return acc;
	}
}
