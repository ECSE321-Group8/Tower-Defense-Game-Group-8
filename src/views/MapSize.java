package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapSize extends JPanel implements ActionListener{
	
	JFrame f1;
	JPanel p1;
	JPanel p2;
	JButton confirm;
	JTextField rows;
	JTextField columns;
	int count = 0;
	
	public MapSize () {
		
		p1 = new JPanel(); // Main panel
		p2 = new JPanel(); // Panel to hold components
		
		setTitle("Set Map Size");
		setSize(400,400);
		setVisible(true);
		
		p1.setLayout(new BorderLayout());
		// This layout can hold panels and place them in CENTER, NORTH, SOUTH, EAST, WEST
		p2.setLayout(new GridLayout(3,1));
		// This layout is in the form of a grid which holds panels by (rows, columns)
		
		confirm = new JButton ("OK"); // Button to confirm
		confirm.addActionListener(this);
		
		rows = new JTextField("10");
		columns = new JTextField("10");
		
		// Adding components to gridlayout
		p2.add(rows);
		p2.add(columns);
		p2.add(confirm);
		
		// Adding gridlayout panel to the main panel
		p1.add("Center",p2);
		
		// Adding main panel to frame; without this you don't see it on the screen
		add(p1);
		init();
	}
	
	private void init(){
		
		// This allows the program to stop running and to close when you press this "X"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "OK"){
			System.out.println(count++);
			System.out.println(rows.getText()+"\t"+columns.getText());
			// Map m = new Map(parseInt(rows.getText()),columns.getText());
		}
	}
	
public static void main (String [] args) throws Exception {
        
        MapSize ms = new MapSize();
    }

}
