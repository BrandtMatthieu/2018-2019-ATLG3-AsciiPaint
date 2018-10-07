package esi.atl.g44422.model;

import java.util.ArrayList;

public class Viewport {
	private ArrayList<Canvas> canvases;
	private int canvasIdCount;
	private int currentCanvasId;
	private double canvasDefaultSizeX;
	private double canvasDefaultSizeY;
	private char canvasDefaultBackground;
	private boolean canvasDefaultGrid;
	private boolean canvasDefaultBorder;

	public Viewport() throws IllegalArgumentException {
		this.setCanvases(new ArrayList<>());
		this.setCanvasIdCount(0);
		this.setCurrentCanvasId(0);
		this.setCanvasDefaultSizeX(80.0);
		this.setCanvasDefaultSizeY(50.0);
		this.setCanvasDefaultBackground('.');
		this.setCanvasDefaultGrid(false);
		this.setCanvasDefaultBorder(true);
	}

	public ArrayList<Canvas> getCanvases() {
		return canvases;
	}

	public void setCanvases(ArrayList<Canvas> canvases) {
		this.canvases = canvases;
	}

	public int getCurrentCanvasId() {
		return currentCanvasId;
	}

	public void setCurrentCanvasId(int currentCanvasId) throws IllegalArgumentException {
		if (currentCanvasId < this.getCanvases().size() || currentCanvasId > this.getCanvasIdCount()) {
			throw new IllegalArgumentException();
		}
		this.currentCanvasId = currentCanvasId;
	}

	public int getCanvasIdCount() {
		return canvasIdCount;
	}

	public void setCanvasIdCount(int canvasIdCount) throws IllegalArgumentException {
		if (canvasIdCount < 0) {
			throw new IllegalArgumentException();
		}
		this.canvasIdCount = canvasIdCount;
	}

	public double getCanvasDefaultSizeX() {
		return canvasDefaultSizeX;
	}

	public void setCanvasDefaultSizeX(double canvasDefaultSizeX) throws IllegalArgumentException {
		if (canvasDefaultSizeX < 0) {
			throw new IllegalArgumentException();
		}
		this.canvasDefaultSizeX = canvasDefaultSizeX;
	}

	public double getCanvasDefaultSizeY() {
		return canvasDefaultSizeY;
	}

	public void setCanvasDefaultSizeY(double canvasDefaultSizeY) throws IllegalArgumentException {
		if (canvasDefaultSizeY < 0) {
			throw new IllegalArgumentException();
		}
		this.canvasDefaultSizeY = canvasDefaultSizeY;
	}

	public char getCanvasDefaultBackground() {
		return canvasDefaultBackground;
	}

	public void setCanvasDefaultBackground(char canvasDefaultBackground) {
		this.canvasDefaultBackground = canvasDefaultBackground;
	}

	public boolean isCanvasDefaultGrid() {
		return canvasDefaultGrid;
	}

	public void setCanvasDefaultGrid(boolean canvasDefaultGrid) {
		this.canvasDefaultGrid = canvasDefaultGrid;
	}

	public boolean isCanvasDefaultBorder() {
		return canvasDefaultBorder;
	}

	public void setCanvasDefaultBorder(boolean canvasDefaultBorder) {
		this.canvasDefaultBorder = canvasDefaultBorder;
	}

	public void addCanvas(double sizeX, double sizeY, char defaultBackground, boolean grid, boolean border, int id) {
		if (sizeX < 0) {
			throw new IllegalArgumentException();
		}
		if (sizeY < 0) {
			throw new IllegalArgumentException();
		}
		this.getCanvases().add(new Canvas(sizeX, sizeY,defaultBackground, grid, border, id));
		this.canvasIdCount++;
		this.currentCanvasId = this.getCanvasIdCount();
	}

	public Canvas getCurrentcanvas() {
		for(Canvas canvas : this.getCanvases()) {
			if(canvas.getId() == this.getCurrentCanvasId()) {
				return canvas;
			}
		}
		throw new IllegalArgumentException();
	}

	public Canvas getCanvasWithId(int id) {
		if (hasCanvasWithId(id)) {
			for(Canvas canvas : this.getCanvases()) {
				if(canvas.getId() == id) {
					return canvas;
				}
			}
		}
		throw new IllegalArgumentException();
	}

	public boolean hasCanvasWithId(int id) {
		for(Canvas canvas : this.getCanvases()) {
			if(canvas.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public String listCanvases() {
		String str;
		if (this.getCanvases().size() == 0) {
			return "There are no canvases in this view";
		} else {
			str = "List of canvases for this view ";
			for (Canvas canvas: this.getCanvases()) {
				str += "\n\t" + canvas.toString();
			}
			return str;
		}
	}

	@Override
	public String toString() {
		return "View | Canvases count: " + this.getCanvases().size();
	}
}
