package pass;
import java.util.ArrayList;
import java.util.Iterator;

public class ForStatements {

//	public int forLoop(int acc) {
//		for (int i = 5; i > 0; i--) {
//			acc = acc + i;
//		}
//		return acc;
//	}

	public int forEachCollection(int acc) {
		ArrayList array = new ArrayList();
		array.add((Object)"hej");
		array.add((Object)"hej");
		array.add((Object)"hej");
		for (Object i : array){
			acc = acc + 1;
			acc -= 1;
			acc += 1;
			acc += 1;
		}

// 		ArrayList strings = new ArrayList();
		// How for each loop should look on collections
//		for (Iterator i = strings.iterator() ; i.hasNext();) {
//			String string = (String)i.next();
//			 //Statements
//		}
		return acc;
	}


//	public int forEachArray(int i) {
//		int[] nArray = new int[]{1,2,3};
//		for (int n : nArray){
//			i+=n;
//		}
//
//		return i;
//	}
}