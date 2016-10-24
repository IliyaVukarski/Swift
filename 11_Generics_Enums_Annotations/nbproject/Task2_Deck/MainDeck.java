package Task2_Deck;

import java.awt.Color;
import java.awt.font.NumericShaper.Range;

import Task1_Cards.Cards.CardRank;
import Task2_Deck.Card.CardColor;

public class MainDeck {
	public static void main(String[] args) {
		Card card1 = new Card();
		card1.setColor(CardColor.Black);
		card1.setRang(CardRank.Five);
		System.out.println(card1);
		
		Card card2 = new Card();
		card2.setColor(CardColor.Red);
		card2.setRang(CardRank.Two);
		System.out.println(card2);
		System.out.println(card1.getRang().compareTo(card2.getRang()));
	}
}	
