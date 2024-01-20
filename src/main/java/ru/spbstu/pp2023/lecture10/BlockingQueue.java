package ru.spbstu.pp2023.lecture10;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
	
	private List<T> elements = new LinkedList<>();
	private final int capacity;
	
	public BlockingQueue(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	
	public void put(T elem) throws InterruptedException {
		
		synchronized (this) {
			while (elements.size() == capacity) {
				wait();
			}
			elements.add(elem);
		}
		
		synchronized (this) {
			notify();
		}
		
	}
	
	public T take() throws InterruptedException {
		T res;
		synchronized(this) {
			while (elements.isEmpty()) {
				wait();
			}
			res = elements.remove(0);
		}
		
		synchronized (this) {
			notify();
		}
		return res;
	}

}
