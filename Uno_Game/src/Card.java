

public class Card {

	
	private int value;
	private Color color;

	public Card(Color color, int value) {
		 this.value = value;
		 this.color = color;
		
	};
	
	public Card() {};

	@Override
	public String toString() {
		return this.color + ": " + this.value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
