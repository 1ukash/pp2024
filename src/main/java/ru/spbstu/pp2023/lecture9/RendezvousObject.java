package ru.spbstu.pp2023.lecture9;

public class RendezvousObject {
	
	
	private Integer inputData;
	private Integer outputData;
	
	
	public int submitInputAndGetOutput(int input) {
		
		inputData = input;
		
		synchronized (this) {
			notify();
		}
		
		while(outputData == null) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		return outputData;
		
	}
	
	public void workWithInputAndProduceOutput() {
		
		while(inputData == null) {
			synchronized(this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		// input is not null, go to compute
		outputData = inputData * 2;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			notify();
		}
		
	}
	

}
