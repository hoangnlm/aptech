package java2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ngay0904 {

	public static void main(String[] args) throws Exception {
		// FileInputStream fileInputStream = new
		// FileInputStream("/Users/Hoang/Documents/Eclipse/workspace/com.aptech/bin/java2/test.txt");
		// int t;
		// while((t = fileInputStream.read()) != -1){
		// System.out.print((char)t);
		// }

		// fileInputStream.reset();
		// System.out.println(fileInputStream.markSupported());
		// System.out.println(t);
		// FileOutputStream fileOutputStream = new FileOutputStream("hihi");
		// fileOutputStream.write(fileInputStream.read());

		// fileInputStream.close();
		// fileOutputStream.close();
		// String fname =
		// "/Users/Hoang/Documents/Eclipse/workspace/com.aptech/bin/java2/test.txt";
		// FileReader fileReader = new
		// FileReader("/Users/Hoang/Documents/Eclipse/workspace/com.aptech/bin/java2/test.txt");
		//// System.out.println(fileReader.markSupported());
		// BufferedReader bufferedReader = new BufferedReader(fileReader);
		// System.out.println(bufferedReader.markSupported());
		// System.out.println();
		// BufferedInputStream bufferedInputStream = new BufferedInputStream(new
		// FileInputStream(fname));
		// System.out.println(bufferedInputStream.markSupported());
		// bufferedReader.mark((int) new
		// File("/Users/Hoang/Documents/Eclipse/workspace/com.aptech/bin/java2/test.txt").length()+1);
		//
		// FilterInputStream filterInputStream = new DataInputStream(new
		// FileInputStream(fname));
		// System.out.println("filter: "+filterInputStream.markSupported());
		//
		// int j = 0;
		// while((j= bufferedReader.read())!=-1){
		// System.out.print((char)j);
		// }
		//
		// System.out.println();
		// bufferedReader.reset();
		//
		// while((j= bufferedReader.read())!=-1){
		// System.out.print((char)j);
		// }
		//
		// bufferedReader.close();

		// ByteArrayInputStream arrayInputStream = new
		// ByteArrayInputStream(fname.getBytes());
		// System.out.println(arrayInputStream.markSupported());
		// arrayInputStream.close();
		//
		// CharArrayReader arrayReader = new
		// CharArrayReader(fname.toCharArray());
		// System.out.println(arrayReader.markSupported());
		// arrayReader.close();
		// System.out.println("hehe");
		// System.out.println(System.getenv());
		// System.out.println(System.console());

		Path pathObj = Paths
		.get("/Users/Hoang/Documents/Eclipse/workspace/com.aptech/src/java2/test.txt");
		URI uriObj = URI.create("http://www.aptech-worldwide.com/");
		try (InputStream inObj = uriObj.toURL().openStream()) {
			Files.copy(inObj, pathObj, StandardCopyOption.REPLACE_EXISTING);
		} catch (final MalformedURLException e) {
			System.out.println("Exception" + e);
		} catch (IOException e) {
			System.out.println("Exception" + e);
		}
		
		
	}
}
