package ru.spbstu.pp2023.lecture7;

public class ThreadsExamples {
	
	public static void main(String[] args) throws InterruptedException {
		MyExecutionThread met = new MyExecutionThread();
		
		Thread thread = new Thread(met, "My thread");
		thread.start();
		
		Thread.sleep(10000);
		thread.interrupt();
		
		//thread.join();
	}

}
