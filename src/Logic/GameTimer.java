package Logic;
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
	
		/**
		 * Method that will be called when the timer starts 
		 */
		public void run() {
//			System.out.println("running");
			game.tick();
			if (game.getCritterWave().getListCritters().isEmpty()||game.getLife()<=0){
				endGameTimer();
			}
				
		}
	}
}
