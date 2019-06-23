package donutProject.shop;

import java.util.HashMap;

import donutProject.donut.Donut;
import donutProject.enums.Flavor;

public class Stock {
	private HashMap<Flavor, Integer> amountInStock = new HashMap<Flavor, Integer>();

	/**
	 * Initialize the Stock ledger.
	 * 
	 * @param stockAmount - The amount for every flavor.
	 */
	public void initStock(int stockAmount) {
		for (Flavor flavor : Flavor.values()) {
			this.amountInStock.put(flavor, stockAmount);
		}

	}

	/**
	 * Refill the stock amount for a Flavor.
	 * 
	 * @param flavor - Flavor that needs to be refilled.
	 * @param amount - How much the given Flavor needs to be refilled.
	 */
	public void refillStock(Flavor flavor, int amount) {
		int current = this.amountInStock.get(flavor);
		this.amountInStock.put(flavor, current + amount);
	}

	/**
	 * Refill the stock amount for all flavors.
	 * 
	 * @param amount - How much the flavors needs to be refilled.
	 */
	public void refillStock(int amount) {
		for (Flavor flavor : Flavor.values()) {
			int current = this.amountInStock.get(flavor);
			this.amountInStock.put(flavor, current + amount);
		}
	}

	/**
	 * Check if a Flavor is in stock.
	 * 
	 * @param flavor - The Flavor that needs to be checked.
	 * @return Boolean
	 */
	public boolean check(Flavor flavor) {
		return this.amountInStock.get(flavor) > 0;
	}

	/**
	 * Sell a Donut.
	 * 
	 * @param flavor - The Flavor that is going to be sold.
	 * @return Donut
	 */
	public Donut sell(Flavor flavor) {
		int amountInStock = this.amountInStock.get(flavor);
		this.amountInStock.put(flavor, --amountInStock);
		return new Donut(flavor);
	}

}
