package shapes;

public class Data<T> {
	
	private T myData;
	
	public void createMyData( Class<T> classOfT ) throws 
	InstantiationException, IllegalAccessException
	{
		// forbidden: myData = new T();
		// so- solution to create T generic type using reflection
		myData = classOfT.newInstance();
	}
 
}