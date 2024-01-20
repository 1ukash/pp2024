package ru.spbstu.pp2023.lecture10;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadersWriters {
	
	Semaphore sem = new Semaphore(5);
	{
		try {
			sem.acquire();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sem.release();
		}
	}
	
	static int val = 0;
	
	
	public static void main(String[] args) {
	
		ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
		
		Lock read = rwLock.readLock();
		Lock write = rwLock.writeLock();
		
		for (int i =0; i < 10; i++ ) {
			
			Runnable reader = new Runnable() {
				
				@Override
				public void run() {
					while(!Thread.currentThread().isInterrupted()) {
						try {
							read.lock();
							System.out.println(Thread.currentThread().getName() + " has read " + val);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} finally {
							read.unlock();
						}
					}
				}
			};
			new Thread(reader).start();
		}
		
		for (int i =0; i < 2; i++ ) {
			
			Runnable writer = new Runnable() {
				
				@Override
				public void run() {
					while(!Thread.currentThread().isInterrupted()) {
						if (write.tryLock()) {
							try {
								val ++;
								System.out.println(Thread.currentThread().getName() + " has written " + val);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							} finally {
								write.unlock();
							}
						} else {
							System.out.println(Thread.currentThread().getName() + " didn't manage to take a lock");
						}
					}
				}
			};
			new Thread(writer).start();
		}
		
		
	}

}
