package donutProject.shop;

import java.util.InputMismatchException;

import donutProject.donut.Donut;
import donutProject.enums.Flavor;
import donutProject.utilities.Kbd;

public class Shop {
	// The stock for the shop
	private Stock stock = new Stock();
	// The register for the shop
	private Register register = new Register();

	/**
	 * Constructor
	 * 
	 * @param stockAmount
	 */
	public Shop(int stockAmount) {
		this.stock.initStock(stockAmount);
	}

	/**
	 * Get the Stock.
	 * 
	 * @return - Stock
	 */
	public Stock getStock() {
		return this.stock;
	}

	/**
	 * Get the Register.
	 * 
	 * @return - Register
	 */
	public Register getRegister() {
		return this.register;
	}

	/**
	 * Get a Donut chosen by the user.
	 * 
	 * @param choice - The numeric value of the flavor.
	 * @return Donut
	 */
	public Donut getChoice(int choice) {
		return new Donut(Flavor.values()[choice - 1]);
	}

	/**
	 * Print the menu
	 */
	public void printMenu() {
		System.out.println("Make your choice: ");

		// Loop through the flavors
		for (Flavor flavor : Flavor.values()) {
			// String suffix to show if the current flavor is sold out or not
			String suffix = "";
			// If the stock is depleted of a flavor
			if (!this.stock.check(flavor)) {
				suffix = " / SOLD OUT!";
			}

			System.out.println(
					"[" + (flavor.ordinal() + 1) + "] " + flavor.getName() + " - " + flavor.getPrice() + "€" + suffix);
		}
		System.out.print("Choose a number between 1 and " + Flavor.values().length + ": ");

	}

	/**
	 * Handle the user input
	 */
	public void handleUserInput() {
		try {
			// Get the response of the user and parse it to an integer
			int input = Integer.parseInt(Kbd.next());

			/*
			 * If the user gave a wrong number (to high or to low), throw a
			 * InputMismatchException
			 */
			if (input > Flavor.values().length || input < 0) {
				throw new InputMismatchException();
			}
			// Get the chosen flavor
			Flavor flavor = Flavor.values()[input - 1];

			if (this.stock.check(flavor)) {
				// If the flavor is in stock, sell the donut and add a ticket to the register
				this.register.addTicket(new Ticket(this.stock.sell(flavor)));
			} else {
				// If the chosen flavor is not in stock
				System.out.println(
						"The article You choose is not available at this moment. Please choose another article.");
				this.handleUserInput();
			}

		} catch (InputMismatchException | NumberFormatException e) {
			/*
			 * If a user enters a wrong input (a number to high or to low, or a non numeric
			 * input), show a message and let the user choose a new flavor.
			 */
			System.out.println("You have to enter a number between 1 and " + Flavor.values().length);
			this.handleUserInput();
		}
	}
}
