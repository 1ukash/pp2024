package ru.spbstu.pp2023.lecture9;

public class DeadLockExample {
	
	
	private static final int DELAY = 1000;
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					
					synchronized(lock1) {
						
						try {
							Thread.sleep(DELAY / 2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " Acquired lock1");
						synchronized (lock2) {
							System.out.println(Thread.currentThread().getName() + "Acquired lock2");
//							try {
//								//Thread.sleep(DELAY);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
						}
					}
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(lock1) {
						

						System.out.println(Thread.currentThread().getName() + " Acquired lock1");
						synchronized (lock2) {
							System.out.println(Thread.currentThread().getName() + " Acquired lock2");
//							try {
//								//Thread.sleep(DELAY);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
						}
					}
				}
			}
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
		
		
	}

}
