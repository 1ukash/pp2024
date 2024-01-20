package ru.spbstu.pp2023.lecture4;

import java.util.Date;

public class Person implements Cloneable {

	private int passportId;
	private String name;
	private String secondName;
	private Date birthDate;
	private Address livingAdress;

	public Person(int passportId, String name, String secondName, Date birthDate) {
		super();
		this.passportId = passportId;
		this.name = name;
		this.secondName = secondName;
		this.birthDate = birthDate;
	}

	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getLivingAdress() {
		return livingAdress;
	}

	public void setLivingAdress(Address livingAdress) {
		this.livingAdress = livingAdress;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Person)) {
			return false;
		}
		
		return obj == this || this.passportId == ((Person) obj).passportId;
	}
	
	@Override
	public int hashCode() {
		return passportId;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("{").append(passportId).
				append(".").append(name).append(".").append(secondName).append(".")
				.append(birthDate).append(livingAdress).append("}@").append(super.hashCode()).toString();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		Person copy = (Person) super.clone();
		copy.setLivingAdress((Address) getLivingAdress().clone());
		return copy;
	}

}
