package esi.atl.g44422.model;

/**
 * Represents an ellipse or a circle on the Model
 */
public class Ellipse extends Shape {
	private double radiusX;
	private double radiusY;
// --> sous-classe Circle
	/**
	 * Creates a new ellipse or circle
	 *
	 * @param radiusX the horizontal radius of the ellipse/circle
	 * @param radiusY the vertical radius of the ellipse/circle
	 * @param center  the center of the ellipse/circle
	 * @param type    the type of the shape (ellipse/circle)
	 * @param fill    the fill of the ellipse/circle
	 * @param outline the outline of the ellipse/circle
	 * @param id      the id of the ellipse/circle
	 * @throws IllegalArgumentException if any provided arguments is wrong
	 */
	public Ellipse(double radiusX, double radiusY, Point center, ShapeType type, char fill, char outline, int id)
			throws IllegalArgumentException {
		super(center, null, fill, outline, id);
		if (type == ShapeType.Ellipse) {
			super.setType(ShapeType.Ellipse);
			this.setRadiusX(radiusX);
			this.setRadiusY(radiusY);
		} else if (type == ShapeType.Circle) {
			super.setType(ShapeType.Circle);
			this.setRadiusX(radiusX);
			this.setRadiusY(radiusY);
		}
	}

	/**
	 * Returns the horizontal radius of the ellipse/circle
	 *
	 * @return the horizontal radius of the ellipse/circle
	 */
	private double getRadiusX() {
		return radiusX;
	}

	/**
	 * Sets the horizontal radius of the ellipse/circle
	 *
	 * @param radiusX the horizontal radius of the ellipse/circle
	 * @throws IllegalArgumentException if the radius is negative
	 */
	private void setRadiusX(double radiusX) throws IllegalArgumentException {
		if (radiusX < 0.0) {
			throw new IllegalArgumentException();
		}
		this.radiusX = radiusX;
	}

	/**
	 * Returns the vertical radius of the ellipse/circle
	 *
	 * @return the vertical radius of the ellipse/circle
	 */
	private double getRadiusY() {
		return radiusY;
	}

	/**
	 * Sets the vertical radius of the ellipse/circle
	 *
	 * @param radiusY the vertical radius of the ellipse/circle
	 * @throws IllegalArgumentException if the radius is negative
	 */
	private void setRadiusY(double radiusY) throws IllegalArgumentException {
		if (radiusY < 0.0) {
			throw new IllegalArgumentException();
		}
		this.radiusY = radiusY;
	}

	/**
	 * A string representing the shape
	 *
	 * @return a string representing the shape
	 */
	@Override
	public String toString() {
		String str = this.getType().toString() + " |";
		if (this.getType() == ShapeType.Ellipse) {
			str += " Radius X: " + this.getRadiusX() + " Radius Y: " + this.getRadiusY();
		} else if (this.getType() == ShapeType.Circle) {
			str += " Radius: " + this.getRadiusX();
		}
		str += super.toString();
		return str;
	}

	/**
	 * Checks if a point is inside the ellipse/circle
	 *
	 * @param p the point
	 * @return if the point is inside the ellipse/circle
	 */
	@Override
	public boolean isInside(Point p) {
		return (Math.pow((p.getX() - this.getCenter().getX()), 2) * Math.pow(this.getRadiusX(), 2))
				+ ((Math.pow((p.getY() - this.getCenter().getY()), 2)) * (Math.pow(this.getRadiusY(), 2))) <= (Math
				.pow(this.getRadiusX(), 2) * Math.pow(this.getRadiusY(), 2));
	}
}
