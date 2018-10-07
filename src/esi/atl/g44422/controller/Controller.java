package esi.atl.g44422.controller;

import esi.atl.g44422.model.Viewport;
import esi.atl.g44422.view.View;

public class Controller {
	private View view;
	private Viewport viewport;

	public Controller() {
		this.setView(new View());
		this.setViewport(new Viewport());
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	public void start() {
		this.getView().displayLogo();
		this.getView().displayWelcome();
		while (true) {
			this.getView().displayEnter();
			String command = this.getView().getSc().nextLine();
			this.handleCommand(command.split(" "));
		}
	}

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

	public boolean hasGoodNumberOfArguments(int min, int max, String[] args) {
		return (args.length - 1) >= min
				&& (args.length - 1) <= max;
	}
}
