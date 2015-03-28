import java.util.ArrayList;
import java.util.List;


public abstract class Subject {
	private List<Iobserver> observers;
//	private double life=10;
//	private double money=100;
	
	public Subject()
	{
		observers = new ArrayList<Iobserver>();
	}
	protected void notifyAllObservers()
	{
		for(Iobserver observer : observers)
		{
			observer.update();
		}
	}
	 public void add(Iobserver observer)
	 {
	      observers.add(observer);		
	   }


}
