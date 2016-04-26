package mainPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOUtils2 {
	private static String filePath;
	private static File file;

	public IOUtils2() {
		filePath = "/Users/Hoang/Documents/Eclipse/workspace/com.aptech.java2.asm05/src/mainPkg/bank";
		file = new File(filePath);

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Loi tao file moi: " + e.getMessage());
		}
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		IOUtils2.filePath = filePath;
	}

	// Write from ObjectStream to file
	public static void writeObjectStream(Bank bank) {
		ObjectOutputStream objectOutputStream = null;

		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
			objectOutputStream.writeObject(bank);
			objectOutputStream.close();
		} catch (Exception e) {
			System.out.println("Loi ghi file: " + e.getMessage());
		}
	}

	// Read from file to object
	public static Bank readObjectStream() {
		Bank bank = null;
		ObjectInputStream objectInputStream = null;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
			bank = (Bank) objectInputStream.readObject();
			objectInputStream.close();
		} catch (Exception e) {
			if (e.getMessage() != null)
				System.out.println("Loi doc file: " + e.getMessage());
		}

		return bank;
	}
}
