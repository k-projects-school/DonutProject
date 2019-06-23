package donutProject.donut;

import donutProject.enums.Flavor;

public class Donut {
	/*
	 * The flavor of the Donut.
	 */
	private Flavor flavor;

	/*
	 * The price of the Donut.
	 */
	private double price;

	/**
	 * Constructor.
	 * 
	 * @param flavor
	 */
	public Donut(Flavor flavor) {
		this.flavor = flavor;
		this.price = flavor.getPrice();
	}

	/**
	 * Get the price of the Donut.
	 * 
	 * @return - Double
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Get the Flavor of the Donut.
	 * 
	 * @return - Flavor
	 */
	public Flavor getFlavor() {
		return this.flavor;
	}
}
