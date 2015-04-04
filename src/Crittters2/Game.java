package Crittters2;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game extends Subject{
	int level =1;
	LinkedList<Path> pathList;
	CritterWave wave;
	Player p;
	
	
	public Game(){
		p = new Player(); 
		wave= new CritterWave(level);
		Map m = Map.getInstance();
		TowerList tower= new TowerList();
		
		pathList = new LinkedList<Path>();
		
		for (Path p : m.getPath()){
			pathList.add(p);
		}
	}
	
	public void startGameClock(){
		while(true){
			
			try {
				Thread.sleep(1000);
				notifyObservers();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
