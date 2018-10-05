package esi.atl.g44422.model;

import java.util.ArrayList;

public class Canvas {
	private int sizeX;
	private int sizeY;
	private char background;
	private boolean grid;
	private boolean border;
	private int id;
	private Pixel[][] canvas;
	private ArrayList<Shape> shapes;
	private int shapeIdCount;
	private ArrayList<String> history;

	public Canvas(int sizeX, int sizeY, char background, boolean grid, boolean border, int id) throws IllegalArgumentException {
		this.setSizeX(sizeY);
		this.setSizeY(sizeY);
		this.setBackground(background);
		this.setGrid(grid);
		this.setBorder(border);
		this.setId(id);
		this.setCanvas(sizeX, sizeY, background);
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) throws IllegalArgumentException {
		if(sizeX < 0) {
			throw new IllegalArgumentException();
		}
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) throws IllegalArgumentException {
		if(sizeY < 0) {
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
		if(id < 0 || id > this.getShapeIdCount()) {
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

	public Pixel[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(int sizeX, int sizeY, char background) {
		this.canvas = new Pixel[sizeX][sizeY];
		for(Pixel[] line : this.canvas) {
			for(Pixel pixel : line) {
				pixel = new Pixel(background);
			}
		}
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
		if(shapeIdCount < 0) {
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
}
