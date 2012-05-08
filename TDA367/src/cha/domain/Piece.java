package cha.domain;

import java.awt.Color;
import java.util.ArrayList;

public class Piece {
	private int position;
	private int piece;
	private static int bet;
	private Team team;
	
	public Piece(Team team){
		this.team = team;
		bet = 0;
	}
	
	public void movePieceForward(int bet){
		position = position + bet;
	}
	public void movePieceBackward(){
		position = position - 2;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}
	
//	public void bet(int value){
//		this.bet = new Bet(value);
//	} 
	
	public int getPiece() {
		return piece;
	}
	
	public int getBetAmount(){
		return bet;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	@Override
	public String toString() {
		return "Piece [position=" + position + ", piece=" + piece + ", bet=" + bet + "]";
	}

	public Team getTeam() {
		return this.team;
	}

	public void setBet(int newBet) {
		this.bet = newBet;
	}

	

}
