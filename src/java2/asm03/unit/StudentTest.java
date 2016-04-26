package java2.asm03.unit;

import java2.asm03.data.Student;
import java2.asm03.library.StudentList;
import java2.asm03.utilPkg.ConsoleUtils;

public class StudentTest extends ConsoleUtils {

	public static void main(String[] args) {
		StudentTest studentTest = new StudentTest();
		studentTest.run(0);
	}

	private String name, gender, address, email, phone, className;
	private StudentList studentList;
	private Student student;

	public StudentTest() {
		studentList = new StudentList();
	}

	private void run(int item) {
		switch (item) {
		case 0:
			break;
		case 1:
			addStudent();
			break;
		case 2:
			displayStudentList();
			break;
		case 3:
			searchById();
			break;
		default:
			exit();
			return;
		}

		run(printMenu("STUDENT PROGRAM", "Add a new student.", "Display student list.",
		"Search student by ID.", "Exit."));
	}

	private void addStudent() {
		do {
			try {
				println("\nINPUT STUDENT INFORMATION:");
				name = read("Name: ");
				gender = read("Gender: ");
				address = read("Address: ");
				email = read("Email: ");
				phone = read("Phone: ");
				className = read("Class name: ");
				student = new Student(name, gender, address, email, phone, className);
				studentList.addStudent(student);
				println("\nAdding student succeeded...");
			} catch (Exception e) {
				printt(e.getMessage());
			}

			print("Add again? <y/n> ");
		} while (sc.nextLine().trim().toLowerCase().matches("y"));
	}

	private void displayStudentList() {
		if (studentList.getStudents().length == 0) {
			println("No student in the list!");
		} else {
			for (Student s : studentList.getStudents()) {
				println(s.toString() + "\n");
			}
		}
	}

	private void searchById() {
		if (studentList.getStudents().length == 0) {
			println("No student in the list!");
		} else {
			do {
				try {
					Student student = studentList
					.searchById(Integer.parseInt(read("Input student ID to search: ")));
					println(student == null ? "Student not found!" : student.toString());
				} catch (Exception e) {
					printt(e.getMessage());
				}

				print("\nSearch again? <y/n> ");
			} while (sc.nextLine().trim().toLowerCase().matches("y"));
		}
	}
}
