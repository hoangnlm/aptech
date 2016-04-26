package java2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

import java2.DataStructure.DataStructureIterator;

class ThuNghiem implements DataStructureIterator {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}

}

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}

public class DataStructure {
	/*
	 * 1. Define a method named print(DataStructureIterator iterator). Invoke
	 * this method with an instance of the class EvenIterator so that it
	 * performs the same function as the method printEven.
	 * 
	 * 2. Invoke the method print(DataStructureIterator iterator) so that it
	 * prints elements that have an odd index value. Use an anonymous class as
	 * the method's argument instead of an instance of the interface
	 * DataStructureIterator.
	 * 
	 * 3. Define a method named print(java.util.Function<Integer, Boolean>
	 * iterator) that performs the same function as print(DataStructureIterator
	 * iterator). Invoke this method with a lambda expression to print elements
	 * that have an even index value. Invoke this method again with a lambda
	 * expression to print elements that have an odd index value.
	 * 
	 * 4. Define two methods so that the following two statements print elements
	 * that have an even index value and elements that have an odd index value:
	 * 
	 * DataStructure ds = new DataStructure() // ...
	 * ds.print(DataStructure::isEvenIndex);
	 * ds.print(DataStructure::isOddIndex);
	 */

	public static void main(String s[]) {

		// Fill the array with integer values and print out only
		// values of even indices
		DataStructure ds = new DataStructure();
		ds.printEven();
		ds.print(ds.new EvenIterator());
		ds.print(new DataStructureIterator() {
			private int nextIndex = 1;

			@Override
			public Integer next() {
				// Record a value of an even index of the array
				Integer retValue = Integer.valueOf(ds.arrayOfInts[nextIndex]);

				// Get the next even element
				nextIndex += 2;
				return retValue;
			}

			@Override
			public boolean hasNext() {
				return nextIndex < SIZE;
			}
		});
		ds.print(i -> i % 2 == 0 ? false : true);
		ds.print(i -> i % 2 == 0 ? true : false);
		System.out.print("So nguyen to trong mang: ");
		ds.print(SoNguyenTo::check);

		ds.print(ds::isEven);
		ds.print(ds::isOdd);
//		ds.print2(i -> i % 2 == 0 ? false : true);
//		ds.print2(SoNguyenTo::check);
		
		System.out.println("enum test: ");
		System.out.println(Day.MONDAY.compareTo(Day.SUNDAY));
		System.out.println(Arrays.toString(Day.values()));
		
	}

	// Create an array
	private final static int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];

	public DataStructure() {
		// fill the array with ascending integer values
		for (int i = 0; i < SIZE; i++) {
			arrayOfInts[i] = i;
		}
	}
	
	public boolean isEven(int n){
		return n%2==0?true:false;
	}
	
	public boolean isOdd(int n){
		return n%2!=0?true:false;
	}

	public void printEven() {

		// Print out values of even indices of the array
		EvenIterator iterator = new EvenIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	public void print(DataStructureIterator iterator) {
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	public void print(Function<Integer, Boolean> function) {
		for (int i = 0; i < arrayOfInts.length; i++) {
			if (function.apply(arrayOfInts[i]))
				System.out.print(arrayOfInts[i] + " ");
		}
		System.out.println();
	}

	public void print2(Predicate<Integer> predicate) {
		for (int i = 0; i < arrayOfInts.length; i++) {
			if (predicate.test(i))
				System.out.print(arrayOfInts[i] + " ");
		}
		System.out.println();
	}

	interface DataStructureIterator extends Iterator<Integer> {
	}

	public class EvenIterator implements DataStructureIterator {

		// Start stepping through the array from the beginning
		private int nextIndex = 0;

		public boolean hasNext() {

			// Check if the current element is the last in the array
			return (nextIndex <= SIZE - 1);
		}

		public Integer next() {

			// Record a value of an even index of the array
			Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

			// Get the next even element
			nextIndex += 2;
			return retValue;
		}
	}
}

class SoNguyenTo {
	static boolean check(int n) {
		for (int i = 1; i < n; i++) {
			if (n % i == 0 && i != 1)
				return false;
		}
		return n == 0 ? false : true;
	}
}