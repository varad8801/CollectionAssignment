package Q2Emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmployeeManagement {
	
	LinkedList<Employee> empList;

	public EmployeeManagement() {
	
		this.empList=new LinkedList<Employee>();
	
	}
	
	void addEmp(int empId, String name, String department, double salary) {
		empList.add(new Employee(empId, name, department, salary));
		
		
	}
	void removeEmp(int id1) {
		Employee emp=empList.get(id1);
		if(emp!=null) {
		empList.remove(emp);
		}
		else {
			System.out.println("Does not exist");
		}
	}
	void total_sal(String dep) {
		
		double TotalSal=0;
		Iterator<Employee> iterator2=empList.iterator();
		while (iterator2.hasNext()) {
			Employee employee = (Employee) iterator2.next();
			
			if (dep.equalsIgnoreCase(employee.getDepartment())) {
				TotalSal+=employee.getSalary();
				
			}
		}
		System.out.println("Total salary of  "+dep+"  is "+TotalSal);

	}
	void highest_sal(String dep) {
		double LowestSal=0;
		String Name="";
		Iterator<Employee> iterator3=empList.iterator();
		while (iterator3.hasNext()) {
			Employee employee = (Employee) iterator3.next();
			if (dep.equalsIgnoreCase(employee.getDepartment())) {
				
				if (LowestSal<employee.getSalary()) {
					LowestSal=employee.getSalary();
					Name=employee.getName();
				}
			}
			
		}
		System.out.println("Highest salary of  "+dep+"  is "+Name+" Salary is"+LowestSal);
	}
}
