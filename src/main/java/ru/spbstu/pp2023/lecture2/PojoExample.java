package ru.spbstu.pp2023.lecture2;

public class PojoExample {

	private int number;
	private String name;
	private long age;

	public PojoExample(int number, String name, long age) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

}
