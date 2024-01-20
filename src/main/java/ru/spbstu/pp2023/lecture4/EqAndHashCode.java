package ru.spbstu.pp2023.lecture4;

import java.util.Date;

public class EqAndHashCode {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person(1, "Ivan", "Ivanov", new Date());
		Person p2 = new Person(1, "Ivan", "Ivanov", new Date());
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		System.out.println(p1);
		System.out.println(p2);
		
		Person p3 = new Person(2, "Semen", "Petrov", new Date());
		p3.setLivingAdress(new Address("Crossroads av", 2));
		Person p4 = (Person) p3.clone();
		
		System.out.println(p3);
		System.out.println(p4);
		
		Class cl1 = p2.getClass();
		Class cl2 = p1.getClass();
		System.out.println(cl1 == cl2);
		
	}
	
}
