package esi.atl.g44422.model;

public class Ellipse extends Shape{
	private int radiusX;
	private int radiusY;

	public Ellipse(int radiusX, int radiusY, Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
		super(center, null, fill, outline, id);
		if(type == ShapeType.Ellipse) {
			super.setType(ShapeType.Ellipse);
			this.setRadiusX(radiusX);
			this.setRadiusY(radiusY);
		} else {
			super.setType(ShapeType.Circle);
			this.setRadiusX(radiusX);
			this.setRadiusY(radiusY);
		}
	}

	public int getRadiusX() {
		return radiusX;
	}

	public void setRadiusX(int radiusX) throws IllegalArgumentException {
		if(radiusX < 0) {
			throw new IllegalArgumentException();
		}
		this.radiusX = radiusX;
	}

	public int getRadiusY() {
		return radiusY;
	}

	public void setRadiusY(int radiusY) throws IllegalArgumentException {
		if(radiusY < 0) {
			throw new IllegalArgumentException();
		}
		this.radiusY = radiusY;
	}
}
