package Task2_Deck;

import java.util.Comparator;

import Task1_Cards.Cards.CardRank;

public class Card implements Comparator<Card> {
	private CardColor color;
	private CardRank rang;
	private CardSuits cardSuits;
	private Object object;
	public Card() {
			
	}
	
	public Card(CardColor color, CardRank  rang, CardSuits cardSuits) {
		this.setColor(color);
		this.setRang(rang);
	}
	
	public CardColor getColor() {
		return color;
	}

	public void setColor(CardColor color) {
		this.color = color;
	}

	public CardRank  getRang() {
		return rang;
	}

	public void setRang(CardRank  rang) {
		this.rang = rang;
	}

	public CardSuits getCardSuits() {
		return cardSuits;
	}

	public void setCardSuits(CardSuits cardSuits) {
		this.cardSuits = cardSuits;
	}
	
	@Override
	public String toString() {
		return this.getRang() + " of " + this.getColor();
	}
	public enum CardSuits {
		Clubs,
		Diamonds,
		Hearts,
		Spades,
	}

	public enum CardColor {
		Black,
		Red
	}
	public enum CardRanks {
		Two(2), 
		Three(3),
		Four(4),
		Five(5),
		Six(6),
		Seven(7),
		Eight(8),
		Nine(9),
		Ten(10),
		Jack(10),
		Queen(10),
		King(10),
		Ace(11);
		
		private final int value;
		
		private CardRanks(int value) {
			this.value = value;
		}
	}

	@Override
	public int compare(Card card1, Card card2) {
		int rankCompare = card1.getRang().compareTo(card2.getRang());
		return rankCompare;
	}
	
}
