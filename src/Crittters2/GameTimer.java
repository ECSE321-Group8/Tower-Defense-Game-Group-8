package Crittters2;
import java.util.*;

public class GameTimer {
	Timer timer; 
	Game game;
	public GameTimer(Game game){
		this.game = game;
		timer = new Timer();
		
		timer.schedule(new Tick(), 0, 1000);
	}
	public void endGameTimer(){
		timer.cancel();
	}
	
	public class Tick extends TimerTask {
		public void run() {
			System.out.println("running");
			// TODO Auto-generated method stub
			//System.out.println("test");
			game.tick();
			if (game.getCritterWave().getListCritters().isEmpty()){
				endGameTimer();
			}
				
		}
	}
}
