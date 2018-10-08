package esi.atl.g44422.model;

import java.util.ArrayList;

/**
 * Represents a viewport in the Model
 */
public class Viewport {
	private ArrayList<Canvas> canvases;
	private int canvasIdCount;
	private int currentCanvasId;
	private double canvasDefaultSizeX;
	private double canvasDefaultSizeY;
	private char canvasDefaultBackground;
	private boolean canvasDefaultGrid;
	private boolean canvasDefaultBorder;

	/**
	 * Creates a new viewport
	 * @throws IllegalArgumentException if one of the parameters is wrong
	 */
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

	/**
	 * Returns the canvas of the viewport
	 * @return the canvas of the viewport
	 */
	private ArrayList<Canvas> getCanvases() {
		return canvases;
	}

	/**
	 * Sets the canvas of the viewport
	 * @param canvases the canvas of the viewport
	 */
	private void setCanvases(ArrayList<Canvas> canvases) {
		this.canvases = canvases;
	}

	/**
	 * Returns the id of the current canvas
	 * @return the id of the current canvas
	 */
	public int getCurrentCanvasId() {
		return currentCanvasId;
	}

	/**
	 * Sets the id of the current canvas
	 * @param currentCanvasId the id of the current canvas
	 * @throws IllegalArgumentException if the id is negative
	 */
	public void setCurrentCanvasId(int currentCanvasId) throws IllegalArgumentException {
		if (currentCanvasId < this.getCanvases().size() || currentCanvasId > this.getCanvasIdCount()) {
			throw new IllegalArgumentException();
		}
		this.currentCanvasId = currentCanvasId;
	}

	/**
	 * Returns the biggest canvas id
	 * @return the biggest canvas id
	 */
	private int getCanvasIdCount() {
		return canvasIdCount;
	}

	/**
	 * Sets the biggest canvas id
	 * @param canvasIdCount the biggest canvas id
	 * @throws IllegalArgumentException if the id is wrong
	 */
	private void setCanvasIdCount(int canvasIdCount) throws IllegalArgumentException {
		if (canvasIdCount < 0) {
			throw new IllegalArgumentException();
		}
		this.canvasIdCount = canvasIdCount;
	}

	/**
	 * Returns the default width of the canvas
	 * @return the default width of the canvas
	 */
	public double getCanvasDefaultSizeX() {
		return canvasDefaultSizeX;
	}

	/**
	 * Sets the default width of the canvas
	 * @param canvasDefaultSizeX the default width of the canvas
	 * @throws IllegalArgumentException if the width is negative
	 */
	private void setCanvasDefaultSizeX(double canvasDefaultSizeX) throws IllegalArgumentException {
		if (canvasDefaultSizeX < 0) {
			throw new IllegalArgumentException();
		}
		this.canvasDefaultSizeX = canvasDefaultSizeX;
	}

	/**
	 * Returns the default height of the canvas
	 * @return the default height of the canvas
	 */
	public double getCanvasDefaultSizeY() {
		return canvasDefaultSizeY;
	}

	/**
	 * Sets the default height of the canvas
	 * @param canvasDefaultSizeY the default height of the canvas
	 * @throws IllegalArgumentException if the height is negative
	 */
	private void setCanvasDefaultSizeY(double canvasDefaultSizeY) throws IllegalArgumentException {
		if (canvasDefaultSizeY < 0) {
			throw new IllegalArgumentException();
		}
		this.canvasDefaultSizeY = canvasDefaultSizeY;
	}

	/**
	 * Returns the default background of the canvas
	 * @return the default background of the canvas
	 */
	public char getCanvasDefaultBackground() {
		return canvasDefaultBackground;
	}

	/**
	 * Sets the default background of the canvas
	 * @param canvasDefaultBackground the default background of the canvas
	 */
	private void setCanvasDefaultBackground(char canvasDefaultBackground) {
		this.canvasDefaultBackground = canvasDefaultBackground;
	}

	/**
	 * Returns if the canvas has a grid
	 * @return if the canvas has a grid
	 */
	public boolean isCanvasDefaultGrid() {
		return canvasDefaultGrid;
	}

	/**
	 * Sets if the canvas has a grid
	 * @param canvasDefaultGrid if the canvas has a grid
	 */
	private void setCanvasDefaultGrid(boolean canvasDefaultGrid) {
		this.canvasDefaultGrid = canvasDefaultGrid;
	}

	/**
	 * Returns if the canvas has a border
	 * @return if the canvas has a border
	 */
	public boolean isCanvasDefaultBorder() {
		return canvasDefaultBorder;
	}

	/**
	 * Sets if the canvas has a border
	 * @param canvasDefaultBorder if the canvas has a border
	 */
	private void setCanvasDefaultBorder(boolean canvasDefaultBorder) {
		this.canvasDefaultBorder = canvasDefaultBorder;
	}

	/**
	 * Adds a new canvas in the viewport
	 * @param sizeX the width of the canvas
	 * @param sizeY the height of the canvas
	 * @param defaultBackground the background of the canvas
	 * @param grid if the canvas has a grid
	 * @param border if the canvas has a border
	 * @param id the id of the canvas
	 */
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

	/**
	 * Returns the current canvas
	 * @return the current canvas
	 */
	public Canvas getCurrentCanvas() {
		for(Canvas canvas : this.getCanvases()) {
			if(canvas.getId() == this.getCurrentCanvasId()) {
				return canvas;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Returns the canvas withe the provided id
	 * @param id the id of the canvas
	 * @return the canvas withe the provided id
	 */
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

	/**
	 * Returns if a canvas has the provided id
	 * @param id the id of the canvas
	 * @return if a canvas has the provided id
	 */
	private boolean hasCanvasWithId(int id) {
		for(Canvas canvas : this.getCanvases()) {
			if(canvas.getId() == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a list of all the canvases
	 * @return a list of all the canvases
	 */
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

	/**
	 * Returns a string corresponding to the viewport
	 * @return a string corresponding to the viewport
	 */
	@Override
	public String toString() {
		return "View | Canvases count: " + this.getCanvases().size();
	}
}
