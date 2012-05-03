package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.controller.IEventHandler;
import cha.domain.Categories.Category;

@SuppressWarnings("serial")
public class TileContainerPanel extends JPanel implements IEventHandler {

	private TilePanel[] tilePanels = new TilePanel[44];

	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();

	private ArrayList<Color> colorList;
	private ArrayList<PiecePanel> pieces;
	private int currentPiece;

	public TileContainerPanel() {
		setLayout(new BorderLayout(0, 0));
//		init();
		ChallengeAccepted.getInstance().register(this);
	}

	private void init(ArrayList<Category> c) {
		colorList = new ArrayList<Color>();
		colorList.add(Color.BLUE);
		colorList.add(Color.GREEN);
		colorList.add(Color.YELLOW);
		colorList.add(Color.RED);

		eastPanel.setPreferredSize(new Dimension(50, 0));
		FlowLayout flowLayout_1 = (FlowLayout) eastPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		FlowLayout flowLayout_2 = (FlowLayout) southPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		westPanel.setPreferredSize(new Dimension(50, 0));
		FlowLayout flowLayout_3 = (FlowLayout) westPanel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		FlowLayout flowLayout = (FlowLayout) northPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);

		this.add(northPanel, BorderLayout.NORTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(westPanel, BorderLayout.WEST);

		setTiles(c);
		
		pieces = new ArrayList();
		pieces.add(new PiecePanel(Color.BLUE));
		pieces.add(new PiecePanel(Color.GREEN));
		pieces.add(new PiecePanel(Color.YELLOW));
		
		for(PiecePanel piece : pieces){
			tilePanels[0].addPiece(piece);
		}
		currentPiece = 0;
	}

	private void setTiles(ArrayList<Category> categories) {
		TilePanel start = new StartTilePanel();
		tilePanels[0] = start;
		northPanel.add(start);
		
		TilePanel goal = new GoalTilePanel();
		tilePanels[43] = goal;
		westPanel.add(goal);
		
		for (int i = 1; i < 14; i++) {
			TilePanel p = createTile(categories.get(i), i);
			tilePanels[i] = p;
			northPanel.add(p);
		}
		for (int i = 14; i < 22; i++) {
			TilePanel p = createTile(categories.get(i), i);
			tilePanels[i] = p;
			eastPanel.add(p);
		}
		for (int i = 21; i < 35; i++) {
			TilePanel p = createTile(categories.get(i), i);
			tilePanels[i] = p;
			southPanel.add(p);
		}		

		for (int i = 42; i > 35; i--) {
			TilePanel p = createTile(categories.get(i), i);
			tilePanels[i] = p;
			westPanel.add(p);
		}
	}
	
	private TilePanel createTile(Category c, int i){
		TilePanel tile;
		if(c == Category.BACKWARDS){
			tile = new NormalTilePanel(Color.RED, i);
		}
		else if(c == Category.BODYTOBODY){
			tile = new NormalTilePanel(Color.YELLOW, i);
		}
		else if(c == Category.SAMECLASS){
			tile = new NormalTilePanel(Color.BLUE, i);
		}
		else {
			tile = new NormalTilePanel(Color.GREEN, i);
		}
		
		return tile;
	}
	
	private void nextPlayer(){
		if(currentPiece == pieces.size()-1){
			currentPiece = 0;
		}
		else{
			currentPiece++;
		}
	}

	public void action(Event e, Object o) {
		if(e == Event.CreateBoard){
			ArrayList<Category> c = (ArrayList<Category>)o;
			init(c);
		}
		else if (e == Event.ShowBet) {
			// int pos =
			// ChallengeAccepted.getInstance().getBoard().getActivePiece().getPosition();
			int pos = 0;
			for (int i = pos + 1; i < pos + 8; i++) {
				if (i > 43)
					return;
				tilePanels[i].betable();
			}
		} 
		else if (e == Event.MakeBet) {
			for (TilePanel panel : tilePanels) {
				panel.notBetable();
			}
		}
		else if(e == Event.OldPosition){
			int pos = (Integer)o;
			tilePanels[pos].removePiece(pieces.get(currentPiece));
		}
		else if(e == Event.NewPosition){
			int pos = (Integer)o;
			tilePanels[pos].addPiece(pieces.get(currentPiece));
		}
	}
}
