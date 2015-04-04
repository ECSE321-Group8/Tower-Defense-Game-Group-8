package Crittters2;

import Logic.Map;

public class TestGameClock {

	public static void main(String[] args) {
		Map m = Map.getInstance();
		m.openMap("test2");
		m.printGrid();
		m.printPath();
		Game game = Game.getInstance();
		
		game.addObserver(game.getCritterWave());
		game.startGameClock();

	}

}
