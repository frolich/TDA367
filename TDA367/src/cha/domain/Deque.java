
package cha.domain;
import cha.domain.Categories.Category;

public class Deque {

	static String [] words = {"fotboll", };
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","�","�","�"};
	static String[] bodyParts = {"Panna", "Axel", "Kn�", "Hand", "Rumpa", "Armb�ge", "Fot", "Mage", "Haka", "Vad", "L�r"};
	static String[][] categories = {{"Vilka �r sporter utan boll?", "segling", "judo", "fotboll", "l�ngdhopp", "h�stpolo", "br�nnboll", "rodd", "basket", "golf", "h�jdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka �r aktiva sexIT medlemmar?", "rawa", "frid�n", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};

	//ev ta bort den h�r.
	static Card getCard(Category c/*, int bet*/){
		Card card1 = new Card(c);
		return card1;
	}
}

