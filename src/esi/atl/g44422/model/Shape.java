package esi.atl.g44422.model;

public class Shape {
	private Point center;
	private ShapeType type;
	private char fill;
	private char outline;
	private int id;

	public Shape(Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
		this.setCenter(center);
		this.setType(type);
		this.setFill(fill);
		this.setOutline(outline);
		this.setId(id);
	}

	public Shape() {
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public ShapeType getType() {
		return type;
	}

	public void setType(ShapeType type) {
		this.type = type;
	}

	public char getFill() {
		return fill;
	}

	public void setFill(char fill) {
		this.fill = fill;
	}

	public char getOutline() {
		return outline;
	}

	public void setOutline(char outline) {
		this.outline = outline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws IllegalArgumentException {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	@Override
	public String toString() {
		return " Center: " + this.getCenter().toString() + " Fill: " + this.getFill() + " Outline: " + this.getOutline()
				+ " Id: " + this.getId();
	}

	public boolean isInside(Point p) {
		return true;
	}

	public void move(double dx, double dy) {
		this.center.move(dx, dy);
	}
}
