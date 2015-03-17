import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PathPiecesConnected {
	
	Map m;
	Path p1; // Will be StraigthWE
	Path p2; // Will be StraigthWE rotated
	Path p3; // Will be StraightNS
	Path p4; // Will be StraigthNS rotated
	Path p5; // Will be TurnEN
	Path p6; // Will be TurnEN rotated
	Path p7; // Will be TurnNW
	Path p8; // Will be TurnNW rotated
	Path p9; // will be TurnSE
	Path p10; // will be TurnSE rotated
	Path p11; // will be TurnWS
	Path p12; // will be TurnWS rotated
	
	
	@Before
	public void setUp() throws Exception {
		m = new Map(10,10);
		p1 = new StraightWE(0,10);
		p2 = new StraightWE(0,10);
		p2.rotate();
		p3 = new StraightNS(0,10);
		p4 = new StraightNS(0,10);
		p4.rotate();
		p5 = new TurnEN(0,10);
		p6 = new TurnEN(0,10);
		p6.rotate();
		p7 = new TurnNW(0,10);
		p8 = new TurnNW(0,10);
		p8.rotate();
		p9 = new TurnSE(0,10);
		p10 = new TurnSE(0,10);
		p10.rotate();
		p11 = new TurnWS(0,10);
		p12 = new TurnWS(0,10);
		p12.rotate();
		/*
		System.out.println(p1.getEntrance());
		System.out.println(p1.getExit());
		System.out.println(m.inValidSpot(p1));
		*/
	}

	@Test
	public void test() {
		
		/*
		 *  Case 1: See if can recognize expecting out of bounds from top left corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN
		 *   d) For TurnNW (Should be true)
		 *   e) For TurnSE
		 *   f) For TurnWS
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */

		assertFalse("Case 1-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 1-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 1-c(r): did not work.",m.inValidSpot(p6));
		assertTrue("Case 1-d: did not work.",m.inValidSpot(p7));
		assertTrue("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 1-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 1-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 1-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 1-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 2: See if can recognize expecting out of bounds from top right corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN
		 *   d) For TurnNW
		 *   e) For TurnSE
		 *   f) For TurnWS (Should be true)
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 9 is the top right of a 10x10 grid
		p1 = new StraightWE(9,10);
		p2 = new StraightWE(9,10);
		p2.rotate();
		p3 = new StraightNS(9,10);
		p4 = new StraightNS(9,10);
		p4.rotate();
		p5 = new TurnEN(9,10);
		p6 = new TurnEN(9,10);
		p6.rotate();
		p7 = new TurnNW(9,10);
		p8 = new TurnNW(9,10);
		p8.rotate();
		p9 = new TurnSE(9,10);
		p10 = new TurnSE(9,10);
		p10.rotate();
		p11 = new TurnWS(9,10);
		p12 = new TurnWS(9,10);
		p12.rotate();
		
		assertFalse("Case 1-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 1-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 1-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 1-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 1-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 1-e(r): did not work.", m.inValidSpot(p10));
		assertTrue("Case 1-f: did not work.", m.inValidSpot(p11));
		assertTrue("Case 1-f(r): did not work.",m.inValidSpot(p12));
		//worked
		
		/*
		 *  Case 3: See if can recognize expecting out of bounds from bottom left corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN (Should be true)
		 *   d) For TurnNW
		 *   e) For TurnSE
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 90 is the top right of a 10x10 grid
		p1 = new StraightWE(90,10);
		p2 = new StraightWE(90,10);
		p2.rotate();
		p3 = new StraightNS(90,10);
		p4 = new StraightNS(90,10);
		p4.rotate();
		p5 = new TurnEN(90,10);
		p6 = new TurnEN(90,10);
		p6.rotate();
		p7 = new TurnNW(90,10);
		p8 = new TurnNW(90,10);
		p8.rotate();
		p9 = new TurnSE(90,10);
		p10 = new TurnSE(90,10);
		p10.rotate();
		p11 = new TurnWS(90,10);
		p12 = new TurnWS(90,10);
		p12.rotate();
		
		assertFalse("Case 1-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertTrue("Case 1-c: did not work.",m.inValidSpot(p5));
		assertTrue("Case 1-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 1-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 1-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 1-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 1-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 1-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 4: See if can recognize expecting out of bounds from bottom right corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN 
		 *   d) For TurnNW
		 *   e) For TurnSE (Should be true)
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 99 is the top right of a 10x10 grid
		p1 = new StraightWE(99,10);
		p2 = new StraightWE(99,10);
		p2.rotate();
		p3 = new StraightNS(99,10);
		p4 = new StraightNS(99,10);
		p4.rotate();
		p5 = new TurnEN(99,10);
		p6 = new TurnEN(99,10);
		p6.rotate();
		p7 = new TurnNW(99,10);
		p8 = new TurnNW(99,10);
		p8.rotate();
		p9 = new TurnSE(99,10);
		p10 = new TurnSE(99,10);
		p10.rotate();
		p11 = new TurnWS(99,10);
		p12 = new TurnWS(99,10);
		p12.rotate();
		
		assertFalse("Case 1-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 1-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 1-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 1-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertTrue("Case 1-e: did not work.",m.inValidSpot(p9));
		assertTrue("Case 1-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 1-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 1-f(r): did not work.",m.inValidSpot(p12));
		// Worked
		
		/*
		 *  Case 5: See if can recognize expecting out of bounds from top (excluding corners)
		 *   a) For StriaightWE
		 *   b) For StraightNS (false)
		 *   c) For TurnEN (false)
		 *   d) For TurnNW
		 *   e) For TurnSE (false)
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 1-8 is the top of a 10x10 grid (excludes the corners)
		p1 = new StraightWE(1,10);
		p2 = new StraightWE(2,10);
		p2.rotate();
		p3 = new StraightNS(3,10);
		p4 = new StraightNS(4,10);
		p4.rotate();
		p5 = new TurnEN(5,10);
		p6 = new TurnEN(6,10);
		p6.rotate();
		p7 = new TurnNW(7,10);
		p8 = new TurnNW(8,10);
		p8.rotate();
		p9 = new TurnSE(1,10);
		p10 = new TurnSE(2,10);
		p10.rotate();
		p11 = new TurnWS(3,10);
		p12 = new TurnWS(4,10);
		p12.rotate();
				
		assertTrue("Case 1-a: did not work.",m.inValidSpot(p1));
		assertTrue("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 1-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 1-c(r): did not work.",m.inValidSpot(p6));
		assertTrue("Case 1-d: did not work.",m.inValidSpot(p7));
		assertTrue("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 1-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 1-e(r): did not work.", m.inValidSpot(p10));
		assertTrue("Case 1-f: did not work.", m.inValidSpot(p11));
		assertTrue("Case 1-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 6: See if can recognize expecting out of bounds from bottom (excluding corners)
		 *   a) For StriaightWE
		 *   b) For StraightNS (false)
		 *   c) For TurnEN (false)
		 *   d) For TurnNW
		 *   e) For TurnSE (false)
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 91-98 is the top of a 10x10 grid (excludes the corners)
		p1 = new StraightWE(98,10);
		p2 = new StraightWE(97,10);
		p2.rotate();
		p3 = new StraightNS(96,10);
		p4 = new StraightNS(95,10);
		p4.rotate();
		p5 = new TurnEN(94,10);
		p6 = new TurnEN(93,10);
		p6.rotate();
		p7 = new TurnNW(92,10);
		p8 = new TurnNW(91,10);
		p8.rotate();
		p9 = new TurnSE(98,10);
		p10 = new TurnSE(97,10);
		p10.rotate();
		p11 = new TurnWS(96,10);
		p12 = new TurnWS(95,10);
		p12.rotate();
				
		assertTrue("Case 1-a: did not work.",m.inValidSpot(p1));
		assertTrue("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertTrue("Case 1-c: did not work.",m.inValidSpot(p5));
		assertTrue("Case 1-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 1-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertTrue("Case 1-e: did not work.",m.inValidSpot(p9));
		assertTrue("Case 1-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 1-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 1-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
	}

}
