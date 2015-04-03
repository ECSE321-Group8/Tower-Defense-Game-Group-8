package Crittters2;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;


public class CritterTest {
	//Initialized

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
	
	@Before
	public void setUp()throws Exception{
		LinkedList<Integer> path1= new LinkedList<Integer>();
		LinkedList<Integer> path2 = new LinkedList<Integer>();
		
		int critterType =0;//speedy
		CritterType type=getType(critterType);
		Critter critter1=CritterFactory.makeCritter(type, 0);
		System.out.println(critter1.getHealth());
		System.out.println(critter1.getResistance());
		System.out.println(critter1.getSpeed());
		System.out.println(critter1.getWorth());
		System.out.println(critter1.getPosition());
		
		critterType =2;//speedy
		type=getType(critterType);
		Critter critter2=CritterFactory.makeCritter(type, 1);
		System.out.println(critter2.getHealth());
		System.out.println(critter2.getResistance());
		System.out.println(critter2.getSpeed());
		System.out.println(critter2.getWorth());
		System.out.println(critter2.getPosition());
		
		
		path1.add(0);
		path1.add(1);
		path1.add(2);
		path1.add(3);
		path1.add(4);
		path1.add(5);
		path1.add(6);
		path1.add(7);
		path1.add(8);
		path1.add(9);

		path2.add(0);
		path2.add(1);
		path2.add(2);
		path2.add(3);
		path2.add(4);
		path2.add(5);
		path2.add(6);
		path2.add(7);
		path2.add(8);
		path2.add(9);
//		
		critter1.moveAlongPath(path1);
		critter2.moveAlongPath(path2);
	}
	
	@Test
	public void test() {
		
		//fail("Not yet implemented");
	}

}
