package esi.atl.g44422.model;

/**
 * Represents a rectangle in the Model
 */
public class Rectangle extends Shape {
	private double width;
	private double height;

	/**
	 * Creates a new rectangle
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 * @param center the center of the rectangle
	 * @param type the type of the shape (rectangle)
	 * @param fill the fill of the rectangle
	 * @param outline the outline the rectangle
	 * @param id the id of the rectangle
	 * @throws IllegalArgumentException if one argument is wrong
	 */
	public Rectangle(double width, double height, Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
		super(center, null, fill, outline, id);
		if (type == ShapeType.Rectangle) {
			super.setType(ShapeType.Rectangle);
			this.setWidth(width);
			this.setHeight(height);
		} else if (type == ShapeType.Square) {
			this.setWidth(width);
			this.setHeight(width);
		}
	}

	/**
	 * Returns the width of the rectangle
	 * @return the width of the rectangle
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Sets the width of the rectangle
	 * @param width the width of the rectangle
	 * @throws IllegalArgumentException if the width id negative
	 */
	public void setWidth(double width) throws IllegalArgumentException {
		if (width < 0) {
			throw new IllegalArgumentException();
		}
		this.width = width;
	}

	/**
	 * Returns the height of the rectangle
	 * @return the height of the rectangle
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the height of the rectangle
	 * @param height the height of the rectangle
	 * @throws IllegalArgumentException if the height of the rectangle is negative
	 */
	public void setHeight(double height) throws IllegalArgumentException {
		if (height < 0) {
			throw new IllegalArgumentException();
		}
		this.height = height;
	}

	/**
	 * Returns a string representing the rectangle
	 * @return a string representing the rectangle
	 */
	@Override
	public String toString() {
		String str = this.getType().toString() + " |";
		if (this.getType() == ShapeType.Rectangle) {
			str += " Width: " + this.getWidth() + " Height: " + this.getHeight();
		} else if (this.getType() == ShapeType.Square) {
			str += " Size: " + this.getWidth();
		}
		str += super.toString();
		return str;
	}

	/**
	 * Checks if a point is inside the rectangle
	 * @param point the point
	 * @return if the point is inside the rectangle
	 */
	@Override
	public boolean isInside(Point point) {
		return this.getCenter().getX() - (this.getWidth() / 2) <= point.getX()
				&& point.getX() <= this.getCenter().getX() + (this.getWidth() / 2)
				&& this.getCenter().getY() - (this.getHeight() / 2) <= this.getCenter().getY()
				&& point.getY() <= this.getCenter().getY() + (this.getHeight() / 2);
	}
}
