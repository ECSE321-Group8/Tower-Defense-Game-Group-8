import views.MapSize;


public class driver {

	public static void main(String[] args) {
		
		Tile t1 = new StraightWE(5);
		Path p1 = (Path)t1;
		System.out.println();
		StraightWE s1 = new StraightWE(5);
		Tile t2 = s1;
		System.out.println(s1.getEntry());
		System.out.println(s1.getExit());
		System.out.println((double)-1/10);
		System.out.println(99/10);
		
		MapSize ms = new MapSize();
		// Works

	}

}
