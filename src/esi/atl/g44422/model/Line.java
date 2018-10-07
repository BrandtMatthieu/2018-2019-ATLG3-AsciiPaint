package esi.atl.g44422.model;

public class Line extends Shape {
	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2, ShapeType type, char fill, char outline, int id) {
		super(null, ShapeType.Line, fill, outline, id);
		super.setCenter(this.calculateCenter(p1, p2));
		this.setP1(p1);
		this.setP2(p2);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point calculateCenter(Point p1, Point p2) {
		return new Point((p1.getX() + p2.getX()) / 2.0, (p1.getY() + p2.getY()) / 2.0);
	}

	@Override
	public String toString() {
		return "P1: " + this.getP1().toString() + " P2: " + this.getP2().toString() + super.toString();
	}

	@Override
	public boolean isInside(Point point) {
		final double m = ((this.getP1().getY() - this.getP2().getY()) / (this.getP1().getX() - this.getP2().getX()));
		final double p = this.getP1().getY() - (m * this.getP1().getX());
		return (Math.abs(point.getY() - (m * point.getX()) - p) / Math.sqrt(1 + Math.pow(m, 2))) <= 0.5;
	}
}
