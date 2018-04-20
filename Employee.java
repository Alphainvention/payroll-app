
public class Employee {

	private String firstName;
	private String lastName;
	private double payRate;
	private int id;
	
	Employee(int id) {	
		this(id, null, null);
	}
	
	Employee(int id , String firstName, String lastName) {
		this(id, firstName, lastName, 0.0);
	}
	
	Employee(int id , String firstName, String lastName, double payRate) {
		 this.id = id;
		 
		 setFirstName(firstName);
		 setLastName(lastName);
		 setPayRate(payRate);
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double getPayRate() {
		return payRate;
	}
	
	public void setPayRate(double payRate) {	
		this.payRate = payRate;	
	}

	public void setFirstName(String firstName) {
		// TODO: Check to make sure valid name.
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		// TODO: Check to make sure valid name.
		this.lastName = lastName;
	}
	
	public double payment(double hours ) {
		return hours * payRate;
	}
	
	@Override
	public boolean equals(Object o) {
		Employee other;
		
		if(o == null) {
			return false;
		}
		
		if(o.getClass() != Employee.class) {
			return false;
		}
		
		other = (Employee) o;
		if(other.getId() == this.getId())
			return true;
		return false;
	}
}