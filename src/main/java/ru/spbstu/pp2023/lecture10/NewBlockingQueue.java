package ru.spbstu.pp2023.lecture10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewBlockingQueue<T> {
	
	private List<T> elements = new LinkedList<>();
	private final int capacity;
	
	private Lock l = new ReentrantLock();
	private Condition condEmpty = l.newCondition();
	private Condition condFull = l.newCondition();
	
	public NewBlockingQueue(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	
	public void put(T elem) throws InterruptedException {
		
		
		l.lock();
		try {
			while (elements.size() == capacity) {
				condFull.await();
			}
			elements.add(elem);
		} finally {
			l.unlock();
		}
		
		try {
			l.lock();
			condEmpty.signal();
		} finally {
			l.unlock();
		}
		
	}
	
	public T take() throws InterruptedException {
		T res;
		try {
			l.lock();
			while (elements.isEmpty()) {
				condEmpty.await();
			}
			res = elements.remove(0);
		} finally {
			l.unlock();
		}
		
		try {
			l.lock();
			condFull.signal();
		} finally {
			l.unlock();
		}
		return res;
	}

}
