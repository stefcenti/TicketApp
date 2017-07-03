import java.util.ArrayList;
import java.util.Scanner;
// This class will be used to display a ticket menu
// with options for purchasing tickets
public class TicketingApp {
	
	// Class variables
	private static Scanner in = new Scanner(System.in);
	private static boolean debug = true;
		
	public TicketingApp() {
		// Constructor
		Ticket.addToInventory(10, 2.00);
	}
	
	// Object get/set methods
	public boolean getDebug() {
		return debug;
	}
	
	public void setDebug(boolean debug) {
		TicketingApp.debug = debug;
	}
	
	public static void main(String[] args) {
		// Instantiate an instance of the Ticketing App
		TicketingApp app = new TicketingApp();
		
		int opt = 0;
		do {
			opt = app.menu();
			
			switch (opt) {
			case 0:
				break;
			case 1:
				app.addEmployee();
				break;
			case 2:
				app.addStudent();
				break;
			case 3:
				app.purchaseTickets();
				break;
			case 4:
				Ticket.printStatus();
				break;
			default:
				app.error("Invalid Option");
			}
			
		} while (opt != 0);
		
		System.out.println("*** Ticketing System Closed ***");
		in.close();
	}
	
	private int menu() {
		// Display a menu of choices to the user
		// Return the selection the user made
		// 1: Purchase Tickets
		// 2: Quit
		System.out.println("   Ticketing Menu ");
		System.out.println("--------------------");
		System.out.println("1: Add Employee");
		System.out.println("2: Add Student");
		System.out.println("3: Purchase Tickets");
		System.out.println("4: Print Status");
		System.out.println("--------------------");
		System.out.println("0: Quit");
		System.out.println("--------------------");
		System.out.println("Enter Choice (1-3, 0 to quit): ");

		int opt = in.nextInt();
		
		System.out.println("option entered: " + opt);

		// return the choice selected
		return opt;
	}

	private void error(String err) {
		System.out.println("ERROR: " + err);
	}

	private void addStudent() {
		if (debug) System.out.println("[DEBUG] Calling... Ticketing addStudent()");

		// For now, just get input needed.  Error check later
		System.out.println("Enter Student Name: ");
		String name = in.next();
		
		System.out.println("Enter Student Id: ");
		String id = in.next();
		
		System.out.println("Enter Number of Tickets (max 2): ");
		int count = in.nextInt();
		
		if (debug) System.out.println("[DEBUG] Creating Student (Name, Id, Count): " + 
									  name + ", " + id + ", " + count);
	}

	private void addEmployee() {
		if (debug) System.out.println("[DEBUG] Calling... TicketingApp.addEmployee()");
	}
	
	// Prompt the user for customer and ticket info
	private int purchaseTickets() {
		if (debug) System.out.println("[DEBUG] Calling... TicketingApp.purchaseTickets()");

		// Create a new Customer
		// public Customer(String custId, String firstName, String lastName) {
		// For now, just get input needed.  Error check later
		System.out.println("Enter Employee Id: ");
		String id = in.next();
		
		System.out.println("Enter First Name: ");
		String firstName = in.next();
		
		System.out.println("Enter Last Name: ");
		String lastName = in.next();
		
		System.out.println("Enter Number of Tickets (max 5): ");
		int count = in.nextInt();
		
		if (debug) System.out.println("[DEBUG] Creating Employee (Name, Id, Count): " + 
									  firstName + " " + lastName + ", " + id + ", " + count);
		Customer cust = new Customer(id, firstName, lastName);
		
		ArrayList<Ticket> tickets = Ticket.purchase(count);

		if (tickets.size() > 0) {
			System.out.println("You purchased " + tickets.size() + " tickets.");
		}
		
		cust.takeTickets(tickets);
		cust.print();
		
		return 1;
	}
}
