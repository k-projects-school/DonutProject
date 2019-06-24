package donutProject.shop;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import donutProject.utilities.Utility;

public class Register {

	// The tickets in the register
	private Ticket[] tickets = new Ticket[0];
	// The amount of money in the register
	private double totalMoney = 0;
	// The amount of tickets in the register
	private int ticketCount = 0;

	/**
	 * Get the total money in the register
	 * 
	 * @return
	 */
	public double getTotalMoney() {
		return this.totalMoney;
	}
	
	/**
	 * @return the ticketCount
	 */
	public int getTicketCount() {
		return ticketCount;
	}

	/**
	 * Add a ticket
	 * 
	 * @param ticket
	 */
	public void addTicket(Ticket ticket) {
		// Copy the tickets array and make it 1 entry longer
		this.tickets = Arrays.copyOf(this.tickets, this.tickets.length + 1);
		// Add the new ticket to the array
		this.tickets[this.tickets.length - 1] = ticket;
		// Add the amount of the ticket to the total amount
		this.totalMoney += ticket.getAmount();
		// Increment the ticket count
		this.ticketCount++;
	}

	/**
	 * Print all the tickets
	 */
	public void printTickets() {
		for (Ticket ticket : this.tickets) {
			System.out.println(ticket);
			Utility.printDivider();
		}
		System.out.println("Total value: " + Utility.formatNumber(this.getTotalMoney()) + "€");
	}

	/**
	 * Print a overview of the cans that are sold on the current date
	 */
	public void printDailyOverview() {
		// Create a new Gregorian Calendar instance
		GregorianCalendar calendar = new GregorianCalendar();
		System.out.println("Sales for: " + Utility.formatDate(calendar));
		// The total value of the tickets for the current date
		double totalValue = 0;
		// HashMap to store all the cans that are sold
		HashMap<String, Integer> donuts = new HashMap<String, Integer>();
		// Loop through all the tickets
		for (Ticket ticket : this.tickets) {
			// Check if the current ticket is from the same date as today
			if (ticket.getDate().get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)
					&& ticket.getDate().get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
				// Set the count of the can type
				int count = 1;
				// If there is already a can type in the hashmap, set the count to the count of
				// the can type and add 1
				if (donuts.containsKey(ticket.getDonut().getName())) {
					count = donuts.get(ticket.getDonut().getName()) + 1;
				}
				// Store the new count of the can type in the hashmap
				donuts.put(ticket.getDonut().getName(), count);
				// Add the amount of the ticket to the total value
				totalValue += ticket.getAmount();
			}
		}

		// Print all the can types with the amount they are sold
		for (String name : donuts.keySet()) {
			System.out.println(name + ": " + donuts.get(name));
		}

		// Print the total value of the tickets from today
		System.out.println("Total value: " + Utility.formatNumber(totalValue) + "€");
	}

}
