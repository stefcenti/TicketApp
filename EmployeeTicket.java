
public class EmployeeTicket extends Ticket {

	private double price = 5.0;
	
	public EmployeeTicket() {
		super(5.0);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	// Override the Ticket's purchase method to check limits and
	// calculate the cost for an Employee ticket.
//	public void purchase(int count) {
//		
//	}
// To Do: Can't override Ticket.purchase for some reason. Find out why.
}
