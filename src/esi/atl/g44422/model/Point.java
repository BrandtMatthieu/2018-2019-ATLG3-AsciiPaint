package esi.atl.g44422.model;

/**
 * Represents a point in the Model
 */
public class Point extends Shape {
	private double x;
	private double y;

	/**
	 * Creates a new point
	 *
	 * @param x       the horizontal position of the point
	 * @param y       the vertical position of the point
	 * @param center  the center of the point
	 * @param type    the type of the shape (point)
	 * @param fill    the fill of the point
	 * @param outline the outline of the point
	 * @param id      the id of the point
	 */
	public Point(double x, double y, Point center, ShapeType type, char fill, char outline, int id) {
		super(center, type, fill, outline, id);
	}

	/**
	 * Creates a new point (center)
	 *
	 * @param x the horizontal position of the point(center)
	 * @param y the vertical position of the point (center)
	 */
	public Point(double x, double y) {
		super();
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Returns the horizontal position of the point
	 *
	 * @return the horizontal position of the point
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the horizontal position of the point
	 *
	 * @param x the horizontal position of the point
	 */
	private void setX(double x) {
		this.x = x;
	}

	/**
	 * Returns the vertical position of the point
	 *
	 * @return the vertical position of the point
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the vertical position of the point
	 *
	 * @param y the vertical position of the point
	 */
	private void setY(double y) {
		this.y = y;
	}

	/**
	 * Returns a string representing the point
	 *
	 * @return a string representing the point
	 */
	@Override
	public String toString() {
		if (this.getCenter() != null) { // shape
			return super.toString();
		} else { // center
			return "(" + this.getX() + ", " + this.getY() + ")";
		}
	}

	/**
	 * Checks if a point is inside the point
	 *
	 * @param point the point
	 * @return if the point is inside the point
	 */
	@Override
	public boolean isInside(Point point) {
		return point.getX() - this.getCenter().getX() <= 0.5 && point.getY() - this.getCenter().getY() <= 0.5;
	}

	/**
	 * Moves the point
	 *
	 * @param dx the horizontal move of the point
	 * @param dy the vertical move of the point
	 */
	@Override
	public void move(double dx, double dy) {
		if (this.getCenter() != null) { // shape
			super.move(dx, dy);
		} else { // center
			this.setX(this.getX() + dx);
			this.setY(this.getY() + dy);
		}
	}
}
