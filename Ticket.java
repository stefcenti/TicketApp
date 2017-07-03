import java.util.ArrayList;
import java.util.Scanner;

// This class will keep track of the tickets available, 
// the number of tickets sold and the total
// amount collected.
public class Ticket {
	// -- Private Class Variables and Methods
	private static Scanner in = new Scanner(System.in);
	// Generate an id for each Ticket added to inventory
	// id will keep track of the next id available.
	private static int nextId = 0;
	private static int totalOpen = 0;
	private static int totalSold = 0;
	private static double amountCollected = 0.0;
	
	// This list will be used for the average customer purchasing tickets.
	// Each sub-type will use it's own list to hold tickets for it's own class.
	private static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	// -- Public Class Variables and Methods
	// Creates <count> number of tickets and adds them to tickets
	public static void addToInventory(int count, double price){
		System.out.println("[DEBUG] Calling... Ticket.addToInventory(" + count + ", " + price + ")");

		for (int i=0; i<count; i++) {
			Ticket t = new Ticket(price);
			tickets.add(t);
		}
		
		totalOpen += count;
	}
	
	public static void printStatus() {
		System.out.println("Total Open Seats: " + Ticket.totalOpen);
		System.out.println("Total Sold Seats: " + Ticket.totalSold);
		System.out.println("Amount Collected: " + Ticket.amountCollected);
	}
	
	// -- Private Object State Variables and Methods
	private int id;
	
	// -- Protected Object State Variables and Methods
	protected enum   state { open, sold };
	protected state  status = state.open;
	protected double price  = 0.0;
	
	// -- Public Object State Variables and Methods
	public Ticket(double price) {
		// Constructor
		// Set the id to the next one available for all objects of this class
		id = nextId++;
		this.price = price;
	}
	
	public static ArrayList<Ticket> purchase(int count){
		System.out.println("[DEBUG] Calling... Ticket.purchase(" + count + ")");
		
		ArrayList<Ticket> ticketsPurchased = new ArrayList<Ticket>();
		
		if (tickets.size() < 1) {
			System.out.println("There are no more tickets available for this event.");
			return ticketsPurchased;
		}
		
		if (count > tickets.size()) {
			System.out.println("There are only " + tickets.size() + " available for purchase.");
			System.out.println("Continue (y/n)? ");
			String resp = in.next();
			if (resp.charAt(0) == 'n') return ticketsPurchased;
		}
		
		for (int i=0; i<count && tickets.size() > 0; i++) {

			// Take the first from the front of the list			
			Ticket ticket = tickets.remove(0);
			
			totalSold++;
			totalOpen--;
			amountCollected += ticket.price;
			
			ticket.status = state.sold;
			
			ticketsPurchased.add(ticket);
		}
		
		return ticketsPurchased;
	}
	
	public void print() {
		System.out.println("Ticket Number: " + id);
		System.out.println("Ticket Status: " + status);
		System.out.println("Ticket Price:  " + price);
	}
}
