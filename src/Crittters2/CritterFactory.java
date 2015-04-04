package Crittters2;

public class CritterFactory {
	public static Critter makeCritter(CritterType type, int ID){
		Critter critter = new Critter(ID);
		
		switch (type){
		case SPEEDY:
			critter.setHealth(10);
			critter.setWaitingTime(5);
			critter.setResistance(20);
			critter.setWorth();
			break;
		case HEALTHY:
			critter.setHealth(30);
			critter.setWaitingTime(7);
			critter.setResistance(10);
			critter.setWorth();
			break;
		case RESISTANT:
			critter.setHealth(20);
			critter.setWaitingTime(9);
			critter.setResistance(30);
			critter.setWorth();
			break;
		default:
			critter=null;
		}
		
		return critter;
	}
}
