package Q2Emp;

public class Employee{
	 int EmpId;
	String name;
	 String Department;
	 double salary;
	
	public Employee(int empId, String name, String department, double salary) {
		super();
		EmpId = empId;
		this.name = name;
		Department = department;
		this.salary = salary;
	}
	
	public int getEmpId() {
		return EmpId;
	}


	public String getName() {
		return name;
	}

	public String getDepartment() {
		return Department;
	}


	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", name=" + name + ", Department=" + Department + ", salary=" + salary
				+ "]";
	}
	
	
	
}
