//package projekt;
//
//public class Main {
//	public static void main (String [] args){
//		
//		
//		
//		new ChallengeAccepted();
//	}
//}
package cha;

import java.util.Scanner;

import cha.domain.Board;
import cha.domain.Piece;


public class Main {

    public void run() {
        // Monopoly mply = Monopoly.getInstance();
    	Board newBoard = new Board();
    	
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String line = in.nextLine();
            if (line.equals("b")) {  // Bet
            	System.out.println("zzz");
            	String value = in.nextLine();
            	
            	newBoard.getActivePiece().bet(Integer.parseInt(value));
            	System.out.println(newBoard.getActivePiece());
            	
            } else if (line.equals("s")) {  // buy  
            	newBoard.startMission();
            	System.out.println(newBoard.getActivePiece());
                
            } else {

            }  
        }
    }

  
    public static void main(String[] args) {
        new Main().run();
    }
}