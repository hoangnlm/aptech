package java1.asm10;

public class TestMatch extends Game {
	private static final double PRICE = 10.55;

	@Override
	public double calculateIncome(int numGames) {
		return numGames * PRICE;
	}

	@Override
	public double calculateBonus(String performance, String grade) {
		double kq = 0;

		switch (performance) {
		case "best":
			kq += 2000;
		case "good":
			kq += 1000;
			break;
		case "average":
			kq += 500;
			break;
		default:
			kq += 0;
		}

		switch (grade) {
		case "a":
			kq += 500;
			break;
		case "b":
			kq += 200;
			break;
		case "c":
			kq += 100;
			break;
		default:
			kq += 0;
		}

		return kq;
	}
}
