package esi.atl.g44422.model;

public class Rectangle extends Shape{
	private int width;
	private int height;

	public Rectangle(Point center, ShapeType type, char fill, char outline, int id) throws IllegalArgumentException {
		super(center, null, fill, outline, id);
		if(type == ShapeType.Rectangle) {
			super.setType(ShapeType.Rectangle);
			this.setWidth(width);
			this.setHeight(height);
		} else if(type == ShapeType.Square) {
			this.setWidth(width);
			this.setHeight(width);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) throws IllegalArgumentException{
		if(width < 0) {
			throw new IllegalArgumentException();
		}
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) throws IllegalArgumentException {
		if(height < 0) {
			throw new IllegalArgumentException();
		}
		this.height = height;
	}

	@Override
	public String toString() {
		String str = this.getType().toString() + " |";
		if(this.getType() == ShapeType.Rectangle) {
			str += " Width: " + this.getWidth() + " Height: " + this.getHeight();
		} else if(this.getType() == ShapeType.Square) {
			str += " Size: " + this.getWidth();
		}
		str += super.toString();
		return str;
	}
}
