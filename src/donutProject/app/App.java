package donutProject.app;

import donutProject.shop.Register;
import donutProject.shop.Shop;
import donutProject.utilities.Utility;

public class App {

	public static void main(String[] args) {
		// Create a new shop
		Shop shop = new Shop(10);
		// A loop counter
		int loop = 0;

		/*
		 * As long the loop counter is lower than 5, print the menu and handle the user
		 * input
		 */
		while (loop < 5) {
			shop.printMenu();
			shop.handleUserInput();
			loop++;
		}

		Utility.printDivider();
		Utility.printBlankDivider();
		// Get the register of the shop
		Register register = shop.getRegister();

		// Print all the tickets of the shop
		System.out.println("All tickets: ");
		register.printTickets();
		Utility.printDivider();
		Utility.printBlankDivider();
		// Print the amount of each donut sold for the current day
		register.printDailyOverview();
	}

}
