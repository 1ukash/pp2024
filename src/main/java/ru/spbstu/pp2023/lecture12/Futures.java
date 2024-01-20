package ru.spbstu.pp2023.lecture12;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Futures {
	
	static ExecutorService pool = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i < 10; i++) {
			
			final int num = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println(new Date() + " " + Thread.currentThread().getName() + " task with num " + num + " has started exec ");
					try {
						Thread.sleep(new Random().nextLong(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(new Date() + " " + Thread.currentThread().getName() + " task with num " + num + " has finished exec ");
				}
			};
			
			pool.submit(task);
			System.out.println(new Date() + " " + "submitted task with num " + num);
		
		}
		
		
		
	}

}
