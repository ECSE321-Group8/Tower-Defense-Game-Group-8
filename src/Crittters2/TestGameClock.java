package Crittters2;

<<<<<<< HEAD:src/Tests/TestGameClock.java
import Logic.*;
=======
>>>>>>> parent of d77b3bc... comments added:src/Crittters2/TestGameClock.java
import Logic.Map;

public class TestGameClock {

	public static void main(String[] args) {
		Map m = Map.getInstance();
		m.openMap("test2");
		m.printGrid();
		m.printPath();
		Game game = Game.getInstance();
		game.setGame(); 
		
		game.addObserver(game.getCritterWave());
		
		new GameTimer(game);	
		
		System.out.println("end");
		

	}

}
