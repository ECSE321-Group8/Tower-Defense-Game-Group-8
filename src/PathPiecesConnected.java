import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PathPiecesConnected {
	
	Map m;
	Path p1; // Will be StraigthWE
	
	
	@Before
	public void setUp() throws Exception {
		m = new Map(10,10);
		p1 = new StraightWE(0,10);
		System.out.println(p1.getEntrance());
		System.out.println(p1.getExit());
		System.out.println(m.inValidSpot(p1));
	}

	@Test
	public void test() {
		
		/*
		 *  Case 1: See if can recognize out of bounds from top left corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN
		 *   d) For TurnNW
		 *   e) For TurnSE
		 *   f) For TurnWS
		 *   Each one of these has to be repeated for a rotate form of the path as well
		 */

		assertFalse("Case 1-a: did not work.",m.inValidSpot(p1));
		
		
	}

}
