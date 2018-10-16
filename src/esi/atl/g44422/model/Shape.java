package esi.atl.g44422.model;

/**
 * Represents a shape in the Model
 */
public abstract class Shape {
	private Point center;
	private ShapeType type; // inutile -> déjà dans les classes.
	private char fill;
	private char outline;
	private int id;

	/**
	 * Creates a new shape
	 *
	 * @param center  the center of the shape
	 * @param type    the type of the shape
	 * @param fill    the fill of the shape
	 * @param outline the outline of the shape
	 * @param id      the id of the shape
	 * @throws IllegalArgumentException if one of the parameter is wrong
	 */
	Shape(Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
		this.setCenter(center);
		this.setType(type);
		this.setFill(fill);
		this.setOutline(outline);
		this.setId(id);
	}

	/**
	 * Creates an empty shape
	 */
	Shape() {
	}

	/**
	 * Returns the center of the shape
	 *
	 * @return the center of the shape
	 */
	Point getCenter() {
		return center;
	}

	/**
	 * Sets the center of the shape
	 *
	 * @param center the center of the shape
	 */
	void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * Returns the type of the shape
	 *
	 * @return the type of the shape
	 */
	ShapeType getType() {
		return type;
	}

	/**
	 * Sets the type of the shape
	 *
	 * @param type the type of the shape
	 */
	void setType(ShapeType type) {
		this.type = type;
	}

	/**
	 * Returns the fill of the shape
	 *
	 * @return the fill of the shape
	 */
	public char getFill() {
		return fill;
	}

	/**
	 * Sets the fill of the shape
	 *
	 * @param fill the fill of the shape
	 */
	public void setFill(char fill) {
		this.fill = fill;
	}

	/**
	 * Returns the outline of the shape
	 *
	 * @return the outline of the shape
	 */
	public char getOutline() {
		return outline;
	}

	/**
	 * Sets the outline of the shape
	 *
	 * @param outline the outline of the shape
	 */
	public void setOutline(char outline) {
		this.outline = outline;
	}

	/**
	 * Returns the outline of the shape
	 *
	 * @return the outline of the shape
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the shape
	 *
	 * @param id the id of the shape
	 * @throws IllegalArgumentException if the id is negative
	 */
	public void setId(int id) throws IllegalArgumentException {
		if (id < 0) {
			throw new IllegalArgumentException(); // message !
		}
		this.id = id;
	}

	/**
	 * Returns a string representing the shape
	 *
	 * @return a string representing the shape
	 */
	@Override
	public String toString() {
		return " Center: " + this.getCenter().toString() + " Fill: " + this.getFill() + " Outline: " + this.getOutline()
				+ " Id: " + this.getId();
	}

	/**
	 * Checks if a point is inside the shape
	 *
	 * @param p the point
	 * @return if the point is inside the shape
	 */
	public boolean isInside(Point p) {
		return true;
	}

	/**
	 * Moves the shape
	 *
	 * @param dx the horizontal move of the shape
	 * @param dy the vertical move of the shape
	 */
	public void move(double dx, double dy) {
		this.getCenter().move(dx, dy);
	}
}
