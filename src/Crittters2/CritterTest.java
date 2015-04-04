package Crittters2;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import Logic.*;
import Logic.Map;

public class CritterTest {
	Map m;
	CritterWave wave;
	
	@Before
	public void setUp(){
		m =Map.getInstance();
		m.setMap(5, 5);
		m.setCellToPath(0);
		m.setCellToPath(5);
		m.setCellToPath(10);
		m.setCellToPath(15);
		m.setCellToPath(20);
		m.setCellToPath(21);
		m.setCellToPath(22);
		m.setCellToPath(23);
		m.setCellToPath(24);
		m.finalizePath();
		m.printGrid();
		m.printPath();
		
		wave= new CritterWave(1);
		
		wave.startThreads();
		//System.out.println("done");
		
	}
	
	@Test
	public void test() {
		
		//fail("Not yet implemented");
	}

}
