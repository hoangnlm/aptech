package java2;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ngay2204 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList<ThuNghie> list = new LinkedList<>();
//		ThuNghie t1 = new ThuNghie();
//		ThuNghie t2 = new ThuNghie();
//		list.add(t1);
//		list.add(t2);
//		list.add(null);
//		list.add(t1);
//		System.out.println(list);
		
		Integer i1 = 13;
		Integer i2 = 4;
		Integer i3 = 3;
		Integer i4 = 99;
		HashSet<Integer> hs = new HashSet<>();
		hs.add(i1);
		hs.add(i2);
		hs.add(i3);
		hs.add(i4);
//		hs.add(null);
		System.out.println("hs: "+hs);

//		for (int i = 0; i < 10; i++) {
//			for (Integer integer : hs) {
//				System.out.println("hs element: " + integer);
//			} 
//			System.out.println("------");
//		}
		
		TreeSet<Integer> ts = new TreeSet<>(hs);
		System.out.println("ts: "+ts);
		for (Integer integer : ts) {
			System.out.println("hs element: "+integer);
		}
		
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(i1);
		lhs.add(i2);
		lhs.add(i3);
		lhs.add(i4);
		lhs.add(null);
		System.out.println("lhs: "+lhs);
		for (Integer integer : lhs) {
			System.out.println("hs element: "+integer);
		}
		
		System.out.println();
		
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		System.out.println(new Integer('ư'));
		System.out.println(new Integer('ừ'));
		System.out.println(new Integer('ự'));
		System.out.println((new StringBuilder(new Integer('ự').toString())).reverse());
		System.out.println((char) 1297+" "+(char) 5197);
	}
}

class ThuNghie{
	
}