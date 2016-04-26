package java1;

import java.util.Scanner;

// Giai phuong trinh bac hai
class BacHai {
	private int a, b, c;
	private Scanner s = new Scanner(System.in);

	BacHai() {
		System.out.println("Chuong trinh giai phuong trinh bac hai:");
		System.out.println("--------------------");
		System.out.println("Nhap vao bien a: ");
		this.a = s.nextInt();
		System.out.println("Nhap vao bien b: ");
		this.b = s.nextInt();
		System.out.println("Nhap vao bien c: ");
		this.c = s.nextInt();
		giai(this.a, this.b, this.c);
	}

	private void giai(int a, int b, int c) {
		if (a == 0) {
			if (b == 0 && c == 0) {
				System.out.println("Phuong trinh vo so nghiem.");
			}
			if (b == 0 && c != 0) {
				System.out.println("Phuong trinh vo nghiem.");
			}
			if (b != 0) {
				System.out.printf("Phuong trinh co nghiem: %.2f.", (double) -c / b);
			}
		} else {
			double delta = b * b - 4 * a * c;
			if (delta == 0) {
				System.out.printf("Phuong trinh co nghiem kep: %.2f%n", (double) -b / (2 * a));
			} else if (delta > 0) {
				System.out.println("Phuong trinh co 2 nghiem: ");
				System.out.printf("x1: %.2f%n", (-b + Math.sqrt(delta)) / (2 * a));
				System.out.printf("x1: %.2f%n", (-b - Math.sqrt(delta)) / (2 * a));
			} else {
				System.out.println("Phuong trinh vo nghiem.");
			}
		}
	}
}

// Tinh luong tong cong cua nhan vien dua vao 7 input: tenNV, thang, loaiNV,
// soHang, soNgay, ca, loaiThuong.
class NhanVien {
	private String tenNv;
	private int thang, soHang, soNgay;
	private int loaiNv, ca, loaiThuong;
	private Scanner s = new Scanner(System.in);

	// Khai bao constant
	private final double LUONGFULLTIME = 50, LUONGPARTTIME = 30;
	private final double PCFULLTIME = 75, PCPARTTIME = 65;
	private final double CANGAY = 1, CADEM = 1.1;

	NhanVien() {
		System.out.println("Chuong trinh tinh luong thang cua nhan vien:");
		System.out.println("-----------------------------------");
		System.out.println("Nhap vao ten nhan vien: ");
		tenNv = s.nextLine();
		System.out.println("Nhap vao thang can tinh: ");
		thang = s.nextInt();
		while (!(1 <= thang && thang <= 12)) {
			System.out.println("Nhap thang sai roi. Nhap lai: ");
			thang = s.nextInt();
		}
		System.out.println("Nhap vao loai nhan vien (1: fulltime, 2: parttime):");
		loaiNv = s.nextInt();
		while (!(loaiNv == 1 || loaiNv == 2)) {
			System.out.println("Chi nhap so 1 hoac so 2. Nhap lai: ");
			loaiNv = s.nextInt();
		}
		System.out.println("Nhap vao so goi hang da gui: ");
		soHang = s.nextInt();
		while (!(0 < soHang && soHang <= 1000)) {
			System.out.println("So hang lon hon 0 va nho hon 1000. Nhap lai: ");
			soHang = s.nextInt();
		}
		System.out.println("Nhap vao so ngay lam viec: ");
		soNgay = s.nextInt();
		while (!(0 < soNgay && soNgay <= 31)) {
			System.out.println("So ngay lon hon 0 va nho hon 31. Nhap lai: ");
			soNgay = s.nextInt();
		}
		System.out.println("Nhap vao ca lam viec (1: ca  ngay, 2: ca dem):");
		ca = s.nextInt();
		while (!(ca == 1 || ca == 2)) {
			System.out.println("Chi nhap so 1 hoac so 2. Nhap lai: ");
			ca = s.nextInt();
		}
		System.out.println("Nhap vao xep loai thuong (1: A1, 2: A2, 3: A3):");
		loaiThuong = s.nextInt();
		while (!(loaiThuong == 1 || loaiThuong == 2 || loaiThuong == 3)) {
			System.out.println("Chi nhap so 1 hoac so 2 hoac so 3. Nhap lai: ");
			loaiThuong = s.nextInt();
		}
		System.out.println("-----------------------------------");
		System.out.printf("Luong thuc lanh cua nhan vien \"" + tenNv + "\" trong thang " + thang + " la: %.2f.",
				xuatLuongTong(loaiNv, ca, soHang, soNgay, loaiThuong));
	}

	private double xuatLuongCoBan(int loaiNv, int ca, int soHang, int soNgay) {
		double luongTheoHang = loaiNv == 1 ? LUONGFULLTIME : LUONGPARTTIME;
		double luongTheoNgay = loaiNv == 1 ? PCFULLTIME : PCPARTTIME;
		double heSoCa = ca == 1 ? CANGAY : CADEM;
		return heSoCa * (soHang * luongTheoHang + soNgay * luongTheoNgay);
	}

	private double xuatThuong(int loaiNv, int ca, int soHang, int soNgay, int loaiThuong) {
		double luongCoBan = xuatLuongCoBan(loaiNv, ca, soHang, soNgay);
		double mucThuong;
		switch (loaiThuong) {
		case 1: // A1
			mucThuong = 0.05;
			break;
		case 2: // A2
			mucThuong = 0.1;
			break;
		case 3: // A3
			mucThuong = 0.15;
			break;
		default:
			mucThuong = 0;
		}
		return mucThuong * luongCoBan;
	}

	private double xuatLuongTong(int loaiNv, int ca, int soHang, int soNgay, int loaiThuong) {
		double luongCoBan = xuatLuongCoBan(loaiNv, ca, soHang, soNgay);
		double thuong = xuatThuong(loaiNv, ca, soHang, soNgay, loaiThuong);
		return luongCoBan + thuong;
	}
}

public class ngay1203 {

	public static void main(String[] args) {
		// BacHai pt = new BacHai();
		// NhanVien nhanvien = new NhanVien();
	}
}
