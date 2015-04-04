package Crittters2;
import java.util.*;


public class CritterWave {

	private LinkedList<Critter> listCritters = new LinkedList<Critter>();
	
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
		
		
	}
	public void startThreads(){
		for(Critter c: listCritters){
			c.getThread().start();
			/*
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
	}
	
	
	public LinkedList<Critter> getListCritters(){
		return listCritters;
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
}

