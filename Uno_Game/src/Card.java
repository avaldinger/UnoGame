

public class Card {

	
	int value;
	Color color;

	public Card(Color color, int value) {
		 this.value = value;
		 this.color = color;
		
	};

	@Override
	public String toString() {
		return this.color + ": " + this.value;
	}

}
