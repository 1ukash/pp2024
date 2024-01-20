package ru.spbstu.pp2023.lecture5;

public class CompObj implements Comparable<CompObj>{

	private int id;
	private String name;
	
	
	
	public CompObj(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + id + " " + name + "]";
	}

	@Override
	public int compareTo(CompObj o) {
		
		if (o.id ==this.id)
			return 0;
		
		return id > o.id ? 1: -1;
	}

}
