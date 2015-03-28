package Presentation;

/*
 * Classes Related to this example
 * Screen.java
 * Room.java
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Logic.Map;

public class Frame extends JFrame implements KeyListener, ActionListener{

	final static String APPNAME = "FRAME!";
	public static Dimension size = new Dimension (700,550);
	private MapGrid mG;
	// http://docs.oracle.com/javase/7/docs/api/java/awt/GridBagConstraints.html
	private GridBagConstraints gbc = new GridBagConstraints();
	ScrollPane scrollSection;
	JPanel editorOptions;
	JPanel blankPanel;
	JLabel lRows;
	JLabel lColumns;
	JTextField tRows;
	JTextField tColumns;
	private int rows;
	private int columns;
	JButton confirm;
	private JButton finalize;
	int sizeofSplit = 200;
	SplitPane sP;
	JPanel nothing;
	private boolean valid = false;
	int realHeight, realWidth;
	// Try to add this to the layout:
	// http://docs.oracle.com/javase/tutorial/uiswing/components/splitpane.html
	Map myMap;
	
	
	
	
	
	public Frame(){
		setTitle(APPNAME);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blankPanel = new JPanel(new BorderLayout());
		nothing = new JPanel();
		
		addKeyListener(this); // Does not work in the JPanel
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
		setVisible(true);
		// Not this gets the the size of the actual frame (without borders)
		realHeight = this.getContentPane().getSize().height-10;
		realWidth = this.getContentPane().getSize().width;
		System.out.println(this.getContentPane().getSize().width+" "+this.getContentPane().getSize().height);
		mG = new MapGrid(realWidth-sizeofSplit,realHeight-10);
		// TODO: Need to make left side grid of Map and right side where we set size of map and other options
		
		// Options to edit the Map
		setupMapOptions();
		
		blankPanel.add(scrollSection);
		setVisible(true);
		// Can only have this after panels initialized
		sP = new SplitPane(blankPanel,mG,sizeofSplit);
		// add(mG);
		add(sP);
		
		/*
		 * Doesn't work
		Dimension size = mG.getSize();
		System.out.println(size.width);
		System.out.println(size.height);
		*/
		
		init();
		
		myMap=Map.getInstance();
		
	}
	
	public static void main (String args []){
		Frame frame = new Frame();
	}
	
	public void init(){
		setVisible(true);
		// This must always happen after the setVisible has been activated as true or else it will be zero
		// http://stackoverflow.com/questions/13474795/get-the-real-size-of-a-jframe-content
		Dimension actualSize = this.getContentPane().getSize();
		System.out.println("Here " + actualSize.width);
		System.out.println(actualSize.height);
	}
	
	
	private void setupMapOptions() {
		// TODO Auto-generated method stub
		// To test a very long string
		//JLabel test = new JLabel("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
		scrollSection = new ScrollPane();
		
		editorOptions = new JPanel();
		// http://www.tutorialspoint.com/awt/awt_gridbaglayout.htm
		editorOptions.setLayout(new GridBagLayout());
		
		lRows = new JLabel("Rows: ");
		lColumns = new JLabel("Columns: ");
		tRows = new JTextField("10");
		tColumns = new JTextField("10");
		
		confirm = new JButton("OK");
		confirm.addActionListener(this);
		
		finalize = new JButton("Done");
		finalize.addActionListener(this);
		
		
		gbc.weightx = 1.0; // Makes it take up whole horizontal area
		//gbc.weighty = 1.0; // Makes it take up whole vertical area
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		editorOptions.add(lRows, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		editorOptions.add(tRows,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		editorOptions.add(lColumns,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		editorOptions.add(tColumns,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2; // So that it covers two columns
		editorOptions.add(confirm, gbc);
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		editorOptions.add(finalize, gbc);
		
		
		/*
		gbc.gridx = 0;
		gbc.gridy= 3;
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		editorOptions.add(test, gbc);
		*/
		
		
		scrollSection.add(editorOptions);
		
	}

	@Override
	public void keyPressed(KeyEvent b) {
		// TODO Auto-generated method stub
		// System.out.println("Pressed Key!");
		
		// Link for KeyCodes: http://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
		
		// Must create cases not going back to an already colored part of grid
		// Need to also know if first piece was added or not
		
		if(b.getKeyCode() == KeyEvent.VK_UP){
			mG.setXcor(mG.getXcor()-1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_DOWN){
			mG.setXcor(mG.getXcor()+1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_LEFT){
			mG.setYcor(mG.getYcor()-1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_RIGHT){
			mG.setYcor(mG.getYcor()+1);
			mG.setGrid(mG.getXcor(), mG.getYcor(), 1);
			mG.repaint();
		}
		if(b.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			System.out.println("BACKSPACE!");
		}
		if(b.getKeyCode() == KeyEvent.VK_ENTER){
			System.out.println("ENTER!");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "OK"){
			System.out.println("PRESSED OK!");
			
			try{
				rows = Integer.parseInt(tRows.getText());
				columns =  Integer.parseInt(tColumns.getText());
				valid = true;
			}
			catch(NumberFormatException e1){
				
			}
			if(rows<=1 || columns<=1 || rows>(realHeight/10) || columns>(realWidth/10)){
				valid = false;
			}
			if(valid){
				confirm.setEnabled(false);
				tRows.setEditable(false);
				tColumns.setEditable(false);
//				myMap=Map.getInstance();
//				myMap.setMap(rows,columns);
				mG.setDimensions(rows, columns);
			}
			
			
		}
		
		else if (e.getActionCommand()=="Done"){
			
			System.out.println("I AM DONE");
		
		myMap.finalizePath();
		mG.repaint();
		myMap.printPath();
		myMap.printGrid();


		
		}
	}
	
	
	
}