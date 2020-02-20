package fail;

import java.lang.System;

public class UnaryPlus {
	public static void main(String[] args) {
		int i = 10;
		char ch = 'Z';
		boolean tv = false;
		i = 10;
		System.out.println(i);
		i = +i;
		System.out.println(i + i);
		i = +tv;
		System.out.println(i+i+i);
	}
	
}
