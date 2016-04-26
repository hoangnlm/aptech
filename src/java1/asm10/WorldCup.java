package mainPkg;

public class WorldCup extends Game {
	private static final double PRICE = 23.79;

	@Override
	public double calculateIncome(int numGames) {
		return numGames * PRICE;
	}

	@Override
	public double calculateBonus(String performance, String grade) {
		double kq = 0;

		switch (performance) {
		case "best":
			kq += 4000;
		case "good":
			kq += 2000;
			break;
		case "average":
			kq += 1000;
			break;
		default:
			kq += 0;
		}

		switch (grade) {
		case "a":
			kq += 1000;
			break;
		case "b":
			kq += 400;
			break;
		case "c":
			kq += 200;
			break;
		default:
			kq += 0;
		}

		return kq;
	}
}
