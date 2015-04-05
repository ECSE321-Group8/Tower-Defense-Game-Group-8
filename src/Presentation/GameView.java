package Presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Crittters2.Game;
import Logic.Map;
import Logic.Scenery;
import Logic.Tower;
import Logic.TowerList;

public class GameView extends JFrame implements KeyListener, ActionListener {

	final static String APPNAME = "TOWER DEFENSE - GROUP 8";
	public static Dimension size = new Dimension (700,550);
	private MapGrid mG;
	
	private Scenery tempScenery;
	private Tower tempTower;
	private TowerList myTowerList;
	
	private boolean valid;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagConstraints gbc2 = new GridBagConstraints();
	private GridBagConstraints gbc3 = new GridBagConstraints();
	private GridBagConstraints gbc4 = new GridBagConstraints();
	private ScrollPane scrollSection;
	private JPanel gameOptions;
	private JPanel mainPanel;
	private JPanel options;
	private JPanel opening;
	private JPanel mapEditing;
	private JPanel towerInfo;
	private JPanel towerPurchase;
	private JPanel critterInfo;
	private CardLayout layout;
	private CardLayout layout2;
	private LinkedList<String> cardLayoutLabels = new <String>LinkedList(); 
	// http://www.tutorialspoint.com/awt/awt_cardlayout.htm
	// https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
	
	// Reading and writing
	// http://www.tutorialspoint.com/java/io/bufferedwriter_write_string.htm
	// http://stackoverflow.com/questions/2885173/java-how-to-create-a-file-and-write-to-a-file
	// http://stackoverflow.com/questions/2788080/reading-a-text-file-in-java
	
	private JLabel lMapName;
	private JLabel lMapName1;
	private JLabel lRows;
	private JLabel lColumns;

	private JTextField tMapName;
	private JTextField tMapName1;
	private JTextField tRows;
	private JTextField tColumns;
	
	private JTextArea nameOfMaps;
	
	private final int sizeofSplit = 200;
	private int realHeight, realWidth;
	private int changeCounter = 0;
	private int rows;
	private int columns;
	
	private JButton newMap;
	private JButton open;
	private JButton change;
	private JButton towerb;
	private JButton critterb;
	private JButton start;
	private JButton finalize;
	private JButton save;
	private JButton back;
	private JButton edit;
	private JButton play;
	private JButton editAgain;
	private JButton back2;
	private JButton cancel;
	
	// For Tower Info:
	private JLabel towerName;
	private JTextArea towerStats;
	private JLabel buyTower;
	
	private JComboBox<String> towerStrategy;
	
	private JButton upgrade;
	private JButton sell;
	private JButton FastTower;
	private JButton strongTower;
	private JButton sniperTower;
	
	private SplitPane sP;
	private Map myMap;
	private Game myGame;

	
	public GameView(){
		setTitle(APPNAME);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		change = new JButton("Change");
		change.addActionListener(this);
		// mainPanel.add(change);
		addKeyListener(this);
		setVisible(true);
		
		realHeight = this.getContentPane().getSize().height-10;
		realWidth = this.getContentPane().getSize().width;
		// mainPanel.add(mG);
		myMap=Map.getInstance();
		myGame = Game.getInstance();
		myGame.setGame();
		myTowerList = myGame.getMytowerlist();
		leftSideOptions();
		mG = new MapGrid(realWidth-sizeofSplit,realHeight-10,options,layout);
		myGame.addObserver(mG);
		splitViewSetUp();
		
		
		
	}
	
	private void leftSideOptions() {
		// TODO Create different grid bag constraints for each panel
		// Create different JComponents for each panel
		options = new JPanel();
		gameOptions = new JPanel();
		gameOptions.setLayout(new GridBagLayout());
		towerInfo = new JPanel();
		towerInfo.setLayout(new GridBagLayout());
		critterInfo = new JPanel();
		critterInfo.setLayout(new GridBagLayout());
		mapEditing = new JPanel();
		mapEditing.setLayout(new GridBagLayout());
		opening = new JPanel();
		opening.setLayout(new GridBagLayout());
		towerPurchase = new JPanel();
		towerPurchase.setLayout(new GridBagLayout());
		
		layout = new CardLayout();
		options.setLayout(layout);
		
		lRows = new JLabel("Rows: ");
		lColumns = new JLabel("Columns: ");
		tRows = new JTextField("10");
		tColumns = new JTextField("10");
		lMapName = new JLabel("Map Name: ");
		tMapName = new JTextField("Map 1");
		lMapName1 = new JLabel("Map Name: ");
		tMapName1 = new JTextField("Map 1");
		towerName = new JLabel("Tower");
		
		nameOfMaps = new JTextArea(myMap.printMapRecords());
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		open = new JButton("Open");
		open.addActionListener(this);
		
		towerb = new JButton("Tower Button");
		towerb.addActionListener(this);
		
		critterb = new JButton("Critter Button");
		critterb.addActionListener(this);
		
		newMap = new JButton("New Map");
		newMap.addActionListener(this);
		
		start = new JButton("Start");
		start.addActionListener(this);
		
		finalize = new JButton("Done");
		finalize.addActionListener(this);
		finalize.setEnabled(false); // Only can do so after Map Size Set
		
		save = new JButton("Save");
		save.addActionListener(this);
		save.setEnabled(false);// Only want to be able to press after started making Map
		
		back = new JButton("Back");
		back.addActionListener(this);
		
		edit = new JButton("Edit");
		edit.addActionListener(this);
		edit.setEnabled(false);
		
		play = new JButton("Play");
		play.addActionListener(this);
		
		editAgain = new JButton("Edit");
		editAgain.addActionListener(this);
		
		back2 = new JButton("Back");
		back2.addActionListener(this);
		
		sell = new JButton ("Sell");
		sell.addActionListener(this);
		
		upgrade = new JButton ("Upgrade");
		upgrade.addActionListener(this);
		
		FastTower = new JButton("Fast");
		FastTower.addActionListener(this);
		
		strongTower = new JButton("Strong");
		strongTower.addActionListener(this);
		
		sniperTower = new JButton("Sniper");
		sniperTower.addActionListener(this);
		
		towerStats = new JTextArea("Power=\nRange=\nCool Down=");
		
		String [] strategyOptions = {"Closest","Furthest","Least Health","Most Health"};
		towerStrategy = new JComboBox(strategyOptions);
		towerStrategy.setSelectedIndex(1);
		towerStrategy.addActionListener(this);
		
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gameOptions.add(newMap,gbc);
		towerInfo.add(towerb, gbc);
		critterInfo.add(critterb, gbc);
		
		// Setting up the Map Editing View
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		mapEditing.add(lRows, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		mapEditing.add(tRows,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		mapEditing.add(lColumns, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		mapEditing.add(tColumns,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		mapEditing.add(lMapName,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		mapEditing.add(tMapName,gbc);
		
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		
		mapEditing.add(start,gbc);
		
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		
		mapEditing.add(edit,gbc);
		
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		
		mapEditing.add(save,gbc);
		
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		
		mapEditing.add(finalize,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		
		mapEditing.add(back,gbc);
		// The Main Menu
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gameOptions.add(open,gbc);
		
		// The Opening New Game
		
		gbc2.weightx = 1.0;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		
		opening.add(lMapName1,gbc2);
		
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridx = 1; // Don't know why this makes be use 2
		gbc2.gridy = 0;
		
		opening.add(tMapName1,gbc2);
		
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.gridwidth = 2;
		
		opening.add(editAgain,gbc2);
		
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		gbc2.gridwidth = 2;
		
		opening.add(back2,gbc2);
		
		/*
		gbc.gridx = 0;
		gbc.gridy = 2;
		// gbc.gridwidth = 2;
		
		opening.add(edit);
		*/
		
		gbc2.gridx = 0;
		gbc2.gridy = 3;
		gbc2.gridwidth = 2;
		
		opening.add(play,gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 4;
		gbc2.gridwidth = 2;
		
		opening.add(nameOfMaps, gbc2);
		
		/*
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		
		opening.add(back);
		*/
		
		// Tower Info
		
		gbc3.weightx = 1.0;
		gbc3.fill = GridBagConstraints.HORIZONTAL;
		gbc3.gridx = 0;
		gbc3.gridy = 1;
		
		towerInfo.add(towerName,gbc3);
		
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		// gbc3.gridheight = 3;
		
		towerInfo.add(towerStats, gbc3);
		
		gbc3.gridx = 0;
		gbc3.gridy = 3;
		
		towerInfo.add(towerStrategy,gbc3);
		
		gbc3.gridx = 0;
		gbc3.gridy = 4;
		
		towerInfo.add(upgrade, gbc3);
		
		gbc3.gridx = 0;
		gbc3.gridy = 5;
		
		towerInfo.add(sell, gbc3);
		
		// Tower Purchase
		
		gbc4.weightx = 1.0;
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		gbc4.fill = GridBagConstraints.HORIZONTAL;
		
		towerPurchase.add(FastTower, gbc4);
		
		gbc4.gridx = 0;
		gbc4.gridy = 1;
		
		towerPurchase.add(strongTower, gbc4);
		
		gbc4.gridx = 0;
		gbc4.gridy = 2;
		
		towerPurchase.add(sniperTower, gbc4);
		
		gbc4.gridx = 0;
		gbc4.gridy = 3;
		
		towerPurchase.add(cancel, gbc4);
		
		options.add("Game",gameOptions);
		options.add("Tower", towerInfo);
		options.add("Critter", critterInfo);
		options.add("Editing", mapEditing);
		options.add("Opening", opening);
		options.add("Tower Purchase", towerPurchase);
		
		cardLayoutLabels.add("Game");
		cardLayoutLabels.add("Tower");
		cardLayoutLabels.add("Critter");
		cardLayoutLabels.add("Editing");
		cardLayoutLabels.add("Opening");
		cardLayoutLabels.add("Tower Purchase");
		
		layout.show(options, "Game");
		setVisible(true);
	}

	private void splitViewSetUp() {
		// TODO Auto-generated method stub
		sP = new SplitPane(options,mG, sizeofSplit);
		add(sP);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameView gV = new GameView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Change"){
			System.out.println("Changed!");
			changeCounter++;
			if(changeCounter>cardLayoutLabels.size()-1){
				changeCounter = 0;
			}
			layout.show(options, cardLayoutLabels.get(changeCounter));
			setVisible(true);
		}
		else if(e.getSource() == start){
			System.out.println("Pressed Start");
			try{
				rows = Integer.parseInt(tRows.getText());
				columns =  Integer.parseInt(tColumns.getText());
				valid = true;
				System.out.println("The rows: "+rows+ " columns: "+columns);
			}
			catch(NumberFormatException e1){
				
			}
			if(rows<=1 || columns<=1 || rows>(realHeight/10) || columns>(realWidth/10)){
				valid = false;
			}
			if(valid){
				start.setEnabled(false);
				finalize.setEnabled(true);
				edit.setEnabled(true);
				tRows.setEditable(false);
				tColumns.setEditable(false);
				//myMap=Map.getInstance();
				// myMap.setMap(rows,columns);
				mG.setDimensions(rows, columns);
				myMap.setMap(rows, columns);
			}
		}
		else if(e.getSource() == play){
			System.out.println("Start Playing Game");
			open.setEnabled(false);
			mG.setPlaying(true);
			myMap.openMap(tMapName1.getText());
			mG.setDimensions(myMap.getHeight(), myMap.getWidth());
			mG.setCompletedView(true);
			editAgain.setEnabled(false);
			repaint();
			myGame.addObserver(myGame.getCritterWave());
			myGame.startGameClock();
			setVisible(true);
		}
		else if(e.getSource()==edit){
			save.setEnabled(false);
		}
		else if(e.getSource()==editAgain){
			// This is were we open the Map to re edit
			myMap.openMap(tMapName1.getText());
			mG.setDimensions(myMap.getHeight(), myMap.getWidth());
			mG.setCompletedView(true);
			start.setEnabled(false);
			finalize.setEnabled(true);
			edit.setEnabled(true);
			tRows.setEditable(false);
			tColumns.setEditable(false);
			mG.repaint();
			layout.show(options, "Editing");
			setVisible(true);
		}
		else if(e.getSource() == finalize){
			save.setEnabled(true);
			edit.setEnabled(true);
			myMap.finalizePath();
			mG.setCompletedView(true);
			mG.repaint();
		}
		else if(e.getSource() == open){
			System.out.println("Pressed Open");
			layout.show(options, "Opening");
			editAgain.setEnabled(true);
			setVisible(true);
		}
		else if(e.getSource()==save){
			myMap.saveMap(tMapName.getText());
			nameOfMaps.setText(myMap.printMapRecords());
		}
		else if(e.getActionCommand()== "Tower Button"){
			System.out.println("Tower Button");
		}
		else if(e.getActionCommand()== "Critter Button"){
			System.out.println("Critter Button");
		}
		else if(e.getSource() == newMap){
			System.out.println("Starting a new Map");
			tRows.setEditable(true);
			tColumns.setEditable(true);
			start.setEnabled(true);
			layout.show(options, "Editing");
			setVisible(true);
		}
		else if(e.getSource() == back){
			System.out.println("Going back to main Menu");
			layout.show(options, "Game");
			setVisible(true);
		}
		else if(e.getSource() == back2){
			System.out.println("Going back to main Menu");
			layout.show(options, "Game");
			setVisible(true);
		}
		else if(e.getSource() == towerStrategy){
			System.out.println("The Selected Strategy was: " + towerStrategy.getSelectedIndex());
		}
		/*
		 * Tower IDs:
		 * Fast Tower: 1
		 * Strong Tower: 2
		 * Sniper Tower: 0
		 */
		else if(e.getSource() == FastTower){
			System.out.println("Adding Fast Tower");
			tempScenery = (Scenery)myMap.getGrid(mG.getXcor(), mG.getYcor());
			tempScenery.placeTower();
			myTowerList = myGame.getMytowerlist();
			myTowerList.buyTower(1, mG.getXcor(), mG.getYcor());
			mG.placeTower();
			layout.show(options, "Opening");
			setVisible(true);
		}
		else if(e.getSource() == strongTower){
			System.out.println("Adding Strong Tower");
			mG.placeTower();
			layout.show(options, "Opening");
			setVisible(true);
		}
		else if(e.getSource() == sniperTower){
			System.out.println("Adding Sniper Tower");
			mG.placeTower();
			layout.show(options, "Opening");
			setVisible(true);
		}
		else if(e.getSource() == cancel){
			layout.show(options, "Opening");
			setVisible(true);
		}
		// http://stackoverflow.com/questions/13791987/keyboard-input-stops-working-in-swing-application-a-calculator-after-clicking
		requestFocusInWindow(); // Allows for keyboard listener to work after button pressed
	}

	@Override
	public void keyPressed(KeyEvent b) {
		// TODO Auto-generated method stub
		if(b.getKeyCode() == KeyEvent.VK_UP){
			System.out.println("UP!");
			/*
			mG.setXcor(mG.getXcor()-1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
			*/
			myMap.setCellToPath(myMap.getCurrentPos()-myMap.getWidth());
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("DOWN!");
			/*
			mG.setXcor(mG.getXcor()+1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
			*/
			myMap.setCellToPath(myMap.getCurrentPos()+myMap.getWidth());
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("LEFT!");
			/*
			mG.setYcor(mG.getYcor()-1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
			*/
			myMap.setCellToPath(myMap.getCurrentPos()-1);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("RIGHT!");
			/*
			mG.setYcor(mG.getYcor()+1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
			*/
			myMap.setCellToPath(myMap.getCurrentPos()+1);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			System.out.println("BACKSPACE!");
			save.setEnabled(false);
			edit.setEnabled(false);
			myMap.deleteLastPathTile();
			mG.setCompletedView(false);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_ENTER){
			System.out.println("ENTER!");
			save.setEnabled(true);
			edit.setEnabled(true);
			myMap.finalizePath();
			mG.setCompletedView(true);
			mG.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
