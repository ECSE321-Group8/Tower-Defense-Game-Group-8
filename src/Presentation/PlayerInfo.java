package Presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.*;

public class PlayerInfo extends JPanel implements IObserver{
	
	private int playerHealth;
	private int playerMoney;
	private Game myGame;
	private JLabel lPlayerHealth;
	private JLabel lPlayerMoney;
	
	public PlayerInfo(){
		myGame = Game.getInstance();
		this.playerMoney = myGame.getMoney();
		this.playerHealth = myGame.getLife();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
