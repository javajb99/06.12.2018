package reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
 
import shapes.Triangle;
 
public class Main {
 
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
 
		// Create normally...
		Triangle t1 = new Triangle(2, 2);
		System.out.println(t1);
		
		
		
		Object obj2 = t1;
		System.out.println( obj2.getClass());
		System.out.println("=========================================");
		

		// looking at class of Triangle getClass
		System.out.println(t1.getClass());


		// what happen if we getClass many times...?
		
		Class triangleClass = t1.getClass();
		
		
		System.out.println(triangleClass);
		System.out.println(triangleClass.getClass());
		

		System.out.println(triangleClass.getClass().getClass().getClass().getClass());


		// Object pointing to class will have the same getClass
		Object o = new Object();
		Class objectClass = o.getClass();
		System.out.println(objectClass);
		

		System.out.println(objectClass.getName());
		

		o = new Triangle(1, 1);
		System.out.println(o.getClass());
		
		// shapes.Triangle.class option
		Class c1 = shapes.Triangle.class;
		System.out.println(c1  == o.getClass());
		
		// Class.forName option
		Class c5;
		try {
			c5 = Class.forName("shapes.Triangle");
			System.out.println(c5);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		// interfaces also have getClass
		Class c6 = Class.forName("shapes.Printable");
		System.out.println(c6.getName());
		
		// we can ask the class if it points to an interface object
		System.out.println(c6.isInterface());
		System.out.println(c1.isInterface());

		// we can get all of the implemented interfaces of the object
		Class[] interfaces = c1.getInterfaces();
		for(Class inter : interfaces)
		{
			System.out.println(inter.getName());
		}

		// we can check if the class is abstract using modifiers
		Class classAbstract = shapes.ShapesAbs.class;
		int modi = classAbstract.getModifiers();
		System.out.println(
				Modifier.isAbstract(modi)
				);
		
		// public fields
		c1 = shapes.Triangle.class;
		Field[] publicFields = c1.getFields();
		for(Field f : publicFields)
		{
			System.out.println(f.getName()
					+ " : " +
					f.getType());
		}	
		int x;
		
		// getting ctros of the class
		Class intclass = int.class;
		System.out.println("************ " + intclass);
		Constructor[] con1 =  intclass.getConstructors();
		System.out.println("con1.length: " + con1.length);
		
		// printing ctors of the class
		c1 = shapes.Triangle.class;
		Constructor[] constructors = c1.getConstructors();
		int index = 1;
		for(Constructor c : constructors)
		{
			System.out.println("======== Printing Constructor number " + index++);
			Class[] params = c.getParameterTypes();
			System.out.println("Number of params for this constructor: " + params.length);
			for(Class param : params)
			{
				System.out.println(param.getName());
			}			
		}
		
		// creating class with reflection -- newInstance
		c1 = shapes.Triangle.class;
		// 100% equals to ==> tnew = new Triangle();		
		Triangle tnew = (Triangle)Triangle.class.newInstance();
		
		// calling ctor with 2 parameters using reflection
		Class[] twoInts = new Class[2];
		twoInts[0] = int.class;
		twoInts[1] = String.class ;
		Constructor twoIntsCtor = c1.
						getConstructor(twoInts);
		
		Object[] constructor_argumetns = {2, 4};
		// 100% equals to ==> tnew = new trianlge(2, 4);		
		tnew = (Triangle)twoIntsCtor.newInstance
				( constructor_argumetns );
		System.out.println(tnew);
		
		// modifying field value
		Field xfield = Triangle.class.getField("x");
		System.out.println( "x = " + xfield.get(tnew) );
		
		xfield.setInt(tnew, 10);
		
		System.out.println(tnew);
		
		// accessing private field
		Field privateDataDescriptor = 
				c1.getDeclaredField("privateData");
		privateDataDescriptor.getName();
		privateDataDescriptor.setAccessible(true);	
		System.out.println(privateDataDescriptor.getInt(tnew));
		
		privateDataDescriptor.set(tnew, 50);
		
		//System.out.println(tnew);
		// invoking method using reflection
		Method method1 = shapes.Triangle.class.getMethod
				("secret", null); 
		System.out.println(method1);
		method1.invoke(tnew, null);
 
	}
 
}