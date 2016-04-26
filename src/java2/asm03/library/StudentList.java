package java2.asm03.library;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java2.asm03.data.Student;

public class StudentList {
	private TreeMap<Integer, Student> students = new TreeMap<>();
	private static int count;

	public void addStudent(Student student) {
		students.put(count++, student);
	}

	public Student[] getStudents() {
		LinkedList<Student> kq = new LinkedList<>();

		for (Entry<Integer, Student> s : students.entrySet()) {
			kq.add(s.getValue());
		}

		return kq.toArray(new Student[kq.size()]);
	}

	public Student searchById(int id) {
		Student kq = null;
		
		for (Entry<Integer, Student> s : students.entrySet()) {
			if (s.getValue().getId() == id) {
				kq = s.getValue();
			}
		}
		
		return kq;
	}
}
