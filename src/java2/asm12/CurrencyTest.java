package mainPkg;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class CurrencyTest extends ConsoleUtils {

	public static void main(String[] args) {
		CurrencyTest currencyTest = new CurrencyTest();
		currencyTest.run();
	}

	private ResourceBundle res;

	public CurrencyTest() {
		Locale.setDefault(new Locale("vi", "VN"));
		setRes();
	}

	public void run() {
		run(0);
	}

	private void run(int item) {
		switch (item) {
		case 0:
			initialize();
			break;
		case 1:
			tiengViet();
			break;
		case 2:
			tiengPhap();
			break;
		case 3:
			nhapTien();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("", res.getString("menu1"), res.getString("menu2"),
		res.getString("menu3"), res.getString("menu4")));
	}

	private void initialize() {

	}

	private void exit() {

	}

	private void tiengViet() {
		Locale.setDefault(new Locale("vi", "VN"));
		setRes();
	}

	private void tiengPhap() {
//		Locale.setDefault(new Locale("fr", "FR"));
		Locale.setDefault(Locale.FRANCE);
		setRes();
	}

	private void nhapTien() {
		double input = 0;

		try {
			input = Double.parseDouble(read(res.getString("input") + " "));
		} catch (NumberFormatException e) {
			printt(res.getString("error"));
		}

		printt(
		res.getString("currency") + ": " + NumberFormat.getCurrencyInstance().format(input));
	}

	public void setRes() {
		res = ResourceBundle.getBundle("mainPkg.MyMessages");
	}
}
