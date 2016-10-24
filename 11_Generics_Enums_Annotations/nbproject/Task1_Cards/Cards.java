package Task1_Cards;

public class Cards {
	
	public enum CardSuit {
		Clubs,
		Diamonds,
		Hearts,
		Spades,
	}
	
	public enum CardRank {
		Two, 
		Three,
		Four,
		Five,
		Six,
		Seven,
		Eight,
		Nine,
		Ten,
		Jack,
		Queen,
		King,
		Ace,
	}
	public static void main(String[] args) {
		StringBuilder stringBuilder1 = new StringBuilder();
		for(CardSuit card : CardSuit.values()) {
			stringBuilder1.append(card + ", ");
		}
		stringBuilder1.deleteCharAt(stringBuilder1.length() -2);
		System.out.println(stringBuilder1);
		StringBuilder stringBuilder2 = new StringBuilder();
		for(CardRank cardRank : CardRank.values()) {
			stringBuilder2.append(cardRank + ", ");
		}
		stringBuilder2.deleteCharAt(stringBuilder2.length() -2);
		System.out.println(stringBuilder2);
	}
}
