package donutProject.utilities;

import java.text.*;
import java.util.*;

public class Utility {

	// Date formatter
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	// Number formatter
	private static NumberFormat numberFormatter = new DecimalFormat("#0.00");

	/**
	 * Format a date
	 * 
	 * @param calendar
	 * @return
	 */
	public static String formatDate(GregorianCalendar calendar) {
		dateFormatter.setCalendar(calendar);
		return dateFormatter.format(calendar.getTime());
	}

	/**
	 * Format a number
	 * 
	 * @param number
	 * @return
	 */
	public static String formatNumber(double number) {
		return numberFormatter.format(number);
	}

	/**
	 * Print a empty line
	 */
	public static void printBlankDivider() {
		System.out.println();
	}

	/**
	 * Print a line
	 */
	public static void printDivider() {
		System.out.println("----------------------------------------");
	}
}
