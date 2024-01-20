package ru.spbstu.pp2023.lecture8;

public class MonitorsAndFriends {
	
	static class MonitorObject {
		int counter = 0;
		
	}
	
	public static void main(String[] args) {
		
		MonitorObject obj = new MonitorObject();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					
					synchronized (obj) {
						
						obj.counter++;
						System.out.println("Obj is incremented. Will wait for read notification. ");
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							Thread.currentThread().interrupt();
						}
						
						
					}
					
					
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
					
					synchronized (obj) {
						System.out.println("After sleeping I have read counter and it is equal to " + obj.counter);
						obj.notify();
					}

					
				}
				
			}
			
		}).start();
		
		
	}

}
