package esi.atl.g44422.model;

import java.util.ArrayList;

public class Viewport {
	private ArrayList<Canvas> canvases;
	private int canvasIdCount;
	private int currentCanvasId;
	private int canvasDefaultSizeX;
	private int canvasDefaultSizeY;
	private char canvasDefaultBackground;
	private boolean canvasDefaultGrid;
	private boolean canvasDefaultBorder;

	public Viewport() throws IllegalAccessException {
		this.setCanvases(new ArrayList<Canvas>());
		this.setCanvasIdCount(0);
		this.setCurrentCanvasId(0);
		this.setCanvasDefaultSizeX(81);
		this.setCanvasDefaultSizeY(51);
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

	public void setCurrentCanvasId(int currentCanvasId) throws IllegalAccessException {
		if(currentCanvasId < this.getCanvases().size() || currentCanvasId > this.getCanvasIdCount()) {
			throw new IllegalAccessException();
		}
		this.currentCanvasId = currentCanvasId;
	}

	public int getCanvasIdCount() {
		return canvasIdCount;
	}

	public void setCanvasIdCount(int canvasIdCount) throws IllegalAccessException {
		if(canvasIdCount < 0) {
			throw new IllegalAccessException();
		}
		this.canvasIdCount = canvasIdCount;
	}

	public int getCanvasDefaultSizeX() {
		return canvasDefaultSizeX;
	}

	public void setCanvasDefaultSizeX(int canvasDefaultSizeX) throws IllegalAccessException {
		if(canvasDefaultSizeX < 0) {
			throw new IllegalAccessException();
		}
		this.canvasDefaultSizeX = canvasDefaultSizeX;
	}

	public int getCanvasDefaultSizeY() {
		return canvasDefaultSizeY;
	}

	public void setCanvasDefaultSizeY(int canvasDefaultSizeY) throws IllegalAccessException{
		if(canvasDefaultSizeY < 0) {
			throw new IllegalAccessException();
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
}
