package pass;


import java.lang.System;
public class DoublePass {

	double a;
	double b;
	double c;

	public DoublePass(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public static double doubleTest() {
		double e = 2.0 + 3.0;
		double a = 2.0 + 3.0;
		double b = 2.0 + 3.0;
		double k = 2.0 + 3.0;
		return e;
	}
	public static double doubleTest(double d) {
		double e = 2.0 + 3.0;
		return d;
	}

	public static double doubleSubtract(double d, double e) {
		return d - e;
	}
	public static double doublePlus(double d, double e) {
		return d + e;
	}

	public static double doubleSub(double d, double e) {
		return d - e;
	}

	public static double doubleMult(double d, double e) {
		return d * e;
	}

	public static double doubleDiv(double d, double e) {
		return d / e;
	}

	public static double doubleRem(double d, double e) {
		return d % e;
	}
	public static double doubleMinusAssignment(double d) {
		d -= 3.0;
		return d;
	}

	public static double doubleAddAssignment(double d) {
		d += 3.0;
		return d;
	}

	public static double doubleMultAssignment(double d) {
		d *= 3.0;
		return d;
	}

	public static double doubleDivAssignment(double d) {
		 d /= 2.0;
		return d;
	}

	public static double doubleModAssignment(double d) {
		d %= 3.0;
		return d;
	}
}
