package Critters;

import java.util.ArrayList;
import java.util.List;


public abstract class Subject {
	private List<Iobserver> observers;

	public Subject()
	{
		observers = new ArrayList<Iobserver>();
	}
	protected void notifyAllObservers()
	{
		
		for(Iobserver o : observers)
		{
			o.update();
		}
	}
	 public void add(Iobserver observer)
	 {
	      observers.add(observer);		
	   }
}

//protected void notifyObservers() {
//	for (IObserver o : observers) {
//		o.update();
//	}