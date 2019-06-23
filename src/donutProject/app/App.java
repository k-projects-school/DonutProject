package donutProject.app;

import donutProject.shop.Shop;

public class App {

	public static void main(String[] args) {
		
		Shop shop = new Shop(10);
		shop.printMenu();
	}

}
