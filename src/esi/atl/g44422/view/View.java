package esi.atl.g44422.view;

import java.util.Scanner;

/**
 * View part of the MVC model Controls what displays the program
 */
public class View {

	private Scanner sc;

	/**
	 * Creates a new view
	 */
	public View() {
		this.setSc(new Scanner(System.in));
	}

	/**
	 * Returns the scanner used in the program
	 *
	 * @return the scanner used in the program
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * Sets a new scanner for the program
	 *
	 * @param sc a new scanner for the program
	 */
	private void setSc(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Clears the screen
	 */
	public void clearScreen() {
		System.out.print("\033");
		System.out.flush();
		System.out.print("\033\143\n");
	}

	/**
	 * Displays the logo when the program starts
	 */
	public void displayLogo() {
		System.out.println(""
				+ "                    _ _ _____      _       _   \n"
				+ "     /\\            (_|_)  __ \\    (_)     | |  \n"
				+ "    /  \\   ___  ___ _ _| |__) |_ _ _ _ __ | |_ \n"
				+ "   / /\\ \\ / __|/ __| | |  ___/ _` | | '_ \\| __|\n"
				+ "  / ____ \\\\__ \\ (__| | | |  | (_| | | | | | |_ \n"
				+ " /_/    \\_\\___/\\___|_|_|_|   \\__,_|_|_| |_|\\__|\n"
				+ "                                               \n");
	}

	/**
	 * Displays a welcome message
	 */
	public void displayWelcome() {
		System.out.println("Welcome in AsciiPaint.\nType \"help\" to get a list with all commands.\n\n");
	}

	/**
	 * Displays a message so the user enters a command
	 */
	public void displayEnter() {
		System.out.print("Enter a command:\n> ");
	}

	/**
	 * Displays an exit message
	 */
	public void displayExit() {
		System.out.println("Exiting AsciiArt.\nThanks for using it.");
	}

	/**
	 * Displays something on the screen
	 *
	 * @param str the string to print
	 */
	public void display(String str) {
		System.out.println(str);
	}
}
