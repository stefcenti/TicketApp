import java.util.ArrayList;

// This is the generic customer using the ticketing app
public class Customer {
	// -- Private Class Variables and Methods
	// Generate an id for each Customer purchasing a Ticket
	// Keep track of the next id available.
	private static int nextId = 0;
	
	// This list will be used for the average customer purchasing tickets.
	// Each sub-type will use it's own list to hold tickets for it's own class.
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	// -- Public Class Variables and Methods
	public static void printAll() {
		System.out.println("Next Id: " + Customer.nextId);
		
		for (Customer cust : customers) {
			cust.print();
		}
	}
	
	// -- Private Object State Variables and Methods
	private int id;
		
	// -- Protected Object State Variables and Methods
	protected String custId;
	protected String firstName;
	protected String lastName;
	// Tickets purchased by a customer will be placed in this list
	protected ArrayList<Ticket> ticketsPurchased = new ArrayList<Ticket>();
	
	// -- Public Object State Variables and Methods
	public Customer(String custId, String firstName, String lastName) {
		// Constructor
		// Set the id to the next one available for all objects of this class
		id = nextId++;
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Add this customer to the list of customers
		customers.add(this);
	}
	
	// Print data for this Customer
	public void print() {
		System.out.println("-- Customer Info --");
		System.out.println("Customer Id: " + custId);
		System.out.println("Customer First Name: " + firstName);
		System.out.println("Customer Last Name: " + lastName);
		
		printTickets();
	}
	
	// Given a list of tickets, add them to the customers ticket list.
	public void takeTickets(ArrayList<Ticket> tickets){
		ticketsPurchased.addAll(tickets);
	}
	
	public void printTickets() {
		System.out.println("[DEBUG] Calling... Customer.printTickets()");
		System.out.println("[DEBUG] ticketsPurchased.size(): " + ticketsPurchased.size());
		
		for (Ticket ticket : ticketsPurchased) {
			ticket.print();
		}
	}
}
