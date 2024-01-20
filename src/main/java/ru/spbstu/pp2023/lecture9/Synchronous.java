package ru.spbstu.pp2023.lecture9;

import java.util.Random;

public class Synchronous {
	
	private static final class ObjComputer implements Runnable {
		private final Random r;
		private final RendezvousObject obj;

		private ObjComputer(Random r, RendezvousObject obj) {
			this.r = r;
			this.obj = obj;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(r.nextLong(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println(name + " is going to compute output ");
			obj.workWithInputAndProduceOutput();
			System.out.println(name + " has finished computing");
			
		}
	}

	private static final class ObjReader implements Runnable {
		private final Random r;
		private final RendezvousObject obj;

		private ObjReader(Random r, RendezvousObject obj) {
			this.r = r;
			this.obj = obj;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(r.nextLong(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			int input = r.nextInt(100);
			System.out.println(name + " is going into rendezvous object with input " + input);
			int result = obj.submitInputAndGetOutput(input);
			System.out.println(name + " has recieved from rendezvous object " + result);
			
		}
	}

	public static void main(String[] args) {
		
		while(true) {
			
			RendezvousObject obj = new RendezvousObject();
			Random r = new Random();
			Thread t1 = new Thread(new ObjReader(r, obj));
			Thread t2 = new Thread(new ObjComputer(r, obj));
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
