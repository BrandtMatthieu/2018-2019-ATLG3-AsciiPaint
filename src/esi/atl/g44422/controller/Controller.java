package esi.atl.g44422.controller;

import esi.atl.g44422.model.Viewport;
import esi.atl.g44422.view.View;

/**
 * Controller part of the MVC mode
 * Controls the flow of the program
 */
public class Controller {
	private View view;
	private Viewport viewport;

	/**
	 * Creates a new controller
	 */
	public Controller() {
		this.setView(new View());
		this.setViewport(new Viewport());
	}

	/**
	 * Returns the view of the controller
	 * Used to display messages in the console
	 * @return the view of the controller
	 */
	public View getView() {
		return view;
	}

	/**
	 * Sets a new view for the controller
	 * @param view a new view for the controller
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Returns the viewport of the controller
	 * Used to get access to the different models
	 * @return the viewport of the controller
	 */
	public Viewport getViewport() {
		return viewport;
	}

	/**
	 * Sets a new viewport for the controller
	 * @param viewport a new viewport for the controller
	 */
	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	/**
	 * Starts the program
	 */
	public void start() {
		this.getView().displayLogo();
		this.getView().displayWelcome();
		while (true) {
			this.getView().displayEnter();
			String command = this.getView().getSc().nextLine();
			this.handleCommand(command.split(" "));
		}
	}

	/**
	 * Handles the command received from the command line
	 * @param args an array the the different words of the command
	 */
	public void handleCommand(String[] args) {
		if (hasGoodNumberOfArguments(0, 10, args)) {
			switch (args[0].toLowerCase()) {
				case "quit":
				case "exit":
					System.exit(0);
					break;
				case "":
					break;
			}
		}
	}

	/**
	 * Checks if the command as an array of words has the right number of parameters
	 * @param min the minimum number of arguments accepted
	 * @param max the maximum number of arguments accepted
	 * @param args the command as an array of words from the command line
	 * @return true if the command has the good number of arguments
	 */
	public boolean hasGoodNumberOfArguments(int min, int max, String[] args) {
		return (args.length - 1) >= min
				&& (args.length - 1) <= max;
	}
}
