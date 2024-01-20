package ru.spbstu.pp2023.lecture9;

public class MonitorObject {
	
	private int state;
	private String stringState;
	
	public synchronized int getState() {
		return state;
	}
	
	public synchronized void setState(int state) {
		this.state = state;
	}
	
	public synchronized String getStringState() {
		return stringState;
	}
	
	public synchronized void setStringState(String stringState) {
		this.stringState = stringState;
	}
}
