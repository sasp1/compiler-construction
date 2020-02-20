package pass;

public class UnaryPlus {
	public static int unaryplus(int i) {
		int integer = i;
		return +integer;
	}
	
	public static int unaryplus(char ch) {
		char c = ch;
		return +c;
	}
	
	public static void main(String[] args) {
		char ch = 'Z';
		System.out.println("The value of Z is " + unaryplus(+ch));
		
		int i = 10;
		System.out.println("The value of i is " + unaryplus(+i));
	}

}
