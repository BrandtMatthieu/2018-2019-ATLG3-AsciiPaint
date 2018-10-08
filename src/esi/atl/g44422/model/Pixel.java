package esi.atl.g44422.model;

/**
 * Represents a pixel in the model
 */
class Pixel {
	private char value;

	/**
	 * Creates a new pixel
	 * 
	 * @param value the value of this pixel
	 */
	public Pixel(char value) {
		this.setValue(value);
	}

	/**
	 * Returns the value of this pixel
	 * 
	 * @return the value of this pixel
	 */
	private char getValue() {
		return value;
	}

	/**
	 * Sets the value of this pixel
	 * 
	 * @param value the value of this pixel
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * Returns a string representing the pixel
	 * 
	 * @return a string representing the pixel
	 */
	@Override
	public String toString() {
		return this.getValue() + "";
	}
}
