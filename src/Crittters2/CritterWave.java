package Crittters2;
import java.util.*;

import Logic.Map;
import Logic.Path;


public class CritterWave implements IObserver{

	private LinkedList<Critter> listCritters = new LinkedList<Critter>();
	Map m = Map.getInstance();
	Game g = Game.getInstance();
	private LinkedList<Path> aPath=new LinkedList<Path>();//accesses through the Map
	
	
	
	public CritterWave(int level){
		int nbCritters=level*5;
		int critterType;
		CritterType type;
		Critter c;
		for (int i=0;i<nbCritters; i++){
			critterType = i%3;
			type=getType(critterType);
			c=CritterFactory.makeCritter(type, i);
			listCritters.add(c);
		}
		setPath();
		
		
	}

	public void setPath(){
		for (Path p: m.getPath())
			aPath.add(p);
	}
	
	public LinkedList<Path> getPath(){
		return aPath;
	}

	
	
	public LinkedList<Critter> getListCritters(){
		return listCritters;
	}
	
	public void removeCritter(Critter c){
		listCritters.remove(c);
	}
	
	
	public static CritterType getType(int type){
		switch(type){
		case 0:
			return CritterType.SPEEDY;
		case 1:
			return CritterType.HEALTHY;
		case 2:
			return CritterType.RESISTANT;
		default:
			return null;//error
		}
	}

	@Override
	public void update(){
		for(int i = listCritters.size(); i < 0; i--){
			if(listCritters.get(i).getCompletion() == aPath.size()){
				g.decrementLife(1);
				removeCritter(listCritters.get(i));
			}
			listCritters.get(i).tick();
		}
		
	}
}
 