package java1;

import java.util.Arrays;
import java.util.Scanner;

class SinhVien {
	private String maSo, hoTen, ngaySinh, gioiTinh, dienThoai, email, maLop;
	private static int count = 1;
	private Scanner s = new Scanner(System.in);

	SinhVien() {
		showMenu();
	}

	void showMenu() {
		String option = "";
		String[] options = { "add", "disp", "exit" };
		do {
			System.out.println("Chuong trinh quan ly sinh vien:");
			System.out.println("--------------------");
			System.out.println("* add/ADD – Input");
			System.out.println("* disp/DISP – Display");
			System.out.println("* exit/EXIT – Exit application");
			System.out.print("Nhap: ");
			option = s.nextLine().trim().toLowerCase();
		} while (!Arrays.asList(options).contains(option));

		switch (option) {
		case "add":
			input();
			break;
		case "disp":
			display();
			break;
		}
	}

	/*
	 * Khi người dùng nhập “add/ADD”: Nhập thông tin cho sinh viên. Các thông
	 * tin như tên sinh viên, giới tính, ngày tháng năm sinh và số điện thoại
	 * bắt buộc phải nhập. Các thông tin khác có thể bỏ qua. Mã sinh viên được
	 * phát sinh tự động. Giới tính chỉ được phép nhập nam/Nam hoặc nữ/Nữ. Ngày
	 * tháng năm sinh phải đủ 10 ký tự.
	 */
	void input() {
		maSo = "SV0" + count++;
		System.out.println("---------------");
		System.out.println("Them thong tin sinh vien:");

		do {
			System.out.println("Ten sinh vien: ");
			hoTen = s.nextLine().trim();
		} while (hoTen.isEmpty());

		do {
			System.out.println("Gioi tinh (nam/nu): ");
			gioiTinh = s.nextLine().trim().toLowerCase();
		} while (!(gioiTinh == "nam" || gioiTinh == "nu"));

		do {
			System.out.println("Ngay sinh (yyyy/mm/dd): ");
			ngaySinh = s.nextLine().trim();
		} while (ngaySinh.length() != 10);

		do {
			System.out.println("So dien thoai: ");
			dienThoai = s.nextLine().trim();
		} while (dienThoai.isEmpty());

		System.out.println("Email: ");
		email = s.nextLine().trim();
		System.out.println("Ma lop: ");
		maLop = s.nextLine().trim();
	}

	/*
	 * Khi người dùng nhập “disp/DISP”: Hiển thị thông tin sinh viên. Chức năng
	 * này chỉ được thực hiện sau khi đã thực hiện chức năng “add/ADD”
	 */
	void display() {
		if (count == 1) {
			System.out.println("Chua co sinh vien nao!");
		} else {
			System.out.println("---------------------");
			System.out.println("Ma so: " + maSo);
			System.out.println("Ho ten: " + hoTen);
			System.out.println("Gioi tinh: " + gioiTinh);
			System.out.println("Ngay sinh: " + ngaySinh);
			System.out.println("So dien thoai: " + dienThoai);
			System.out.println("Email: " + email);
			System.out.println("Ma lop: " + maLop);
		}
	}
}

public class ngay1703 {

	public static void main(String[] args) {
		SinhVien[] sinhVien = new SinhVien[1];

		for (int i = 0; i < sinhVien.length; i++) {
			sinhVien[i] = new SinhVien();
		}

		System.out.println("Danh sach thong tin sinh vien da them: ");
		for (SinhVien i : sinhVien) {
			i.display();
		}

	}

}
