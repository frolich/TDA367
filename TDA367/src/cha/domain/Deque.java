//fnns det et l�ttare/snabbare s�tt att f� in alla ord i en array el dyl?
//i konstruktorn, kommer jag att beh�va l�gga in en String[]???
//Kan fixa start gerjejen och kolla-�r n�gon vunnit.
//fixa currentCard och get NextCard i startmission. GJORT. Om korten �r slut - ....?
//i textpanel 
package cha.domain;
import cha.domain.Categories.Category;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class Deque{

	public ArrayList<Card> cards = new ArrayList<Card>();

	static String [] wordsss = {
		"fotboll", "gorilla", "paraply", "balkong", "garderob", "isbj�rn", "professor", "toalett", "armband", "prinsessa",
		"bokstav", "blandad", "borstar", "handlar", "maskiner", "dr�mmar", "skv�tta", "plansch", "trollar", "kortlek",
		"snorkel", "grannar", "springa", "rulator", "givmild", "mildare", "spackel", "prickig", "trummor", "strumpa",
		"trumpet", "slumpen", "�lskare", "sk�nker", "k�nslig", "domaren", "senaste", "fl�skig", "bladlus", "kn�cker"};
	static ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsss));
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","�","�","�"};
	static String[] bodyParts =  {"Panna", "Axel", "Kn�", "Hand", "Rumpa", "Armb�ge", "Fot", "Mage", "Haka", "Vad", "L�r"};
	static String[][] sameClasses = {
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Tom fr�ga", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "r�tt", "fel", "fel", "fel", "fel","fel", "fel"},
		{"Vilka �r typiskt svartvita?", "zebra", "skunk", "dalmatin", "panda", "myrornas krig", "streckkoder", "schackbr�de", "oreos", "kaja", "panter", "kobra", "skorpion","lemurell", "elefant"},
		{"Vilka �r sporter utan boll?","segling", "rally", "speedway", "h�jdhopp", "judo", "l�ngdhopp", "rodd", "h�stpolo", "br�nnboll", "basket", "golf", "tennis", "badminton", "fotboll"},
		{"Vilka �r d�ggdjur?", "delfin", "elefant", "bl�val", "s�l", "h�st", "ko", "isbj�rn", "nosh�rning", "pingvin", "Struts", "krokodil", "sk�ldpadda","bl�mes", "lax"},
		{"Vilka djur spederar en stor del av sin tid i vatten?", "delfin", "bl�val", "s�l", "isbj�rn", "pingvin", "krokodil", "sk�ldpadda", "lax", "elefant", "h�st", "ko", "nosh�rning","struts", "bl�mes"},
		{"Vilka har en f�rg i sitt namn?", "bl�mes", "vithaj", "bl�sippa", "vitsippa", "gullviva", "murgr�na", "brunbj�rn", "brunkulla", "timotej", "lax�ring", "fj�llr�v", "p�sklilja","ormbunke", "�rla"},
		{"Vilka �r aktiva sexIT medlemmar?", "rawa", "bella", "malla", "sasse", "anno", "krobbe", "henkit", "wiiw", "brook", "e", "kara", "jocke","pewhl", "frid�n"},
		{"Vilka namn b�rjar p� L?","Lisa","Lennart","Love","Linnea","Linus","Loke","Liv","Ludvig","Josef","Jonna","Jens","Johan","Julius","Jimmy"}};
	static ArrayList<String[]> categories= new ArrayList<String[]>(Arrays.asList(sameClasses));

	public Deque() {

	}

	public List<Card> getCards(Category c, int bet){
		if (c == Category.BODYTOBODY){
			return getBodyToBody(bet);
		}
		else if (c == Category.BACKWARDS){
			return getBackwards(bet);
		}
		else if (c==Category.SAMECLASS){
			return getSameClass();
		}
		else if (c==Category.WORDJUMBLE){
			return getWordJumble(bet);
		}
		else{
			throw new IllegalArgumentException("unknown category");
		}
	}

	//Returns a pile of cards from Word Jumble category.
	private List<Card> getWordJumble(int i) {
		List<Card> allCards = new ArrayList<Card>();
		String word = randomWord();
		allCards.add(getJumbleCard(word, i));
		allCards.add(getJumbleCorrectCard(word));
		return allCards;
	}
	private Card getJumbleCard(String word, int bet) {
		while (word.length()<14){
			word= word+Deque.alphabet[randomNumber(alphabet.length)];
		}
		StringBuilder jumbled = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j=0; j<word.length(); j++)
			oldChars.add(new Character(word.charAt(j)));
		while(!oldChars.isEmpty())
		{
			int index = randomNumber(oldChars.size());
			jumbled.append(oldChars.get(index));
			oldChars.remove(index);
		}
		//Deque.words.remove(i); ta bort ordet som anv�nts s� att det inte kommer igen.
		String[] info =new String[]{"Hitta ett ord p� " + bet+ " bokst�ver!\n" +jumbled.toString()};
		return new Card(info);
		
	}
	private Card getJumbleCorrectCard(String word) {
		String[] info =new String[]{"Ett ord som fanns var: "+word};
		return new Card(info);
	}

	//Returns a pile of cards from Same Class category.
	private List<Card> getSameClass() {
		List<Card> allCards = new ArrayList<Card>();
		int i = randomNumber(categories.size());
		allCards.add(getClassMixCard(i));
		allCards.add(getClassQuestionCard(i));
		allCards.add(getClassCorrectCard(i));
		categories.remove(i);
		return allCards;
	}
	private Card getClassMixCard(int i) {
		String[] info =new String[]{(categories.get(i))[1], (categories.get(i))[2],
				(categories.get(i))[3], (categories.get(i))[4], (categories.get(i))[5],
				(categories.get(i))[6], (categories.get(i))[7], (categories.get(i))[8],
				(categories.get(i))[9], (categories.get(i))[10], (categories.get(i))[11],
				(categories.get(i))[12], (categories.get(i))[13], (categories.get(i))[14]};
		jumbleWords(info);
		return new Card(info);
	}
	private void jumbleWords(String[] A) {
		Random rand = new Random(System.currentTimeMillis());
		String temp;
		for (int i = 0; i < A.length; i++) {
			int idx = rand.nextInt(A.length);
			temp = A[idx];
			A[idx] = A[i];
			A[i] = temp;
		}
	} 
	private Card getClassQuestionCard(int i) {
		String[] info =new String[]{(categories.get(i))[0]};
		return new Card(info);
	}
	private Card getClassCorrectCard(int i) {
		String[] info =new String[]{(categories.get(i))[1], (categories.get(i))[2],
				(categories.get(i))[3], (categories.get(i))[4], (categories.get(i))[5],
				(categories.get(i))[6], (categories.get(i))[7], (categories.get(i))[8]};
		return new Card(info);
	}

	//Returns a pile of cards from Backwards category.
	private List<Card> getBackwards(int bet) {
		List<Card> allCards = new ArrayList<Card>();
		for (int j = 0; j < bet; j++){
			String word = randomWord();
			allCards.add(getBackwardsCard(word));
			allCards.add(new Card(new String[] {"R�tt svar �r: "+word}));
		}
		return allCards;
	}
	private Card getBackwardsCard(String word) {
		StringBuilder backwards = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j=0; j<word.length(); j++)
			oldChars.add(new Character(word.charAt(j)));
		Collections.reverse(oldChars);
		for (Character c : oldChars){
			backwards.append(c);
		}
		String[] info =new String[]{"Vad blir ordet bakl�nges?\n" +backwards.toString()};
		return new Card(info);
	}

	//Returns a pile of cards from Body To Body category.
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
		String[] info =new String[]{ temp + " mot " + temp1};
		//Create and add the current body parts as a card
		return new Card(info);
	}

	private int randomNumber(int i) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
	}
	private String randomWord() {
		int i=randomNumber(Deque.words.size());
		String word=(String) words.get(i);
		words.remove(i);
		return word;
	}
}
