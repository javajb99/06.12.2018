package shapes;

public class Triangle implements Drawable, Printable{
 
	public int x, y;
	private int privateData = 42;
	
	public Triangle()
	{
		
	}
	public Triangle(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	private void secrt()
	{
		System.out.println("Secret....");
	}
	
	public void draw()
	{
		System.out.println("Drawing....");
	}
	
	@Override
	public String toString() {
		return "Triangle [x=" + x + ", y=" + y + ", privatdeData=" + privateData + "]";
	}
	
	
	
}