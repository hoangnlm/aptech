package mainPkg;

public class Player {
	private static int id_count;
	private String id, name;
	private boolean gender;
	private int age, testMatch, worldCup;
	
	public Player() {
		setId();
		setName("unknown");
		setGender(true);
		setAge(16);
		setTestMatch(0);
		setWorldCup(0);		
	}

	public Player(String name, boolean gender, int age, int testMatch, int worldCup) {
		setId();
		setName(name);
		setGender(gender);
		setAge(age);
		setTestMatch(testMatch);
		setWorldCup(worldCup);
	}
	
	public void displayDetails() {
		System.out.println("PLAYER INFO:");
		System.out.println("-- ID:\t\t\t\t"+getId());
		System.out.println("-- Name:\t\t\t\t"+getName());
		System.out.println("-- Gender:\t\t\t"+(getGender()?"Nam": "Nu"));
		System.out.println("-- Age:\t\t\t\t"+getAge());
		System.out.println("-- Test match number:\t"+getTestMatch());
		System.out.println("-- Test match income:\t"+String.format("$%,.2f", new TestMatch().calculateIncome(getTestMatch())));
		System.out.println("-- Test match bonus:\t"+String.format("$%,.2f", new TestMatch().calculateBonus("good", "b")));
		System.out.println("-- Worldcup number:\t"+getWorldCup());
		System.out.println("-- Worldcup income:\t"+String.format("$%,.2f", new WorldCup().calculateIncome(getWorldCup())));
		System.out.println("-- Worldcup bonus:\t\t"+String.format("$%,.2f", new WorldCup().calculateBonus("good", "b")));
		System.out.println("-- Total number:\t\t"+(getTestMatch()+getWorldCup()));
		System.out.println("-- Total income:\t\t"+String.format("$%,.2f", new TestMatch().calculateIncome(getTestMatch())+new WorldCup().calculateIncome(getWorldCup())));
		System.out.println("-- Total bonus:\t\t\t"+String.format("$%,.2f", new TestMatch().calculateBonus("good", "b")+new WorldCup().calculateBonus("good", "b")));
	}

	public String getId() {
		return id;
	}

	public void setId() {
		if (id_count <= 999) {
			id = String.format("PA%03d", ++id_count);
		} else {
			System.out.println("Maximum 999 players!");
			System.exit(0);
		}
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		boolean kq = true;
		name = name.trim();

		if (name.matches("[\\dA-z ]{3,12}")) {
			this.name = name;
		} else {
			System.out.println("CD name contains 3-12 normal characters!");
			kq = false;
		}

		return kq;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public boolean setAge(int age) {
		boolean kq = true;

		if (16 <= age && age <= 40) {
			this.age = age;
		} else {
			System.out.println("Age between [16,40]!");
			kq = false;
		}

		return kq;
	}

	public int getTestMatch() {
		return testMatch;
	}

	public boolean setTestMatch(int testMatch) {
		boolean kq = true;

		if (0 <= testMatch && testMatch <= 100) {
			this.testMatch = testMatch;
		} else {
			System.out.println("Number of matches between [0,100]!");
			kq = false;
		}

		return kq;
	}

	public int getWorldCup() {
		return worldCup;
	}

	public boolean setWorldCup(int worldCup) {
		boolean kq = true;

		if (0 <= worldCup && worldCup <= 100) {
			this.worldCup = worldCup;
		} else {
			System.out.println("Number of matches between [0,100]!");
			kq = false;
		}

		return kq;
	}
}
