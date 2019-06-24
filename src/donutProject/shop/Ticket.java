package donutProject.shop;

import java.util.Calendar;
import java.util.GregorianCalendar;

import donutProject.donut.Donut;
import donutProject.utilities.Utility;

public class Ticket {
	// The donut associated with the ticket
	private Donut donut;
	// The amount of the ticket
	private double amount;
	// The date the ticket is added to the register
	private GregorianCalendar date = new GregorianCalendar();

	/**
	 * Constructor
	 * 
	 * @param donut
	 */
	public Ticket(Donut donut) {
		this.donut = donut;
		this.setAmount();
	}

	/**
	 * Set the amount
	 */
	private void setAmount() {
		this.amount = this.donut.getPrice();
	}

	/**
	 * Get the amount
	 * 
	 * @return
	 */
	public double getAmount() {
		return this.amount;
	}

	/**
	 * Get the date
	 * 
	 * @return
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * Get the donut
	 * 
	 * @return
	 */
	public Donut getDonut() {
		return this.donut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return donut.getName() + " " + Utility.formatNumber(amount) + "€ \nSale time: " + date.getTime();
	}

}
