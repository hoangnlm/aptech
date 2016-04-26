package java2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Test <T> implements Serializable {

}

class Test2 <T extends Serializable>{
	
}

public class ngay0704 {
	static Scanner sc = new Scanner(System.in);
	static String input;

	public static void main(String[] args) {
		Integer[] i = new Integer[10];
		Test<Integer>[] hehe = new Test[10];
		
		Test2<Test> test2 = new Test2();

//		System.out.print("Chon kieu int (1), kieu double (2), kieu String (3): ");
//		input = sc.nextLine().trim();
//
//		switch (Integer.parseInt(input)) {
//		case 1:
//			checkMaxInt();
//			break;
//		case 2:
//			checkMaxDouble();
//			break;
//		case 3:
//			checkMaxString();
//			break;
//		}
		
		double t = 123;
		test(t);
		
	}
	
//	private static <?> void testM(? obj){
//		
//	}
	
	private static <T extends Number> void test(T obj){
		System.out.println(obj.getClass());
	}

	private static void checkMaxInt() {
		ArrayList<Integer> n = new ArrayList<>();
		int i = 1;

		do {
			System.out.print("Nhap so int thu " + (i++) + " (enter de ket thuc): ");
			input = sc.nextLine().trim();

			if (input.isEmpty()) {
				break;
			} else {
				n.add(Integer.parseInt(input));
			}
		} while (true);

		System.out.print("So int lon nhat la: " + checkMax(n.toArray(new Integer[0])));
	}

	private static void checkMaxDouble() {
		ArrayList<Double> n = new ArrayList<>();
		int i = 1;

		do {
			System.out.print("Nhap so double thu " + (i++) + " (enter de ket thuc): ");
			input = sc.nextLine().trim();

			if (input.isEmpty()) {
				break;
			} else {
				n.add(Double.parseDouble(input));
			}
		} while (true);

		System.out.print("So double lon nhat la: " + checkMax(n.toArray(new Double[0])));

	}

	private static void checkMaxString() {
		ArrayList<String> n = new ArrayList<>();
		int i = 1;

		do {
			System.out.print("Nhap chuoi thu " + (i++) + " (enter de ket thuc): ");
			input = sc.nextLine().trim();

			if (input.isEmpty()) {
				break;
			} else {
				n.add(input);
			}
		} while (true);

		System.out.print("Chuoi lon nhat la: " + checkMax(n.toArray(new String[0])));

	}

	public static <T extends Comparable<T>> T checkMax(T... n) {
		T max = n[0];

		for (int i = 1; i < n.length; i++) {
			if (n[i].compareTo(max) > 0) {
				T tmp = max;
				max = n[i];
				n[i] = tmp;
			}
		}

		return max;
	}
}
