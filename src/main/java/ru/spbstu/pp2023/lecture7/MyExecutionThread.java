package ru.spbstu.pp2023.lecture7;

import java.util.Date;

public class MyExecutionThread implements Runnable {

	@Override
	public void run() {
		
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("I am still here " + new Date());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		
	}

}
