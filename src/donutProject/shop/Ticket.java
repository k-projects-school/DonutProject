package donutProject.shop;

import donutProject.donut.Donut;

public class Ticket {

	private Donut donut;
	private double amount;

	public Ticket(Donut donut) {
		this.donut = donut;
		this.setAmount();
	}

	private void setAmount() {
		this.amount = this.donut.getPrice();
	}

	public double getAmount() {
		return this.amount;
	}

}
