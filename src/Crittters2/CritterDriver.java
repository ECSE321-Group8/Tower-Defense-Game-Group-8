package Crittters2;

//import Critters.critter;

public class CritterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int critterType =0;//speedy
		CritterType type=getType(critterType);
		Critter critter1=CritterFactory.makeCritter(type, 0);
		
		//critterType =2;//speedy
		//type=getType(critterType);
		Critter critter2=CritterFactory.makeCritter(type, 1);
		
		
		Thread t1=critter1.startMoving();

		Thread t2= critter2.startMoving();
		
		t1.start();
		t2.start();
		
		
		try {
			Thread.sleep(1000);
			critter2.critterSlowedDown(10);
			Thread.sleep(1000);
			critter2.critterSlowedDown(-10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
