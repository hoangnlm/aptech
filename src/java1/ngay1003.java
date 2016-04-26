package java1;

import java.util.Scanner;

class B {
	Scanner s = new Scanner(System.in);
}

// Bài tập thực hành số 1: Viết chương trình nhập 2 số nguyên x, y từ bàn phím,
// sau đó xuất ra màn hình kết quả cộng hai số (x+y), hiệu hai số (x-y), tích
// hai số (x*y), thương của hai số (x/y), phần nguyên của x/y và lũy thừa xy
class B1 extends B {
	private int x, y;

	B1() {
		System.out.println("Nhap so x:");
		x = s.nextInt();
		System.out.println("Nhap so y:");
		y = s.nextInt();
	}

	void tinhTong() {
		System.out.println("Tong x+y: " + (x + y));
	}

	void tinhHieu() {
		System.out.println("Hieu x-y: " + (x - y));
	}

	void tinhTich() {
		System.out.println("Tich x*y: " + (x * y));
	}

	void tinhThuong() {
		System.out.printf("Thuong x/y: %.3f%n", (double) x / y);
	}

	void tinhPhanNguyen() {
		System.out.println("Phan nguyen cua x/y: " + x / y);
	}

	void tinhLuyThua() {
		System.out.println("Luy thua cua x^y: " + (long) Math.pow(x, y));
	}
}

// Bài tập thực hành số 2: Viết chương trình nhập vào độ C (Celsius) và chuyển
// sang độ F (Fahrenheit). Biết rằng C/5 = (F-32)/9.
class B2 extends B {
	private double c;

	B2() {
		System.out.println("Nhap vao do Celsius: ");
		c = s.nextDouble();
	}

	void tinhDoF() {
		System.out.printf("Do Fahrenheit cua no la: %.2f%n.", (9 / 5 * c + 32));
	}
}

// Bài tập thực hành số 3: Viết chương trình nhập vào điểm toán, điểm lý và điểm
// hoá. Tính tổng điểm và điểm trung bình rồi hiển thị kết quả.
class B3 extends B {
	private double diemToan, diemLy, diemHoa;

	B3() {
		System.out.println("Nhap vao diem Toan: ");
		diemToan = s.nextDouble();
		System.out.println("Nhap vao diem Ly: ");
		diemLy = s.nextDouble();
		System.out.println("Nhap vao diem Hoa: ");
		diemHoa = s.nextDouble();
	}

	void tinhDiemTb() {
		System.out.printf("Diem trung binh 3 mon: %.2f%n", (diemToan + diemLy + diemHoa) / 3);
	}
}

// Bài tập thực hành số 4: Viết chương trình tính chu vi và diện tích hình chữ
// nhật.
class B4 extends B {
	private double dai, rong;

	B4() {
		System.out.println("Nhap vao chieu dai hcn: ");
		dai = s.nextDouble();
		System.out.println("Nhap vao chieu rong hcn: ");
		rong = s.nextDouble();
	}

	void tinhChuVi() {
		System.out.printf("Chu vi hcn: %.2f%n", (dai + rong) * 2);
	}

	void tinhDienTich() {
		System.out.printf("Dien tich hcn: %.2f%n", dai * rong);
	}
}

// Bài tập thực hành số 5: Viết chương trình nhập số nguyên có 3 chữ số, sau đó
// in ra màn hình chữ số hàng đơn vị, hàng chục, hàng trăm.
class B5 extends B {
	private int so;

	B5() {
		System.out.println("Nhap vao so nguyen co 3 chu so: ");
		so = s.nextInt();
	}

	void xuatChuSo() {
		int n1 = so % 10;
		int n2 = (so / 10) % 10;
		int n3 = so / 100;
		System.out.println("So don vi: " + n1);
		System.out.println("So hang chuc: " + n2);
		System.out.println("So hang tram: " + n3);
	}
}

public class ngay1003 {
	public static void main(String[] args) {
		// B1 b1 = new B1();
		// b1.tinhTong();
		// b1.tinhHieu();
		// b1.tinhTich();
		// b1.tinhThuong();
		// b1.tinhPhanNguyen();
		// b1.tinhLuyThua();

		// B2 b2 = new B2();
		// B3 b3 = new B3();
		// B4 b4 = new B4();
		// B5 b5 = new B5();

		// B3 b3 = new B3();
		// b3.tinhDiemTb();

//		B4 b4 = new B4();
//		b4.tinhChuVi();
//		b4.tinhDienTich();

		// ngay1003 tmp = new ngay1003();
		// B5 b5 = tmp.new B5();
		// b5.xuatChuSo();
			
	
	}
}
