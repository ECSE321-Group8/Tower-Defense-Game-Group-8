package views;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MapSize {
	
	JFrame frame = new JFrame ();
	public static final int SCREEN_WIDTH = 100;
	public static final int SCREEN_HEIGHT = 100;
	public static final String APP_NAME = "SIZE OF MAP";
	
	public int sizeRows;
	public int sizeColumns;
	public JTextField textRows;
	public JTextField textColumns;
	
	public MapSize () {
		
	}
	
	private void init(){
		
		frame.add(textRows);
		frame.add(textColumns);;
	}

}
