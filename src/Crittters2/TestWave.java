package Crittters2;
import java.util.*;


public class TestWave {

	public static void main(String[] args) {
		LinkedList<Critter> list = new LinkedList<Critter>();
		
		CritterWave wave = new CritterWave(1);
		for (Critter c: wave.getListCritters()){
			System.out.println(c.getID());
			System.out.println(c.getHealth()+"\t"+c.getResistance()+"\t"+c.getSpeed());
			list.add(c);
		}
		
		
	}

}
