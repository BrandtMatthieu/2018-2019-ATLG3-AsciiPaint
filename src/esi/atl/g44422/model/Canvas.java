package esi.atl.g44422.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

	public Canvas(double sizeX, double sizeY, char background, boolean grid, boolean border, int id) throws IllegalArgumentException {
		this.setSizeX(sizeY);
		this.setSizeY(sizeY);
		this.setBackground(background);
		this.setGrid(grid);
		this.setBorder(border);
		this.setId(id);
	}

	public double getSizeX() {
		return sizeX;
	}

	public void setSizeX(double sizeX) throws IllegalArgumentException {
		if (sizeX < 0) {
			throw new IllegalArgumentException();
		}
		this.sizeX = sizeX;
	}

	public double getSizeY() {
		return sizeY;
	}

	public void setSizeY(double sizeY) throws IllegalArgumentException {
		if (sizeY < 0) {
			throw new IllegalArgumentException();
		}
		this.sizeY = sizeY;
	}

	public char getBackground() {
		return background;
	}

	public void setBackground(char background) {
		this.background = background;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws IllegalArgumentException {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	public boolean isGrid() {
		return grid;
	}

	public void setGrid(boolean grid) {
		this.grid = grid;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public int getShapeIdCount() {
		return shapeIdCount;
	}

	public void setShapeIdCount(int shapeIdCount) throws IllegalArgumentException {
		if (shapeIdCount < 0) {
			throw new IllegalArgumentException();
		}
		this.shapeIdCount = shapeIdCount;
	}

	public ArrayList<String> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<String> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "Canvas | Id: " + this.getId() + " Shape count: " + this.getShapes().size() + " Size X: " + this.getSizeX() + " Size Y: " + this.getSizeY() + " Background: " + this.getBackground();
	}

	public boolean hasShapeWithId(int id) {
		for (Shape shape : this.getShapes()) {
			if (shape.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Shape getShapeWithId(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			for (Shape shape : this.getShapes()) {
				if (shape.getId() == id) {
					return shape;
				}
			}
		}
		throw new IllegalArgumentException();
	}

	public int getIndexOfShapeWithId(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			for (int i = 0; i < this.getShapes().size(); i++) {
				if (this.getShapes().get(i).getId() == id) {
					return i;
				}
			}
		}
		throw new IllegalArgumentException();
	}

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

	public void addShape(String[] args) throws IllegalArgumentException {
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
			throw new IllegalArgumentException();
		}
	}

	public void removeShapeWithId(int id) throws IllegalArgumentException {
		if (this.hasShapeWithId(id)) {
			this.shapes.remove(this.getShapeWithId(id));
			return;
		}
		throw new IllegalArgumentException();
	}

	public void addToHistory(String args) {
		this.history.add(String.join(" ", args));
	}

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

	public void clearShapes() {
		this.setShapes(new ArrayList<Shape>());
	}

	public void moveShapeWithId(double dx, double dy, int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			this.getShapeWithId(id).move(dx, dy);
			return;
		}
		throw new IllegalArgumentException();
	}

	public void moveShapeWithIdUp(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id < this.getShapes().size()) {
				Collections.swap(this.shapes, id, id + 1);
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	public void moveShapeWithIdDown(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id > 0) {
				Collections.swap(this.shapes, id, id - 1);
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	public void moveShapeWithIdFront(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id < this.getShapes().size()) {
				Shape temp = getShapeWithId(id);
				this.shapes.remove(getShapeWithId(id));
				this.shapes.add(temp);
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	public void moveShapeWithIdBack(int id) throws IllegalArgumentException {
		if (hasShapeWithId(id)) {
			if (id > 0) {
				Shape temp = getShapeWithId(id);
				this.shapes.remove(getShapeWithId(id));
				this.shapes.add(1, temp);
				return;
			}
		}
		throw new IllegalArgumentException();
	}
}