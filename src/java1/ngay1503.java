package java1;

import java.util.ArrayList;
import java.util.Scanner;

/* Bài thực hành số 4: Viết chương trình in bảng cửu chương n (2<=n<=9). Ví dụ khi người dùng nhập n = 2 thì kết quả hiển thị như sau
2 X 2 = 4
2 X 3 = 6
2 X 4 = 8
2 X 5 = 10
2 X 6 = 12
2 X 7 = 14
2 X 8 = 16
2 X 9 = 18
 */
class Bai4 {
	private int n;
	private Scanner s = new Scanner(System.in);

	Bai4() {
		System.out.println("Chuong trinh tinh bang cuu chuong:");
		System.out.println("----------------------------");
		System.out.println("Nhap vao so n (2<=n<=9): ");

		n = s.nextInt();
		while (!(2 <= n && n <= 9)) {
			System.out.println("Nhap n khong dung. Nhap lai: ");
			n = s.nextInt();
		}
		tinh(n);
	}

	void tinh(int n) {
		for (int i = 2; i < 10; i++) {
			System.out.println(n + " x " + i + " = " + n * i);
		}
	}
}

// Bài thực hành số 5: Viết chương trình kiểm tra mật khẩu người dùng nhập vào
// có hợp lệ hay không? Biết rằng mật khẩu hợp lệ là 12345. Mỗi lần người dùng
// nhập sai, chương trình sẽ thông báo “Mật khẩu không hợp lệ” và cho phép người
// dùng nhập lại. Chương trình sẽ kết thúc nếu người dùng nhập đúng mật khẩu
// hoặc số lần nhập sai quá 3.
class Bai5 {
	private String mk;
	private Scanner s = new Scanner(System.in);

	Bai5() {
		System.out.println("Chuong trinh kiem tra mat khau nguoi dung:");
		System.out.println("----------------------------");
		mk = s.nextLine();
		int count = 0;
		while (!mk.equals("12345")) {
			count++;
			if (count == 4) {
				System.out.println("Ban da nhap sai qua 3 lan. Nuot the...");
				break;
			}
			System.out.println("Mat khau khong hop le. Nhap lai: ");
			mk = s.nextLine();
		}
		if (count != 4)
			System.out.println("Dang nhap thanh cong!");
	}
}

class Ass03 {
	private Scanner s = new Scanner(System.in);
	private int diem, diemTong, bonus, flag1, flag2, flag3, flag4;

	Ass03() {
		System.out.println("Chuong trinh test IQ:");
		System.out.println("----------------------------");
		System.out.print("Nhap vao lan thi: ");
		String lanThi = s.nextLine();
		if (!lanThi.equals("1")) {
			System.out.println("Nhap khong dung so 1 la out!");
		} else {
			chuDe(hienMenu());
		}
	}

	int hienMenu() {
		String tmp = "";
		ArrayList<String> options = new ArrayList<>(5);
		for (int i = 1; i <= 5; i++) {
			options.add(Integer.toString(i));
		}
		do {
			System.out.println("--------------");
			System.out.println("Chon chu de: ");
			System.out.println("1. Aptitude");
			System.out.println("2. English");
			System.out.println("3. Math");
			System.out.println("4. GK");
			System.out.println("5. Exit");
			System.out.print("Select number (1-5): ");
			tmp = s.nextLine();
		} while (!options.contains(tmp));
		return Integer.parseInt(tmp);
	}

	void congDiem(int opt, String traLoi, String dapAn){
		diem += traLoi.equals(dapAn) ? 10 : 0;
		while (chuDe(hienMenu())) {
			System.out.println("Chu de "+opt+" lam roi. Chon lai chu de khac!");
		}
	}
	
	boolean chuDe(int opt) {
		boolean loi = false;
		String traLoi = "";
		ArrayList<String> options = new ArrayList<>(4);
		for (int i = 1; i <= 4; i++) {
			options.add(Integer.toString(i));
		}

		System.out.println("--------------");
		switch (opt) {
		case 1:
			if (flag1 == 1) {
				loi = true;
			} else {
				flag1 = 1;
				do {
					System.out.println("Cau hoi chu de 1:");
					System.out.println("Truong nay co ten gi? (Chon 1,2,3,4)");
					System.out.println("1. FPT");
					System.out.println("2. Aptech");
					System.out.println("3. Greenwich");
					System.out.println("4. Duong sat");
					System.out.print("Chon: ");
					traLoi = s.nextLine();
				} while (!options.contains(traLoi));
				congDiem(opt, traLoi, "2");
			}
			break;
		case 2:
			if (flag2 == 1) {
				loi = true;
			} else {
				flag2 = 1;
				do {
					System.out.println("Cau hoi chu de 2:");
					System.out.println("Con meo co may chan? (Chon 1,2,3,4)");
					System.out.println("1. 1 chan");
					System.out.println("2. 2 chan");
					System.out.println("3. 3 chan");
					System.out.println("4. 4 chan");
					System.out.print("Chon: ");
					traLoi = s.nextLine();
				} while (!options.contains(traLoi));
				congDiem(opt,traLoi, "4");
			}
			break;
		case 3:
			if (flag3 == 1) {
				loi = true;
			} else {
				flag3 = 1;
				do {
					System.out.println("Cau hoi chu de 3:");
					System.out.println("Con ga co bao nhieu ky? (Chon 1,2,3,4)");
					System.out.println("1. 1kg");
					System.out.println("2. 2kg");
					System.out.println("3. 5kg");
					System.out.println("4. 45kg");
					System.out.print("Chon: ");
					traLoi = s.nextLine();
				} while (!options.contains(traLoi));
				congDiem(opt, traLoi, "4");
			}
			break;
		case 4:
			if (flag4 == 1) {
				loi = true;
			} else {
				flag4 = 1;
				do {
					System.out.println("Cau hoi chu de 4:");
					System.out.println("Thang Son co bo chua? (Chon 1,2,3,4)");
					System.out.println("1. Chua");
					System.out.println("2. Co");
					System.out.println("3. Gay");
					System.out.println("4. Homo");
					System.out.print("Chon: ");
					traLoi = s.nextLine();
				} while (!options.contains(traLoi));
				congDiem(opt, traLoi, "3");
			}
			break;
		default:
			xuatKq();
		}
		return loi;
	}
	
	void xuatKq(){
		String xepLoai = "";
		switch (diem) {
		case 20:
			bonus = 2;
			break;
		case 30:
			bonus = 5;
			break;
		case 40:
			bonus = 10;
			break;
		}
		diemTong = diem + bonus;
		if (diemTong >= 40) {
			xepLoai = "You are a genius.";
		} else if (diemTong >= 30) {
			xepLoai = "You are intelligent.";
		} else if (diemTong >= 20) {
			xepLoai = "Your IQ level is average.";
		} else {
			xepLoai = "Your IQ level is below average.";
		}
		System.out.println("Bonus points earned: " + bonus);
		System.out.println("Total score out of 50: " + diemTong);
		System.out.println("Message on IQ level: " + xepLoai);
	}
}

public class ngay1503 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Bai4 bai4 = new Bai4();
		// Bai5 bai5 = new Bai5();
		Ass03 ass03 = new Ass03();
	}

}
