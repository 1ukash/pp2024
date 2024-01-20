package ru.spbstu.pp2023.lecture2;

public class ImmutableData {
	
	
	private long data;
	

	public ImmutableData(long data) {
		super();
		this.data = data;
	}

	public long getData() {
		return data;
	}

	public ImmutableData setData(long data) {
		
		if (data == this.data)
			return this;
		
		return new ImmutableData(data);
	}
}
