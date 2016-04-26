package javaLibrary;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Library for file IO utilities.
 * 
 * @author HoangNLM
 *
 */
public class IOUtils {
	
	// Doc file text non-Unicode
	public static void readBinaryTextFile(String path) throws IOException {
		// Buoc 1: mo stream
		FileInputStream fileInputStream = new FileInputStream(path);

		// Buoc 2: doc file
		byte[] buffer = new byte[5];
		String s = "";
		int len = 0;
		while ((len = fileInputStream.read(buffer)) != -1) {
			s += new String(buffer, 0, len);
		}
		System.out.println(s);
		
		// Buoc 3: dong stream
		fileInputStream.close();
	}

	// Ghi file text non-Unicode
	public static void writeBinaryTextFile(String path, String content) {
		try {
			// Buoc 1: mo stream
			FileOutputStream fileOutputStream = new FileOutputStream(path);

			// Buoc 2: ghi file
			fileOutputStream.write(content.getBytes());
			// fileOutputStream.flush();
			// fileOutputStream.write(new byte[]{'t','e','s','t'});

			// Buoc 3: dong stream
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Copy binary file
	public static void copyFile(String srcPath, String desPath) throws IOException {
		// Buoc 1.1: mo stream read
		FileInputStream fileInputStream = new FileInputStream(srcPath);

		// Buoc 2.1: mo stream write
		FileOutputStream fileOutputStream = new FileOutputStream(desPath);

		// Buoc 1.2: read file --> byte[]
		byte[] buffer = new byte[4096];
		int i;
		while ((i = fileInputStream.read(buffer)) != -1) {
			// Buoc 2.2: byte[] --> write file
			fileOutputStream.write(buffer, 0, i);
		}

		// Buoc 1.3: close read
		fileInputStream.close();

		// Buoc 2.3: close write
		fileOutputStream.close();
	}

	// Doc file Unicode = FileReader
	public static void readTextUnicodeFile(String path) {
		try {
			// Buoc 1
			FileReader fileReader = new FileReader(path);

			// Buoc 2
			char[] buffer = new char[7];
			int len;
			String s = "";
			while ((len = fileReader.read(buffer)) != -1) {
				s += new String(buffer, 0, len);
			}
			System.out.println(s);

			// Buoc 3
			fileReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Ghi file Unicode = FileWriter
	public static void writeTextUnicodeFile(String path, String content) throws IOException {
		// Buoc 1:
		FileWriter fileWriter = new FileWriter(path);

		// Buoc 2:
		fileWriter.write(content);

		// Buoc 3:
		fileWriter.close();
	}

	// Dung BufferInputStream
	public static void readBinaryTextFileByBuffer(String path) {
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;

		try {
			// Buoc 1: mo stream
			fileInputStream = new FileInputStream(path);
			bufferedInputStream = new BufferedInputStream(fileInputStream);

			// Buoc 2: doc file
			byte[] buffer = new byte[5];
			String s = "";
			int len = 0;
			while ((len = bufferedInputStream.read(buffer)) != -1) {
				s += new String(buffer, 0, len);
			}
			System.out.println(s);

			// Buoc 3: dong stream
			bufferedInputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Copy file Unicode dung BufferedReader va BufferedWriter
	public static void copyUnicodeFile(String src, String des) throws IOException {
		// Buoc 1: khoi tao FileReader va FileWriter
		FileReader fileReader = new FileReader(src);
		FileWriter fileWriter = new FileWriter(des);

		// Buoc 2: khoi tao BufferedReader va BufferedWriter tu FileReader va
		// FileWriter
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		// Buoc 3: xu ly doc va ghi trong BufferedReader va BufferedWriter
		String i;
		while ((i = bufferedReader.readLine()) != null) {
			bufferedWriter.write(i);
			bufferedWriter.newLine();
		}

		// Buoc 4: dong Buffered, cac FileReader va FileWriter tu dong dong luon
		bufferedReader.close();
		bufferedWriter.close();
	}
}