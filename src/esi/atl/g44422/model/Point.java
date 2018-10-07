package esi.atl.g44422.model;

public class Point extends Shape {
	private double x;
	private double y;

	public Point(double x, double y, Point center, ShapeType type, char fill, char outline, int id) {
		super(center, type, fill, outline, id);
	}

	public Point(double x, double y) {
		super();
		this.setX(x);
		this.setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		if(this.getCenter() != null) { //shape
			return super.toString();
		} else { //center
			return "(" + this.getX() + ", " + this.getY() + ")";
		}
	}

	@Override
	public boolean isInside(Point point) {
		return point.getX() - this.getCenter().getX() <= 0.5 && point.getY() - this.getCenter().getY() <= 0.5;
	}

	@Override
	public void move(double dx, double dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}
}
