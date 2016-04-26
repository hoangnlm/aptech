package java2.asm09;

public class Employee {
	private int id;
	private String name, department, designation;
	private double basicSalary;
	
	public Employee(String name, String department, String designation, double basicSalary) {
		setName(name);
		setDepartment(department);
		setDesignation(designation);
		setBasicSalary(basicSalary);
	}

	public Employee(int id, String name, String department, String designation,
	double basicSalary) {
		setId(id);
		setName(name);
		setDepartment(department);
		setDesignation(designation);
		setBasicSalary(basicSalary);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
}
