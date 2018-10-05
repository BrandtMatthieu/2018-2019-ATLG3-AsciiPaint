package esi.atl.g44422.model;

public class Pixel {
	private char value;

	public Pixel(char value) {
		this.setValue(value);
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getValue() + "";
	}
}
