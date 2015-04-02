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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Map;

public class GameView extends JFrame implements KeyListener, ActionListener {

	final static String APPNAME = "TOWER DEFENSE - GROUP 8";
	public static Dimension size = new Dimension (700,550);
	private MapGrid mG;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	private ScrollPane scrollSection;
	private JPanel gameOptions;
	private JPanel mainPanel;
	private JPanel options;
	private JPanel towerInfo;
	private JPanel critterInfo;
	private CardLayout layout;
	private String [] cardLayoutLabels = new String [3]; 
	// http://www.tutorialspoint.com/awt/awt_cardlayout.htm
	// https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
	
	// Reading and writing
	// http://www.tutorialspoint.com/java/io/bufferedwriter_write_string.htm
	// http://stackoverflow.com/questions/2885173/java-how-to-create-a-file-and-write-to-a-file
	// http://stackoverflow.com/questions/2788080/reading-a-text-file-in-java
	
	private JLabel lMapName;
	
	private JTextField tMapName;
	
	private final int sizeofSplit = 200;
	private int realHeight, realWidth;
	private int changeCounter = 0;
	
	private JButton open;
	private JButton change;
	private JButton towerb;
	private JButton critterb;
	
	private SplitPane sP;
	private Map myMap;
	
	public GameView(){
		setTitle(APPNAME);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		change = new JButton("Change");
		change.addActionListener(this);
		mainPanel.add(change);
		addKeyListener(this);
		setVisible(true);
		
		mG = new MapGrid(realWidth-sizeofSplit,realHeight-10);
		
		leftSideOptions();
		splitViewSetUp();
		
	}
	
	private void leftSideOptions() {
		// TODO Auto-generated method stub
		options = new JPanel();
		gameOptions = new JPanel();
		gameOptions.setLayout(new GridBagLayout());
		towerInfo = new JPanel();
		towerInfo.setLayout(new GridBagLayout());
		critterInfo = new JPanel();
		critterInfo.setLayout(new GridBagLayout());
		layout = new CardLayout();
		options.setLayout(layout);
		
		open = new JButton("Open");
		open.addActionListener(this);
		
		towerb = new JButton("Tower Button");
		towerb.addActionListener(this);
		
		critterb = new JButton("Critter Button");
		critterb.addActionListener(this);
		
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gameOptions.add(open,gbc);
		towerInfo.add(towerb, gbc);
		critterInfo.add(critterb, gbc);
		
		options.add("Game",gameOptions);
		options.add("Tower", towerInfo);
		options.add("Critter", critterInfo);
		
		cardLayoutLabels[0] = "Game";
		cardLayoutLabels[1] = "Tower";
		cardLayoutLabels[2] = "Critter";
		
		layout.show(options, cardLayoutLabels[0]);
		setVisible(true);
	}

	private void splitViewSetUp() {
		// TODO Auto-generated method stub
		sP = new SplitPane(options,mainPanel, sizeofSplit);
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
			if(changeCounter>2){
				changeCounter = 0;
			}
			layout.show(options, cardLayoutLabels[changeCounter]);
		}
		else if(e.getActionCommand()== "Open"){
			System.out.println("Pressed Open");
		}
		else if(e.getActionCommand()== "Tower Button"){
			System.out.println("Tower Button");
		}
		else if(e.getActionCommand()== "Critter Button"){
			System.out.println("Critter Button");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
