import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		new Thread(()-> {
//			System.out.println("printing from a runnable");
//			System.out.println("test line 2");
//		}).start();
//		
		Employee joe = new Employee("Joe Doe", 21);
		Employee lisa = new Employee("Lisa B", 32);
		Employee peter = new Employee("Peter Vin", 40);
		Employee berol = new Employee("Berol P", 60);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(joe);
		employees.add(lisa);
		employees.add(berol);
		employees.add(peter);

//		Collections.sort(employees, new Comparator<Employee>() {
//			@Override
//			public int compare(Employee employee1, Employee employee2) {
//				return employee1.getName().compareTo(employee2.getName());	
//			}
//	});
		
		// Lambda expression, don't need to include type as assumes type of employee 
		Collections.sort(employees, (employee1, employee2) ->
				employee1.getName().compareTo(employee2.getName()));
		
		for(Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}
}

class Employee{
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}

