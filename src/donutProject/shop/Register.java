package donutProject.shop;

import java.util.Arrays;

public class Register {

	private Ticket[] tickets = new Ticket[0];
	private double totalMoney = 0;
	private int ticketCount = 0;

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

}
