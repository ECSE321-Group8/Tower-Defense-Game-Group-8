package Crittters2;

public class CritterWave {

	
	
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

