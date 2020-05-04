package pass;
import java.util.ArrayList;

public class ForStatements {
	//	public static void main(String[] args) {
	//
	//	}

	public String forEachCollection(String acc, ArrayList numbers) {
		for (Object i : numbers){
			acc = acc + (String)i;
		}
		return acc;
	}



	public int forEachArray(int n, int[] nArray) {
		for (int item : nArray){
			n = item + n;
		}

		return n;
	}
}