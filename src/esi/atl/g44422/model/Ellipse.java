package esi.atl.g44422.model;

public class Ellipse extends Shape {
	private double radiusX;
	private double radiusY;

	public Ellipse(double radiusX, double radiusY, Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
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

	public double getRadiusX() {
		return radiusX;
	}

	public void setRadiusX(double radiusX) throws IllegalArgumentException {
		if (radiusX < 0.0) {
			throw new IllegalArgumentException();
		}
		this.radiusX = radiusX;
	}

	public double getRadiusY() {
		return radiusY;
	}

	public void setRadiusY(double radiusY) throws IllegalArgumentException {
		if (radiusY < 0.0) {
			throw new IllegalArgumentException();
		}
		this.radiusY = radiusY;
	}

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

	@Override
	public boolean isInside(Point p) {
		return (Math.pow((p.getX() - this.getCenter().getX()), 2) * Math.pow(this.getRadiusX(), 2)) + ((Math.pow((p.getY() - this.getCenter().getY()), 2)) * (Math.pow(this.getRadiusY(), 2)))
				<= (Math.pow(this.getRadiusX(), 2) * Math.pow(this.getRadiusY(), 2));
	}
}
