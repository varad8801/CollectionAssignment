package Q2Emp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class EmployeeManagement {
	
	LinkedList<Employee> empList;
	HashMap<String,LinkedList<Employee>> empmap;
	public EmployeeManagement() {
	
		this.empList=new LinkedList<Employee>();
		this.empmap=new HashMap<String, LinkedList<Employee>>();
	}
	
	void addEmp(int empId, String name, String department, double salary) {
		empList.add(new Employee(empId, name, department, salary));
		
		if(!empmap.containsKey(department)) {
			empmap.put(department,new LinkedList<>());
			
		}
		empmap.put(department, empList);
	}
	void removeEmp(int id1) {
		Employee emp=empList.get(id1);
		if(emp!=null) {
		empList.remove(emp);
		empmap.get(emp.Department).remove(emp);
		}
		
	}
	void total_sal(String dep) {
		
		double TotalSal=0;
			for(Employee employee:empList) {
			
			if (dep.equalsIgnoreCase(employee.getDepartment())) {
				TotalSal+=employee.getSalary();
				
			}
		}
		System.out.println("Total salary of  "+dep+"  is "+TotalSal);

	}
	public void findHighestSalaryInEachDepartment() {
        HashMap<String, Employee> highestSalaries = new HashMap<>();

        for (LinkedList<Employee> employeesInDepartment : empmap.values()) {
            Employee highestSalaryEmployee = null;
            for (Employee employee : employeesInDepartment) {
                if (highestSalaryEmployee == null || employee.salary > highestSalaryEmployee.salary) {
                    highestSalaryEmployee = employee;
                }
            }
            if (highestSalaryEmployee != null) {
                highestSalaries.put(highestSalaryEmployee.Department, highestSalaryEmployee);
            }
        }
        System.out.println("Highest salary employees:");
        for (Employee employee : highestSalaries.values()) {
            System.out.println(employee.getName() + " - " + employee.getSalary());
        }
        
    }
	
	/////////////////////////
	
	

	    public static void main(String[] args) {
	        EmployeeManagement manager = new EmployeeManagement();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Remove Employee");
	            System.out.println("3. Calculate Total Salary in Department");
	            System.out.println("4. Find Highest Salary in Each Department");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline character
	                    System.out.print("Enter Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Department: ");
	                    String department = scanner.nextLine();
	                    System.out.print("Enter Salary: ");
	                    double salary = scanner.nextDouble();
	                    manager.addEmp(id, name, department, salary);
	                    break;

	                case 2:
	                    System.out.print("Enter ID to remove: ");
	                    int removeId = scanner.nextInt();
	                    manager.removeEmp(removeId);
	                    break;

	                case 3:
	                    System.out.print("Enter Department: ");
	                    String dept = scanner.nextLine();
	                    manager.total_sal(dept);
	                    break;

	                case 4:
	                    manager.findHighestSalaryInEachDepartment();
	                    break;

	                case 5:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }
	

}
