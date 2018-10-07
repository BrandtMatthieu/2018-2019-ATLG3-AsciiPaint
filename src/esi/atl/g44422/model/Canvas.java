package esi.atl.g44422.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a canvas in the Model
 */
public class Canvas {
	private double sizeX;
	private double sizeY;
	private char background;
	private boolean grid;
	private boolean border;
	private int id;
	private ArrayList<Shape> shapes;
	private int shapeIdCount;
	private ArrayList<String> history;

	/**
	 * Creates a naw canvas
	 * @param sizeX the width of the new canvas
	 * @param sizeY the height of the new canvas
	 * @param background the background character of the canvas
	 * @param grid if the canvas has a grid
	 * @param border if the canvas has a border
	 * @param id the id of the new canvas
	 * @throws IllegalArgumentException if the width or height of the new canvas is negative
	 */
	public Canvas(double sizeX, double sizeY, char background, boolean grid, boolean border, int id) throws IllegalArgumentException {
		this.setSizeX(sizeY);
		this.setSizeY(sizeY);
		this.setBackground(background);
		this.setGrid(grid);
		this.setBorder(border);
		this.setId(id);
	}

	/**
	 * Returns the width of the canvas
	 * @return the width of the canvas
	 */
	public double getSizeX() {
		return sizeX;
	}

	/**
	 * Sets a new width for the canvas
	 * @param sizeX the width of the canvas
	 * @throws IllegalArgumentException if the width is negative
	 */
	public void setSizeX(double sizeX) throws IllegalArgumentException {
		if (sizeX < 0) {
			throw new IllegalArgumentException("The width of the canvas cannot be negative");
		}
		this.sizeX = sizeX;
	}

	/**
	 * Returns the height of the canvas
	 * @return the height of the canvas
	 */
	public double getSizeY() {
		return sizeY;
	}

	/**
	 * Sets the height of the canvas
	 * @param sizeY the height of the canvas
	 * @throws IllegalArgumentException if the height is negative
	 */
	public void setSizeY(double sizeY) throws IllegalArgumentException {
		if (sizeY < 0) {
			throw new IllegalArgumentException("The height of the canvas cannot be negative");
		}
		this.sizeY = sizeY;
	}

	/**
	 * Returns the background of the canvas
	 * @return the background of the canvas
	 */
	public char getBackground() {
		return background;
	}

	/**
	 * Sets the background of the canvas
	 * @param background the background of the canvas
	 */
	public void setBackground(char background) {
		this.background = background;
	}

	/**
	 * Returns the id of the canvas
	 * @return the id of the canvas
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the canvas
	 * @param id the id of the canvas
	 * @throws IllegalArgumentException if the id is negative
	 */
	public void setId(int id) throws IllegalArgumentException {
		if (id < 0) {
			throw new IllegalArgumentException("The id cannot be negative");
		}
		this.id = id;
	}

	/**
	 * Returns if the canvas has a grid
	 * @return if the canvas has a grid
	 */
	public boolean isGrid() {
		return grid;
	}

	/**
	 * Sets the grid for the canvas
	 * @param grid the grid for the canvas
	 */
	public void setGrid(boolean grid) {
		this.grid = grid;
	}

	/**
	 * Returns if the canvas has a border
	 * @return if the canvas has a border
	 */
	public boolean isBorder() {
		return border;
	}

	/**
	 * Sets the border for the canvas
	 * @param border the border for the canvas
	 */
	public void setBorder(boolean border) {
		this.border = border;
	}

	/**
	 * Returns a list with all shapes of the canvas
	 * @return a list with all shapes of the canvas
	 */
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	/**
	 * Sets the list of all shapes of the canvas
	 * @param shapes the list of all shapes of the canvas
	 */
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * Returns the biggest id created
	 * @return the biggest id created
	 */
	public int getShapeIdCount() {
		return shapeIdCount;
	}

	/**
	 * Sets the biggest id created
	 * @param shapeIdCount the biggest id created
	 * @throws IllegalArgumentException if the id is negative
	 */
	public void setShapeIdCount(int shapeIdCount) throws IllegalArgumentException {
		if (shapeIdCount < 0) {
			throw new IllegalArgumentException("IdCount cannot be negative");
		}
		this.shapeIdCount = shapeIdCount;
	}

	/**
	 * Returns the history of all actions done on the canvas
	 * @return the history of all actions done on the canvas
	 */
	public ArrayList<String> getHistory() {
		return history;
	}

	/**
	 * Sets the history of all actions done on the canvas
	 * @param history the history of all actions done on the canvas
	 */
	public void setHistory(ArrayList<String> history) {
		this.history = history;
	}

	/**
	 * Returns a string describing the canvas
	 * @return a string describing the canvas
	 */
	@Override
	public String toString() {
		return "Canvas | Id: " + this.getId() + " Shape count: " + this.getShapes().size() + " Size X: " + this.getSizeX() + " Size Y: " + this.getSizeY() + " Background: " + this.getBackground();
	}

	/**
	 * Returns if the canvas has a shape that match with the provided id
	 * @param id the id of a shape
	 * @return if the canvas has a shape that match with the provided id
	 */
	public boolean hasShapeWithId(int id) {
		for (Shape shape : this.getShapes()) {
			if (shape.getId() == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the shape that matches with the provided shape id
	 * @param id the id of a shape
	 * @return the shape that matches with the provided shape id
	 * @throws IllegalArgumentException if no shape mathes the id
	 */
	public Shape getShapeWithId(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			for (Shape shape : this.getShapes()) {
				if (shape.getId() == id) {
					return shape;
				}
			}
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Returns the index of the shapes in the list of shapes for the shape with the provided id
	 * @param id the id of a shape
	 * @return the index of the shapes in the list of shapes for the shape with the provided id
	 * @throws IllegalArgumentException if no shape mathes the id
	 */
	public int getIndexOfShapeWithId(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			for (int i = 0; i < this.getShapes().size(); i++) {
				if (this.getShapes().get(i).getId() == id) {
					return i;
				}
			}
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Returns a string describing all the shapes of the canvas
	 * @return a string describing all the shapes of the canvas
	 */
	public String listShapes() {
		String str;
		if (this.getShapes().size() == 0) {
			str =  "There are no shapes in this canvas";
		} else {
			str = "List of shapes for canvas id: " + this.getId();
			for (Shape shape : this.getShapes()) {
				str += "\n\t" + shape.toString();
			}
		}
		return str;
	}

	/**
	 * Returns a string describing all the operation in this canvas
	 * @return a string describing all the operation in this canvas
	 */
	public String listHistory() {
		String str;
		if(this.getHistory().size() == 0) {
			str = "No history for this canvas.";
		} else {
			str = "History for canvas id: " + this.getId();
			for(String history : this.getHistory()) {
				str += "\n\t" + history.toString();
			}
		}
		return str;
	}

	/**
	 * Adds a shape to the list of shapes of this canvas
	 * @param args the arguments provided to create the shape
	 * @throws IllegalArgumentException if the provided argument doesn't match with any known shape
	 */
	public void addShape(String[] args) throws IllegalArgumentException {
		if(ShapeType.values()  args[1].substring(0, 1).toUpperCase() + args[1].substring(1).toLowerCase()) { // TODO

		}
		switch (args[1].toLowerCase()) {
		case "ellipse":
			break;
		case "circle":
			break;
		case "rectangle":
			break;
		case "square":
			break;
		case "line":
			break;
		case "point":
			break;
		default:
			throw new IllegalArgumentException("Unknown shape");
		}
	}

	/**
	 * Removes the shape that matches the provided id
	 * @param id the id of the shape to remove
	 * @throws IllegalArgumentException if the provided argument doesn't match with any known shape
	 */
	public void removeShapeWithId(int id) throws IllegalArgumentException {
		if (this.hasShapeWithId(id)) {
			this.shapes.remove(this.getShapeWithId(id));
			return;
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Adds a command to the canvas's history
	 * @param args the args that mad the command
	 */
	public void addToHistory(String args) {
		this.history.add(String.join(" ", args));
	}

	/**
	 * Renders the canvas
	 * @return the rendered canvas
	 */
	public ArrayList<ArrayList<Pixel>> render() {
		ArrayList<ArrayList<Pixel>> canvas = new ArrayList<ArrayList<Pixel>>();
		for (int j = 1; j < this.getSizeY() + 1; j++) {
			canvas.add(new ArrayList<Pixel>());
			for (int i = 1; i < this.getSizeX() + 1; i++) {
				canvas.get(j - 1).add(new Pixel(this.getBackground()));
				for (Shape shape : this.getShapes()) {
					if (shape.isInside(new Point(i, j))) {
						canvas.get(j).get(i).setValue(shape.getFill());
					}
				}
			}
		}
		return canvas;
	}

	/**
	 * Removes all the shapes from the canvas
	 */
	public void clearShapes() {
		this.setShapes(new ArrayList<Shape>());
	}

	/**
	 * Moves the shape that matches the provided id
	 * @param dx the horizontal move
	 * @param dy the vertical move
	 * @param id the id of the shape to move
	 * @throws IllegalArgumentException if the provided id doesn't match with any known shape
	 */
	public void moveShapeWithId(double dx, double dy, int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			this.getShapeWithId(id).move(dx, dy);
			return;
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Moves the shape corresponding to the id one layer up
	 * @param id the id of the corresponding shape
	 * @throws IllegalArgumentException if the id doesn't matches any shape
	 */
	public void moveShapeWithIdUp(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id < this.getShapes().size()) {
				Collections.swap(this.shapes, id, id + 1);
				return;
			}
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Moves the shape corresponding to the id one layer down
	 * @param id the id of the corresponding shape
	 * @throws IllegalArgumentException if the id doesn't matches any shape
	 */
	public void moveShapeWithIdDown(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id > 0) {
				Collections.swap(this.shapes, id, id - 1);
				return;
			}
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Moves the shape corresponding to the id to the first layer
	 * @param id the id of the corresponding shape
	 * @throws IllegalArgumentException if the id doesn't matches any shape
	 */
	public void moveShapeWithIdFront(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id < this.getShapes().size()) {
				Shape temp = getShapeWithId(id);
				this.shapes.remove(getShapeWithId(id));
				this.shapes.add(temp);
				return;
			}
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}

	/**
	 * Moves the shape corresponding to the id to the last layer
	 * @param id the id of the corresponding shape
	 * @throws IllegalArgumentException if the id doesn't matches any shape
	 */
	public void moveShapeWithIdBack(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id > 0) {
				Shape temp = getShapeWithId(id);
				this.shapes.remove(getShapeWithId(id));
				this.shapes.add(1, temp);
				return;
			}
		}
		throw new IllegalArgumentException("No shape matches this id in this canvas");
	}
}