
public class MyPayroll {

	public static void main(String[] args) {
		PayrollSession session = new PayrollSession();
		CUIController cui = new CUIController(session);
		
		cui.main();
	}

	public static void displayEmployee(Employee e) {
		String firstName = e.getFirstName();
		String lastName = e.getLastName();
		double payRate = e.getPayRate();
		
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Rate: " + payRate);
		System.out.println();
	}
}
