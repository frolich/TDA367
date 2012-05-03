
package cha.domain;
import cha.domain.Categories.Category;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class Deque{

	public ArrayList<Card> cards = new ArrayList<Card>();

	static String [] words = {"fotboll", "gorilla", "paraply", "balkong", "garderob", "isbj�rn", "professor", "toalett", "armband", "prinsessa"};
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","�","�","�"};
	static String[] bodyParts = {"Panna", "Axel", "Kn�", "Hand", "Rumpa", "Armb�ge", "Fot", "Mage", "Haka", "Vad", "L�r"};
	static String[][] categories = {{"Vilka �r sporter utan boll?", "segling", "judo", "fotboll", "l�ngdhopp", "h�stpolo", "br�nnboll", "rodd", "basket", "golf", "h�jdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka �r aktiva sexIT medlemmar?", "rawa", "frid�n", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};

	public List<Card> getCards(Category c, int bet){
		if (c==Category.BODYTOBODY){
			return getBodyToBody(bet);
		}else{
			throw new IllegalArgumentException("unknown category");
		}
		//Card.bodyToBody();
		/*else if (c==Category.BACKWARDS)
			backwards();
		else if (c==Category.SAMECLASS)
			sameClass();
		else if (c==Category.WORDJUMBLE)
			wordJumble();

		List<Card> cards = new ArrayList<Card>();
		for (int j=1; j==i; j++){
			Card card1 = new Card(c, bet);
			cards.add(card1);
		}
		return cards;*/
	}

	
	private List<Card> getBodyToBody(int bet) {
		List<Card> allCards = new ArrayList<Card>();
		for (int j = 0; j < bet; j++){
			allCards.add(getBodyCard());
		}
		return allCards;
	}
	
		private Card getBodyCard() {
			String temp= bodyParts[randomNumber(bodyParts.length)];
			String temp1= bodyParts[randomNumber(bodyParts.length)];
			String a1= temp + " mot " + temp1;
			//Create and add the current body parts as a card
			return new Card(a1);
	}
		private int randomNumber(int i){
			Random randomGenerator = new Random();
			return randomGenerator.nextInt(i);
		}
		public Deque(){

		}


	}

