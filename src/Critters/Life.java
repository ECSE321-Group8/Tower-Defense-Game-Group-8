package Critters;

public class Life extends Subject {

	protected Life(int life)
	{
		this.life=life;
	}
	public int getLife()
	{
		return life;
	}
	public void decreaseLife(int life)
	{
			this.life=this.life-life;
			notifyAllObservers();
	}
	private int life;
	//private final int initialLife = 10;


}
