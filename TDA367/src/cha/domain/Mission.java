package cha.domain;

import java.awt.List;

import cha.domain.Categories.Category;

public class Mission {
	
	private Card card;
	private final CountDown timer;
	private final Piece piece;
	
	public Mission(Piece piece){
		timer = new CountDown();
		this.piece = piece;
	}
	
	public void startMission(Category c){
		 card = Deque.getCard(c);
		// card.show();
		// timer.start();
	}
	
	/* Malla
	*public void startMission(Category c){
	*	 List<Card> cards = new List;
	*L�gga till kort i en h�g och representera fr�n h�gen
	*	
	*}
	*/
	public void timeOver(){
		//TODO
	}
	
	public void missionDone(boolean completed){
		//TODO
	}

	@Override
	public String toString() {
		return "Mission [card=" + card + ", team=" + piece.getTeam() + "]";
	}
	
	
}