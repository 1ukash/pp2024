package ru.spbstu.pp2023.lecture3;

public abstract class AbstractExample {
	
	private int var;

	public int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}

	abstract void doSmthNonAbstract();

}
