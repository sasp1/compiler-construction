package pass;
import java.lang.System;
public class ForStatements {

	public static void main(String[] args) {

	}

	public String foreach(String str, String[] arr) {
		for (String i : arr) {
			str = i + str;
		}
		return str;
	}
}
