package ru.spbstu.pp2023.lecture4;

public class Address implements Cloneable{
	private String street;
	private int house;

	public Address(String street, int house) {
		super();
		this.street = street;
		this.house = house;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}
	
	@Override
	public String toString() {
		return "{" + street + "." + house + "}@" + super.hashCode();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
