package cha.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import cha.domain.Board;
import cha.event.Event;
import cha.event.EventBus;

@SuppressWarnings("serial")
public class TilePanel extends JPanel {

	JPanel panel;
	int position;

	public TilePanel() {
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		this.setPreferredSize(new Dimension(50, 50));
		this.setMinimumSize(new Dimension(50, 50));
		this.setSize(50, 50);
		this.setLayout(new BorderLayout(0, 0));

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				click();
			}
		});

		/*
		 * JPanel p2 = new JPanel(); JPanel p3 = new JPanel(); JPanel p4 = new
		 * JPanel();
		 * 
		 * p2.setBackground(color); p3.setBackground(color);
		 * p4.setBackground(color);
		 * 
		 * add(p2,BorderLayout.SOUTH); add(p3,BorderLayout.WEST);
		 * add(p4,BorderLayout.EAST);
		 */
	}

	public void addPiecePanel(PiecePanel piece) {
		panel.add(piece);
	}

	public void removePiece(PiecePanel piece) {
		panel.remove(piece);
		this.repaint();
	}

	public void betable() {

		// Piece activePiece = Board.getInstance().getActivePiece();
		// if (this.position == activePiece.getPosition()
		// + activePiece.getBet().getBetValue()) {
		// this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		// } else {
		// this.setBorder(new BevelBorder(BevelBorder.RAISED));
		// }

		/*
		 * if(this.position == ChallengeAccepted.getInstance()
		 * .getBoard().getActivePiece().getBetAmount() +
		 * ChallengeAccepted.getInstance().getBoard().getActivePiece()
		 * .getPosition()) { this.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED)); } else {
		 */

		this.setBorder(new BevelBorder(BevelBorder.RAISED));
		// }

	}

	/*
	 * if(this.position == ChallengeAccepted.getInstance()
	 * .getBoard().getActivePiece().getBetAmount() +
	 * ChallengeAccepted.getInstance().getBoard().getActivePiece()
	 * .getPosition()) { this.setBorder(new BevelBorder(BevelBorder.LOWERED)); }
	 * else {
	 */
	// this.setBorder(new BevelBorder(BevelBorder.RAISED));
	// }

	public void notBetable() {
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
	}

	private void click() {

		//TODO: Change this.
//		int currentBet = TileContainerPanel.getCurrentBet();

		int piecePos = Board.getInstance().getActivePiece().getPosition();

		// TODO: Change this.
		//int currentBet = TileContainerPanel.getCurrentBet();



		TileContainerPanel.getTilePanels()[Board.getInstance().getActivePiece()
				.getBet().getBetValue()
				+ Board.getInstance().getActivePiece().getPosition()]
				.setBorder(new BevelBorder(BevelBorder.LOWERED));

		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		// if(Board.getInstance().getActivePiece().getBetAmount()
		// == 0)
		// {
		this.repaint();



		if (Board.getInstance().getActivePiece()
				.getBet().getBetValue() == 0) {

//		int currentBet = TileContainerPanel.getCurrentBet();
		}
		/*
		TileContainerPanel.getTilePanels()[currentBet
				+ ChallengeAccepted.getInstance().getBoard().getActivePiece()
						.getPosition()].setBorder(new BevelBorder(
				BevelBorder.LOWERED));*/
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.repaint();
		
	
		if (TileContainerPanel.getBetable() == 0) {
			int currentBet = TileContainerPanel.getCurrentBet();

		// if (TileContainerPanel.getBetable() == 0) {

		// int currentBet = TileContainerPanel.getCurrentBet();


		/*
		 * TileContainerPanel.getTilePanels()[currentBet +
		 * ChallengeAccepted.getInstance().getBoard().getActivePiece()
		 * .getPosition()].setBorder(new BevelBorder( BevelBorder.LOWERED));
		 */
		// this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		// this.repaint();
		}
		
		if (TileContainerPanel.getBetable() == 0) {

			if (position > piecePos && position < piecePos + 8) {

				bet(piecePos);

			}
		}

	}

	public void bet(int piecePos) {
		int bet = this.position - piecePos;

		Board.getInstance().getActivePiece().setBet(bet);
		// ChallengeAccepted.getInstance().getBoard().getActivePiece().setBet(bet);

		Board.getInstance().getActivePiece().setBet(bet);

		// ChallengeAccepted.getInstance().getBoard().getActivePiece().setBet(bet);

		EventBus.getInstance().publish(Event.MakeBet, bet);
	}
}
