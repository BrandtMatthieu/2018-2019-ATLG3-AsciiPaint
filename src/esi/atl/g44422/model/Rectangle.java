package esi.atl.g44422.model;

public class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
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

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) throws IllegalArgumentException {
		if (width < 0) {
			throw new IllegalArgumentException();
		}
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) throws IllegalArgumentException {
		if (height < 0) {
			throw new IllegalArgumentException();
		}
		this.height = height;
	}

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

	@Override
	public boolean isInside(Point point) {
		return this.getCenter().getX() - (this.getWidth() / 2) <= point.getX()
				&& point.getX() <= this.getCenter().getX() + (this.getWidth() / 2)
				&& this.getCenter().getY() - (this.getHeight() / 2) <= this.getCenter().getY()
				&& point.getY() <= this.getCenter().getY() + (this.getHeight() / 2);
	}
}
