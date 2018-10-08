package esi.atl.g44422.controller;

import esi.atl.g44422.model.ShapeType;
import esi.atl.g44422.model.Viewport;
import esi.atl.g44422.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * Controller part of the MVC mode Controls the flow of the program
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
	 * Returns the view of the controller Used to display messages in the console
	 * 
	 * @return the view of the controller
	 */
	private View getView() {
		return view;
	}

	/**
	 * Sets a new view for the controller
	 * 
	 * @param view a new view for the controller
	 */
	private void setView(View view) {
		this.view = view;
	}

	/**
	 * Returns the viewport of the controller
	 * Used to get access to the different models
	 * 
	 * @return the viewport of the controller
	 */
	private Viewport getViewport() {
		return viewport;
	}

	/**
	 * Sets a new viewport for the controller
	 * 
	 * @param viewport a new viewport for the controller
	 */
	private void setViewport(Viewport viewport) {
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
			this.handleCommand(new ArrayList<>(Arrays.asList(command.split(" "))));
		}
	}

	/**
	 * Handles the command received from the command line
	 * 
	 * @param args an array the the different words of the command
	 */
	private void handleCommand(ArrayList<String> args) {
		if (hasGoodNumberOfArguments(0, 10, args)) {
			switch (args.get(0).toLowerCase()) {
			case "add": {
				// add ?(canvasId) @shape @shapeArgs
				if (args.get(1).toLowerCase().equals("canvas")) { // add canvas ?(width) ?(height) ?[default] ?<border>
																	// ?<grid>
					if (hasGoodNumberOfArguments(2, 7, args)) {
						if (hasAtLeastNumberElements(args, 2)) {
							switch (args.get(2).toLowerCase()) {
							case "default":
								args.set(2,this.getViewport().getCanvasDefaultSizeX() + "");
								break;
							default:
								args.set(2, parseInt(args.get(2) + 1, 10) + "");
							}
						} else {
							args.add(this.getViewport().getCanvasDefaultSizeX() + "");
						}
						if (hasAtLeastNumberElements(args, 3)) {
							switch (args.get(3).toLowerCase()) {
							case "default":
								args.set(3, this.getViewport().getCanvasDefaultSizeY() + "");
								break;
							default:
								args.set(3, parseInt(args.get(3) + 1, 10) + "");
							}
						} else {
							args.add(this.getViewport().getCanvasDefaultSizeY() + "");
						}
						if (hasAtLeastNumberElements(args, 4)) {
							switch (args.get(4).toLowerCase()) {
							case "space":
								args.set(4, " ");
								break;
							case "null":
								args.set(4, null);
								break;
							case "default":
								args.set(4, this.getViewport().getCanvasDefaultBackground() + "");
								break;
							default:
								args.set(4, args.get(4).substring(0, 1) + "");
							}
						} else {
							args.add(this.getViewport().getCanvasDefaultBackground() + "");
						}
						if (hasAtLeastNumberElements(args, 5)) {
							switch (args.get(5)) {
							case "true":
								args.set(5, "true");
								break;
							case "false":
								args.set(5, "false");
								break;
							case "default":
								args.set(5, this.getViewport().isCanvasDefaultBorder() + "");
								break;
							default:
								throw new Error("Unknown command");
							}
						} else {
							args.add(this.getViewport().isCanvasDefaultBorder() + "");
						}
						if (hasAtLeastNumberElements(args, 6)) {
							switch (args.get(6)) {
							case "true":
								args.set(6, "true");
								break;
							case "false":
								args.set(6, "false");
								break;
							case "default":
								args.set(6, this.getViewport().isCanvasDefaultGrid() + "");
								break;
							default:
								throw new Error("Unknown command");
							}
						} else {
							args.add(this.getViewport().isCanvasDefaultGrid() + "");
						}
						this.getViewport().addCanvas(
							parseFloat(args.get(2)),
							parseFloat(args.get(3)),
							args.get(4).charAt(0),
							parseBoolean(args.get(5)),
							parseBoolean(args.get(6)),
							(this.getViewport().getCanvasIdCount() + 1)
						);
						this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
						this.getViewport().getCurrentCanvas().addToHistory(args);
					}
				} else if (Arrays.asList(ShapeType.values()).contains(Character.toUpperCase(args.get(1).charAt(0)) + args.get(1).substring(1).toLowerCase())) {
					this.getViewport().getCurrentCanvas().addShape(args.toArray(new String[0]));
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
					this.getViewport().getCurrentCanvas().addToHistory(args);
				} else {
					throw new Error("Unknown shape");
				}
			}
				break;
			case "remove": // remove ?(canvasId) (shapeId)
			{
				if (hasGoodNumberOfArguments(2, 3, args)) {
					if (args.size() == 2) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).removeShapeWithId(parseInt(args.get(2), 10));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "move": // move ?(canvasId) (shapeId) (dx) (dy)
			{
				if (hasGoodNumberOfArguments(4, 5, args)) {
					if (args.size() == 4) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).getShapeWithId(parseInt(args.get(2), 10)).move(parseFloat(args.get(3)), parseFloat(args.get(4)));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "resize":
				// TODO
				// resize canvas, viewport or shape?
				this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				break;
			case "list": // list [shapes]/[canvases] ?(canvasId)
			{
				if (hasGoodNumberOfArguments(2, 3, args)) {
					switch (args.get(1).toLowerCase()) {
					case "shapes":
						if (args.size() == 2) {
							args.add(2, this.getViewport().getCurrentCanvasId() + "");
						}
						this.getViewport().getCanvasWithId(parseInt(args.get(2), 10)).listShapes();
						this.getViewport().getCanvasWithId(parseInt(args.get(2), 10)).addToHistory(args);
						break;
					case "canvases":
						this.getViewport().listCanvases();
						break;
					default:
						throw new Error("Unknown command");
					}
				}
			}
				break;
			case "show": // show ?(canvasId)
			{
				if (hasGoodNumberOfArguments(1, 2, args)) {
					if (args.size() == 1) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).render().toString());
				}
			}
				break;
			case "clear": {
				// clear ?(canvasId)
				if (args.size() == 1) {
					args.add(1, this.getViewport().getCurrentCanvasId() + "");
				}
				this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).clearShapes();
				this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
				this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
			}
				break;
			case "canvas": // canvas (id)
			{
				if (hasGoodNumberOfArguments(2, 2, args)) {
					this.getViewport().setCurrentCanvasId(parseInt(args.get(1), 10));
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "fill": // fill ?(CanvasId) (id) [newFill]
			{
				if (hasGoodNumberOfArguments(3, 4, args)) {
					if (args.size() == 3) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					switch (args.get(3).toLowerCase()) {
					case "space":
						args.set(3, " ");
						break;
					case "null":
						args.set(3, null);
						break;
					default:
						args.set(3, args.get(3).substring(0, 1));
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).getShapeWithId(parseInt(args.get(2), 10)).setFill(args.get(3).charAt(0));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "outline": // outline ?(CanvasId) (id) [newOutline]
			{
				if (hasGoodNumberOfArguments(3, 4, args)) {
					if (args.size() == 3) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					switch (args.get(3).toLowerCase()) {
					case "space":
						args.set(3, " ");
						break;
					case "null":
						args.set(3, null);
						break;
					default:
						args.set(3, args.get(3).substring(0, 1));
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).getShapeWithId(parseInt(args.get(2), 10)).setOutline(args.get(3).charAt(0));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "up": // up ?(canvasId) (shapeId)
			{
				if (hasGoodNumberOfArguments(2, 3, args)) {
					if (args.size() == 2) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).moveShapeWithIdUp(parseInt(args.get(2), 10));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "down": // down ?(canvasId) (shapeId)
			{
				if (hasGoodNumberOfArguments(2, 3, args)) {
					if (args.size() == 2) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).moveShapeWithIdDown(parseInt(args.get(2), 10));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "front": // front ?(canvasId) (shapeId)
			{
				if (hasGoodNumberOfArguments(2, 3, args)) {
					if (args.size() == 2) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).moveShapeWithIdFront(parseInt(args.get(2), 10));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "back": // back ?(canvasId) (shapeId)
			{
				if (hasGoodNumberOfArguments(2, 3, args)) {
					if (args.size() == 2) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).moveShapeWithIdBack(parseInt(args.get(2), 10));
					this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).addToHistory(args);
					this.getView().display(this.getViewport().getCurrentCanvas().render().toString());
				}
			}
				break;
			case "history": // history ?(canvasId)
			{
				if (hasGoodNumberOfArguments(1, 2, args)) {
					if (args.size() == 1) {
						args.add(1, this.getViewport().getCurrentCanvasId() + "");
					}
					this.getView().display(this.getViewport().getCanvasWithId(parseInt(args.get(1), 10)).listHistory());
				}
			}
				break;
			case "help": // help ?[command]
				break;
			case "exit":
			case "quit":
				this.getView().displayExit();
				System.exit(0);
			case "":
				break;
			default:
				throw new Error("Unknown command");
			}
		}
	}

	/**
	 * Checks if the command has at least the number of parameters
	 *
	 * @param array the arguments of the command
	 * @param number the number of required parameters
	 * @return if the command has at least the number of parameters
	 */
	private boolean hasAtLeastNumberElements(ArrayList<String> array, int number) {
		return array.size() >= number;
	}

	/**
	 * Checks if the command as an array of words has the right number of parameters
	 * 
	 * @param min  the minimum number of arguments accepted
	 * @param max  the maximum number of arguments accepted
	 * @param args the command as an array of words from the command line
	 * @return true if the command has the good number of arguments
	 */
	private boolean hasGoodNumberOfArguments(int min, int max, ArrayList<String> args) {
		return (args.size() - 1) >= min && (args.size() - 1) <= max;
	}
}
