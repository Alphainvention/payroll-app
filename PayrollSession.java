
import java.util.Scanner;
import java.util.ArrayList;

public class PayrollSession {
	private ArrayList<Employee> employeeList;
	private ArrayList<Double> timeTable;
	private int nextId;
	
	PayrollSession(){
		employeeList = new ArrayList<Employee>();
		timeTable = new ArrayList<Double>();
		nextId = 0;
	}
	
	public void addEmployee(Employee x) {
		// TODO: Check for repeating employees
		if(x.getId() >= nextId) {
			nextId = x.getId() + 1; 
		}
		employeeList.add(x);
		timeTable.add(0.0);
	}
	
	public void addEmployee(String firstName, String lastName, double payRate) {
		Employee x = new Employee(nextId, firstName, lastName, payRate);
		addEmployee(x);
	}
	
	public void removeEmployee(Employee x) {		
		for(int i = 0; i < employeeList.size(); i++) {
			if(x.equals(employeeList.get(i))) {
				employeeList.remove(i);
				timeTable.remove(i);
				return;
			}
		}
	}
	
	public void setHours(Employee x, double hours) {
		int index = findIndex(x);
		
		if(index == -1)
			return;
		
		timeTable.add(index, hours);
	}
	
	public void appendHours(Employee x, double hours) {
		double oldHours;
		int index = findIndex(x);
		
		if(index == -1)
			return;
		
		oldHours = timeTable.get(index);
		timeTable.add(index, oldHours + hours);
	}
	
	public void displayEmployees() {
		String sep = "";
		
		for(int i = 0; i < employeeList.size(); i++) {
			Employee e = employeeList.get(i);
			System.out.printf("%s%s %s: %f", sep, e.getFirstName(), e.getLastName(), e.getPayRate());
			sep = ", ";
		}
		System.out.println();
	}
	
	public Employee[] list() {
		Object[] list = employeeList.toArray();
		Employee[] eList = new Employee[list.length];
		
		for(int i = 0; i < list.length; i++) {
			eList[i] = (Employee) list[i];
		}
		
		return eList;
	}
	
	private int findIndex(Employee x) {
		for(int i = 0; i < employeeList.size(); i++)
			if(x.equals(employeeList.get(i)))
				return i;
		return -1;
	}
}
