public class Deck {
	private String suit;
	private int value;
	// private int value2;
	private int[] deck;

	public Deck(String suit, int value) {
		for (int i=0; i<13; i++) {
			int x = i;
			if (i<10) {
				Card card = new Card("Diamonds", value);
			} else {

			Card card = new Card("Diamonds", i);
				System.out.println(i + "of" + suit);
			}
		}
		
	}
	
}
