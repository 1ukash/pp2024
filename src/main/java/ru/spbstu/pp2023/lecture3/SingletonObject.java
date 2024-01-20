package ru.spbstu.pp2023.lecture3;

public class SingletonObject {
	
	private static SingletonObject instance;
	
	private SingletonObject() {
		
	}
	
	public static SingletonObject getInstance() {
		
		if (instance == null) {
			instance = new SingletonObject();
		}
		
		return instance;
	}

}
