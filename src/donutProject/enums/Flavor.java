package donutProject.enums;

public enum Flavor {
	NORMAL(2), GLAZED(2.5), CHOCO(3), CREAM(3.5);

	/*
	 * The price of the flavor.
	 */
	private double price;

	/**
	 * Constructor.
	 * 
	 * @param price
	 */
	private Flavor(double price) {
		this.price = price;
	}

	/**
	 * Get the price.
	 * 
	 * @return - Double
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Get the name first letter capitalized.
	 * 
	 * @return - String
	 */
	public String getName() {
		return this.name().charAt(0) + this.name().toLowerCase().substring(1);
	}

}
