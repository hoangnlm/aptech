package java2.asm03.data;

import java2.asm03.utilPkg.ValUtils;

public class Student extends ValUtils {
	private static int count;
	private int id;
	private String name, address, gender, email, phone, className;

	public Student(String name, String gender, String address, String email, String phone,
	String className) throws Exception {
		setName(name);
		setGender(gender);
		setAddress(address);
		setEmail(email);
		setPhone(phone);
		setClassName(className);
		setId();
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = ++count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		valEmpty(name, "Name cannot be empty!");
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) throws Exception {
		valEmpty(gender, "Gender cannot be empty!");
		valSelectedValues(gender, new String[] { "male", "female" },
		"Gender must be male/female!");
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) throws Exception {
		valEmpty(address, "Address cannot be empty!");
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		valEmpty(email, "Email cannot be empty!");
		valEmail(email);
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws Exception {
		valEmpty(phone, "Phone cannot be empty");
		this.phone = phone;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		StringBuilder kq = new StringBuilder(200);
		kq.append("\nStudent ID: " + getId());
		kq.append("\nStudent name: " + getName());
		kq.append("\nStudent address: " + getAddress());
		kq.append("\nStudent gender: " + getGender());
		kq.append("\nStudent email: " + getEmail());
		kq.append("\nStudent phone: " + getPhone());
		kq.append("\nStudent class name: " + getClassName());
		return kq.toString();
	}
}
