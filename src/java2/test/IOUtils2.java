package java2.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class IOUtils2 extends ConsoleUtils {
	private static String filePath;
	private static File file;

	public IOUtils2() {
		filePath = "/Users/Hoang/Documents/Eclipse/workspace/com.aptech.java2.test/src/mainPkg/tmp";
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
	public static void writeObjectStream(List<Event> events) {
		ObjectOutputStream objectOutputStream = null;

		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
			objectOutputStream.writeObject(events);
			objectOutputStream.close();
		} catch (Exception e) {
			System.out.println("Loi ghi file: " + e.getMessage());
		}
	}

	// Read from file to object
	public static List<Event> readObjectStream() {
		List<Event> events = null;
		ObjectInputStream objectInputStream = null;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
			events = (List<Event>) objectInputStream.readObject();
			objectInputStream.close();
		} catch (Exception e) {
			if (e.getMessage() != null)
				System.out.println("Loi doc file: " + e.getMessage());
		}

		return events;
	}
}
