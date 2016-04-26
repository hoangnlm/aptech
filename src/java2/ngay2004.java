package java2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ngay2004 {
	private int f1 = 1;
	public int f2 = 2;
	public static String s1 = "hh3h3h";
	protected String s2 = "s2";

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		int t = 1;
//		System.out.println(Class.forName("Integer").toString());
		
		Class h = Class.forName("java2.ngay2004");
		ngay2004 m = (ngay2004) h.newInstance();
		m.show();
		
		Integer t1 = 1;
		
		System.out.println(Arrays.toString(h.getFields()));
		System.out.println(Arrays.toString(h.getMethods()));
		System.out.println(h.getModifiers());
		System.out.println(m.getClass().getName());
		System.out.println(t1.getClass().getSuperclass().getSimpleName().equals("Number"));
		
		Runtime rt = Runtime.getRuntime();
//		System.out.println(rt.exec("javac -v").exitValue());
	}
	
	protected void show(){
		System.out.println("tao la show");
	}
}
