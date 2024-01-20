package ru.spbstu.pp2023.lecture3;

public class Rectangle extends Figure implements Colored, Flavored {

	private int color;
	private int flavor = GOOD_FLAVOR;
	
	@Override
	public int getColor() {
		return color;
	}

	@Override
	public int getFlavor() {
		return flavor;
	}
	
	public void copyColor(Colored c) {
		this.color = c.getColor();
	}

}
