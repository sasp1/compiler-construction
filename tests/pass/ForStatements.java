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

	public void forEachWithSameVariableName(int[] nArray){

		for (int item : nArray){

		}

		for (int item : nArray){

		}
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

	public void foriWithSameNameIncrementer_adds10(int x){
		for (int i = 0; i < 5; i++) {
			x++;
			int j = 2;
			j+=i;
		}

		for (int i = 0; i < 5; i++) {
			x++;
			int j =3;
		}
	}

//	public int forLoopWithBreak_adds10(int x ) {
//		for (int i = 0; i < 10; i++) {
//			if (i == 2){
//				x += 10;
//				break;
//			}
//		}
//		return x;
//	}
//
//	public void testingWhile(){
//		while (true){
//			break;
//		}
//	}
//
//	public int forLoopWithoutCondition_adds10(int x) {
//		for (int i = 0; ; i++) {
//			x++;
//			if (i == 10) {
//				break;
//			}
//		}
//		return x;
//	}

	public int foriLoopWithoutIncrementer_adds10(int x){
		for (int i = 0; i < 10; ) {
			x++;
			i++;
		}
		return x;
	}


	public int foriWithoutIncrementer_adds10(int x) {
		int i = 0;
		for (; i < 10; i++) {
			x++;
		}
		return x;
	}

	public int foriWithoutBody_adds10(int x) {
		for (int i = 0; i < 10; i++);
		return x+10;
	}
}