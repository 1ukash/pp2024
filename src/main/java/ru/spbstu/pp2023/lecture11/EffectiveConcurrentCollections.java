package ru.spbstu.pp2023.lecture11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EffectiveConcurrentCollections {
	
	static AtomicInteger counter = new AtomicInteger(0);
	
	private void bar() {
		int res = counter.incrementAndGet();
		res = counter.addAndGet(5);
	}
	
	public static void main(String[] args) {
		
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
	
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i  = 0;
				while(!Thread.currentThread().isInterrupted()) {
					list.add(i++);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int j = 0;
				while(!Thread.currentThread().isInterrupted()) {
					
					for (Integer i: list) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("iteration " + j + " with i=" + i);
					}
					
					j++;
					
				}
			}
		}).start();
		
		
		
		
	}
	
	private void foo() {
		List<Integer> list = new ArrayList<>();
		list = Collections.synchronizedList(list);
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		for (Integer i: list) {
			
			if (i == 3) {
				list.add(5);
			} else {
				System.out.println("just iterating over with element " + i);
			}
			
		}
		
		// if many threads
		synchronized(list) {
			for (Integer i: list) {}
		}
	}

}
