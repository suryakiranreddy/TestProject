package Common;

public class Employee {

	public  Employee() {
		System.out.println("employee constructor");		
	}
	public  Employee(String eid, String ename) {
		System.out.println("parameter constructor");	
		/*System.out.println(eid);
		System.out.println(ename);*/
	}
	public void Employee() {
		System.out.println("employee method");		
	}
	public static void main(String[] args) {
		Employee employee = new Employee();
		Employee employeee = new Employee("1","surya");
		employee.Employee();

	}

}
