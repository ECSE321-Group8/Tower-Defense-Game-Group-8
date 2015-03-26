import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MapTest {
	//Initialize variables 
	Map m;
		
	@Before
	public void setUp()throws Exception{
		m=Map.getInstance();
		m.setMap(10,10);
		
		//Valid Path 
		m.setCellToPath(0);
		m.setCellToPath(1);
		m.setCellToPath(2);
		m.setCellToPath(3);
		m.setCellToPath(4);
		m.setCellToPath(5);
		m.setCellToPath(6);
		m.setCellToPath(7);
		//correct 
		m.setCellToPath(11);
		m.finalizePath();
		
		m.setRemainingToScenery();
		
		
		
		for(int i=0;i<m.getHeight();i++){
			for(int j=0;j<Map.getWidth();j++){
				if(m.getGrid(i,j).isPath())
					System.out.print("1 ");
				else 
					System.out.print("0 ");
			}
			System.out.println("");
		}
		System.out.println();
		
		m.printPath();
		
		System.out.println();
		System.out.println(m.entryPoint.getPos());
		System.out.println(m.exitPoint.getPos());
		
	}
	

	@Test
	public void test() {
		assertTrue(m.getCompletePath());
		
		//fail("Not yet implemented");
	}

}
