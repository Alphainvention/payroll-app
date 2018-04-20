
import java.util.Scanner;

public class CUIController {
	private Scanner keyboard;
	private PayrollSession session;
	
	CUIController(PayrollSession session){
		keyboard = new Scanner(System.in);
		this.session = session;
	}
	
	public void main() {
		boolean run = true;
		
		while(run) {
			String line = prompt();
			
			switch(line) {
			case "add": // add employee
				String firstName = prompt("Enter first name");	
				String lastName = prompt("Enter last name");
				double payRate = promptDouble("Enter hourly pay rate");
				session.addEmployee(firstName, lastName, payRate);
				break;
			case "remove": // remove employee
				int id = promptInt("Enter employee ID");
				session.removeEmployee(new Employee(id));
				break;
			case "payroll": // payroll
				break;
			case "list":
				for(Employee e : session.list()) {
					System.out.printf("%04d: %-16s, %-16s    $%.2f\n", e.getId(), e.getLastName(), e.getFirstName(), e.getPayRate());
				}
				break;
			case "help":
				displayMainMenu();
				break;
			case "quit":
				quit();
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
	
	private void quit() {
		// TODO: When PayrollSession implements persistent data, make sure to 'session' records data before exiting.
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	private String prompt() {
		return prompt("");
	}
	
	private String prompt(String s) {
		System.out.print(s + ":: ");
		return keyboard.nextLine();
	}
	
	private int promptInt() {
		return promptInt("");
	}
	
	private int promptInt(String s) {
		String line;
		int choice = -1;
		boolean isInvalid = true;
		
		while(isInvalid) {
			try {
				line = prompt(s);
				choice = Integer.parseInt(line);
				isInvalid = false;
			}
			catch(NumberFormatException err) {
				System.out.println("Invalid input: You must enter an integer.");
			}
		}
		
		return choice;
	}
	
	private double promptDouble() {
		return promptDouble("");
	}
	
	private double promptDouble(String s) {
		String line;
		double choice = -1;
		boolean isInvalid = true;
		
		while(isInvalid) {
			try {
				line = prompt(s);
				choice = Double.parseDouble(line);
				isInvalid = false;
			}
			catch(NumberFormatException err) {
				System.out.println("Invalid input: You must enter a number.");
			}
		}
		
		return choice;
	}
	
	private void displayMainMenu() {
		System.out.println("MENU");
	}
}
