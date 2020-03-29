package fail;

public class ForLoop {
	public static void main(String[] args) {
		int acc = 0;
		for (int i = 10; i*2; i++) {
			acc = acc + i;
		}
		System.out.println(acc != 0);
	}

}
