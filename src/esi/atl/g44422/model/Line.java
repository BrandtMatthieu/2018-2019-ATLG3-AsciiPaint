package esi.atl.g44422.model;

/**
 * Represents a line in the Model
 */
public class Line extends Shape {
	private Point p1;
	private Point p2;

	/**
	 * Creates a new line
	 * @param p1 the first point of the line
	 * @param p2 the second point of the line
	 * @param type the type of the shape (line)
	 * @param fill the fill of the line
	 * @param outline the outline of the line
	 * @param id the id of the line
	 */
	public Line(Point p1, Point p2, ShapeType type, char fill, char outline, int id) {
		super(null, ShapeType.Line, fill, outline, id);
		this.setP1(p1);
		this.setP2(p2);
		this.calculateCenter();
	}

	/**
	 * Returns the first point of the line
	 * @return the first point of the line
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * Sets the first point of the line
	 * @param p1 the first point of the line
	 */
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	/**
	 * Returns the second point of the line
	 * @return the second point of the line
	 */
	public Point getP2() {
		return p2;
	}

	/**
	 * Sets the second point of the line
	 * @param p2 the second point of the line
	 */
	public void setP2(Point p2) {
		this.p2 = p2;
	}

	/**
	 * Calculates the center of the line based on it's points
	 */
	public void calculateCenter() {
		this.setCenter(
			new Point(
				((this.getP1().getX() + this.getP2().getX()) / 2),
				((this.getP1().getY() + this.getP2().getY()) / 2)
			)
		);
	}

	/**
	 * Returns a string describing the line
	 * @return a string describing the line
	 */
	@Override
	public String toString() {
		return "P1: " + this.getP1().toString() + " P2: " + this.getP2().toString() + super.toString();
	}

	/**
	 * Checks of a point is inside the line
	 * @param point the point
	 * @return if the point is inside the line
	 */
	@Override
	public boolean isInside(Point point) {
		final double m = ((this.getP1().getY() - this.getP2().getY()) / (this.getP1().getX() - this.getP2().getX()));
		final double p = this.getP1().getY() - (m * this.getP1().getX());
		return (Math.abs(point.getY() - (m * point.getX()) - p) / Math.sqrt(1 + Math.pow(m, 2))) <= 0.5;
	}

	/**
	 * Moves the line
	 * @param dx the horizontal move of the line
	 * @param dy the vertical move of the line
	 */
	@Override
	public void move(double dx, double dy) {
		this.getP1().move(dx, dy);
		this.getP2().move(dx, dy);
		this.calculateCenter();
	}
}
