package java2.asm04.mainPkg;

import java2.asm04.utilPkg.ConsoleUtils;

public class DoctorTest extends ConsoleUtils {

	public static void main(String[] args) {
		DoctorTest doctorTest = new DoctorTest();
		doctorTest.run(0);
	}

	private DoctorDetails doctorDetails;

	public DoctorTest() {
		doctorDetails = new DoctorDetails();
	}

	private void run(int item) {
		switch (item) {
		case 0:
			break;
		case 1:
			addDoctor();
			break;
		case 2:
			searchDoctor();
			break;
		case 3:
			displayDoctors();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("DOCTOR PROGRAM", "Add a new doctor.", "Search doctors by code.",
		"Display doctor list.", "Exit."));
	}

	private void exit() {
		printt("Goodbye....");
	}

	private void addDoctor() {
		do {
			try {
				println("\nINPUT DOCTOR INFORMATION:");
				Doctor doctor = new Doctor(read("Doctor code: "), read("Doctor name: "),
				read("Doctor spec: "), Integer.parseInt(read("Doctor hours: ")));
				doctorDetails.getDoctorHashMap().put(doctor.getCode(), doctor);
				println("\nAdding doctor succeeded...");
			} catch (Exception e) {
				printt(e.getMessage());
			}

			print("Add again? <y/n> ");
		} while (sc.nextLine().trim().toLowerCase().matches("y"));
	}

	private void searchDoctor() {
		if (doctorDetails.getDoctorHashMap().size() == 0) {
			printt("Doctor list empty!");
		} else {
			do {
				Doctor kq = null;

				try {
					kq = doctorDetails.searchDoctor(read("Input doctor code to search: "));
					println("\n" + kq);

				} catch (Exception e) {
					if (kq == null) {
						printt("Doctor not found!");
					} else {
						printt(e.getMessage());
					}
				}

				print("Add again? <y/n> ");
			} while (sc.nextLine().trim().toLowerCase().matches("y"));
		}
	}

	private void displayDoctors() {
		if (doctorDetails.getDoctorHashMap().size() == 0) {
			printt("Doctor list empty!");
		} else {
			println("DOCTOR LIST\n");

			for (Doctor d : doctorDetails.getDoctorHashMap().values())
				println(d+"");
		}
	}
}
