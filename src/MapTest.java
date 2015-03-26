import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MapTest {
//	Initialize variables 
	Map m;
		
	@Before
	public void setUp()throws Exception{
		m=Map.getInstance();
		m.setMap(5,5);	
	}
	

	@Test
	public void test() {
//		STEP#1: map has been created, but no tiles have been initialized
//			a)entryPoint=exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()==null&&m.getExitPoint()==null));
//			b)linked list isEmpty
			assertTrue("LinkedList is not empty", Map.temp.isEmpty());
//			c)grid should be initialized all to null
//			d)check if the following methods can handle this condition 
//				-FINALIZE (does nothing)
//				-DELETE	(does nothing)
//				-ADD		(adds entryPoint)
			
//		STEP#2: only the start point has been assigned
//			a)entryPoint!=NULL && exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()==null));
//			b)linked list isEmpty
			assertTrue("LinkedList is not empty", Map.temp.isEmpty());
//			c)grid should be initialized all to null, expect entryPoint
//			d)check if the following methods can handle this condition 
//				-FINALIZE (does nothing)
//				-DELETE (deletes entryPoint)
//				-ADD(adds other tiles)
			
//		STEP#3: other tiles have been initialized 
//			a)entryPoint!=NULL && exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()==null));
//			b)linked list !isEmpty
//			c)path on the grid should be initialized, rest should be null
//			e)check if the following methods can handle this condition 
//				-DELETE (deletes last)
//				-ADD
//					~not connected
//					~intersections
//					~going back
//				-FINALIZE (ends path)	
			
			
//		STEP#4: Finalize Path
//			a)entryPoint!=NULL && exitPoint!=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()!=null));
//			b)linked list !isEmpty
//			c)path on the grid should be initialized, rest should be null
//			e)check if the following methods can handle this condition 
//				-FINALIZE (can't finalize twice)
//				-ADD (does not do anything)
//				-DELETE (can delete -- begin to edit again)

//		STEP#5:Set rest to scenery 		
//			a)entryPoint!=NULL && exitPoint!=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()!=null));
//			b)linked list !isEmpty
//			c)path on the grid should be initialized, rest should be scenery
			

//		STEP#6: Edit Path once it has been finalized and rest has been set to scenery
//			can't add right away
//			must delete first
//			ADD
//			a)entryPoint!=NULL && exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()==null));
//			b)linked list !isEmpty
//			c)path on the grid should be initialized +mix of scenery and null

//		STEP#7:Final outcome (set to scenery) 
			System.out.println("Entry Point:"+ m.getEntryPoint().getPos());
			System.out.println("Exit Point:"+ m.getExitPoint().getPos());
			m.printPath();
			m.printGrid();
	}

}
