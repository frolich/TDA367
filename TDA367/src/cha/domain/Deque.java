
package cha.domain;
import cha.domain.Categories.Category;
import java.util.List;

import java.util.ArrayList;

public class Deque{
	
	public ArrayList<Card> cards = new ArrayList<Card>();

	static String [] words = {"fotboll", "gorilla", "paraply", "balkong", "garderob", "isbj�rn", "professor", "toalett", "armband", "prinsessa"};
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","�","�","�"};
	static String[] bodyParts = {"Panna", "Axel", "Kn�", "Hand", "Rumpa", "Armb�ge", "Fot", "Mage", "Haka", "Vad", "L�r"};
	static String[][] categories = {{"Vilka �r sporter utan boll?", "segling", "judo", "fotboll", "l�ngdhopp", "h�stpolo", "br�nnboll", "rodd", "basket", "golf", "h�jdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka �r aktiva sexIT medlemmar?", "rawa", "frid�n", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};

	static List<Card> getCard(Category c, Bet actualBet){
		if (c==Category.BODYTOBODY)
			Card.bodyToBody();
		else if (c==Category.BACKWARDS)
			backwards();
		else if (c==Category.SAMECLASS)
			sameClass();
		else if (c==Category.WORDJUMBLE)
			wordJumble();

		List<Card> cards = new ArrayList<Card>();
		for (int j=1; j==i; j++){
			Card card1 = new Card(c, actualBet);
			cards.add(card1);
		}
		return cards;
	}
	

}

