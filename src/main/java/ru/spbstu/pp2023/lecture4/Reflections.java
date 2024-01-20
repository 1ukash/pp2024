package ru.spbstu.pp2023.lecture4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Reflections {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Person p = new Person(1, "Ivan", "Ivanov", new Date());
		
		Class clazz = p.getClass();
		
		for (Method m: clazz.getMethods()) {
			System.out.println(m.getName());
			
			if (m.getName() == "toString") {
				System.out.println(m.invoke(p));
			}
		}
		
		System.out.println();
		
		for (Method m: clazz.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		
		Class clazz2 = Address.class;
		
		Class cl = Class.forName("ru.spbstu.pp2023.lecture4.Address");
		Object instance = cl.getDeclaredConstructor(String.class, int.class).newInstance("x",1);
		
	}

}
