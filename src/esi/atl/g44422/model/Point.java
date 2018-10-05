package esi.atl.g44422.model;

public class Point extends Shape {
	private int x;
	private int y;

	public Point(int x, int y, Point center, char fill, char outline, int id) {
		super(center, ShapeType.Point, fill, outline, id);
	}

	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move(int dx, int dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dx);
	}

	@Override
	public String toString() {
		if(this instanceof Shape) {
			return super.toString();
		} else {
			return "(" + this.getX() + ", " + this.getY() + ")";
		}
	}
}
