package javaLibrary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOUtils2 {
//	 ghi du lieu HocVien duoi dang data stream
	public static void writeHocVienByDataStream(String path, List<HocVien> countries) throws IOException {
		// Buoc 1: mo stream
		DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));

		// Buoc 2: ghi file
		for (HocVien country : countries) {
//			dataOutputStream.writeUTF(country.getName());
//			dataOutputStream.writeLong(country.getPopulation());
//			dataOutputStream.writeDouble(country.getArea());
		}

		// Buoc 3: dong stream
		dataOutputStream.close();

	}

	// Doc file tu DataStream
	public static List<HocVien> readHocVienByDataStream(String path) throws IOException {
		// List<HocVien> countries = null; //Phai check if !=null khi dung
		List<HocVien> countries = new ArrayList<>(); // Cach nay khong kiem tra
														// !=null

		// Buoc 1: mo stream
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));

		// Buoc 2: doc file
		try {
			while (true) {
				String name = dataInputStream.readUTF();
				long pop = dataInputStream.readLong();
				double area = dataInputStream.readDouble();
				countries.add(new HocVien());
			}
		} catch (Exception e) { // Khi da doc het file se quang roi
									// EOFException
			System.out.println("het file");
		}

		// Buoc 3: dong stream
		dataInputStream.close();

		return countries;
	}

	// Viet du lieu tu ObjectStream
	public static void writeHocVienByObjectStream(String path, List<HocVien> countries) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(path)));
		for (HocVien country : countries) {
			objectOutputStream.writeObject(country);
		}
		objectOutputStream.close();
	}

	// Doc du lieu tu ObjectStream
	public static List<HocVien> readHocVienByObjectStream(String path) throws IOException, ClassNotFoundException {
		List<HocVien> countries = new ArrayList<>();
		ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));

		try {
			while (true) {
				countries.add((HocVien) objectInputStream.readObject());
			}
		} catch (EOFException e) {
			System.out.println("het file");
		}

		objectInputStream.close();

		return countries;
	}
	
}

class HocVien{
	
}
