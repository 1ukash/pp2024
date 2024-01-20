package ru.spbstu.pp2023.lecture6;

import java.io.Serializable;

public class DataClass implements Serializable {

	private static final long serialVersionUID = -587040073609299559L;
	
	private int num;
	private String name;
	private long id;
	
	private transient String connectionName;
	
	public DataClass(int num, String name, long id) {
		super();
		this.num = num;
		this.name = name;
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString() + ", id=" + id + ", name=" + name + ",num=" + num;
	}
}
