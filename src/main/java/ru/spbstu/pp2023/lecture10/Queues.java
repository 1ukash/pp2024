package ru.spbstu.pp2023.lecture10;

import java.util.Date;
import java.util.Random;

public class Queues {
	
	
	static NewBlockingQueue<Date> q = new NewBlockingQueue<>(20);
	static Random r = new Random();
	
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					
					try {
						Date d = new Date();
						q.put(d);
						System.out.println(Thread.currentThread().getName() + " wrote " + d);
						Thread.sleep(r.nextLong(500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					
					try {
						Date d = q.take();
						System.out.println(Thread.currentThread().getName() + " read " + d);
						Thread.sleep(r.nextLong(2000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
	}
	

}
