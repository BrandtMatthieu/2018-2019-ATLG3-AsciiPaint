package esi.atl.g44422.model;

/**
 * Represents a pixel in the model
 */
public class Pixel {
	private char value;

	/**
	 * Creates a new pixel
	 * @param value the value of this pixel
	 */
	public Pixel(char value) {
		this.setValue(value);
	}

	/**
	 * Returns the value of this pixel
	 * @return
	 */
	public char getValue() {
		return value;
	}

	/**
	 * Sets the value of this pixel
	 * @param value
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * Returns a string representing the pixel
	 * @return
	 */
	@Override
	public String toString() {
		return this.getValue() + "";
	}
}
