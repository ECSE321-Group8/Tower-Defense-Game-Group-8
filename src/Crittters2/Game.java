package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game extends Subject{
	int level =1;
	LinkedList<Path> pathList;
	CritterWave wave;
	Player p;
	private static Game gameInstance= null;
	
	public Game(){
		Map m = Map.getInstance();
		p = new Player(); 
		wave= new CritterWave(level);
		TowerList tower= new TowerList();
		pathList = new LinkedList<Path>();
		
		for (Path p : m.getPath()){
			pathList.add(p);
		}
	}
	
	
	public static Game getInstance(){
		if(gameInstance==null)
			gameInstance=new Game();
		return gameInstance;
	}
	
	public LinkedList<Path> getPathList(){
		return pathList;
	}
	public CritterWave getCritterWave(){
		return wave;
	}
	
	
	
	
	public void startGameClock(){
		while(true){
			System.out.println("looping");
			try {
				Thread.sleep(1000);
				notifyObservers();
				System.out.println("notify");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
