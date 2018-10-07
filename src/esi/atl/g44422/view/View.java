package esi.atl.g44422.view;

import java.util.Scanner;

public class View {

	private Scanner sc;

	public View() {
		this.setSc(new Scanner(System.in));
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void displayLogo() {
		System.out.println("" +
			"                    _ _ _____      _       _   \n" +
			"     /\\            (_|_)  __ \\    (_)     | |  \n" +
			"    /  \\   ___  ___ _ _| |__) |_ _ _ _ __ | |_ \n" +
			"   / /\\ \\ / __|/ __| | |  ___/ _` | | '_ \\| __|\n" +
			"  / ____ \\\\__ \\ (__| | | |  | (_| | | | | | |_ \n" +
			" /_/    \\_\\___/\\___|_|_|_|   \\__,_|_|_| |_|\\__|\n" +
			"                                               \n");
	}

	public void displayWelcome() {
		System.out.println("Welcome in AsciiPaint.\nType \"help\" to get a list with all commands.");
	}

	public void displayEnter() {
		System.out.print("Enter a command:\n> ");
	}

	public void displayExit() {
		System.out.println("Exiting AsciiArt.\nThanks for using it.");
	}

	public void display(String str) {
		System.out.println(str);
	}
}
