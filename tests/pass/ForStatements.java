package pass;
import java.util.ArrayList;

public class ForStatements {

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

	public int sumArray(int n, int[] intArray) {
		for (int i = 0; i < intArray.length; ++i) {
			n += intArray[i];
		}
		return n;
	}

	public String stringBuilderArray(String n, String[] stringArray) {
		for (int i = 0; i < stringArray.length; ++i) {
			n += stringArray[i];
		}
		return n;
	}

}