package ru.spbstu.pp2023.lecture12;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures2 {
	
	private static final int TASKS_NUM = 10;

	static class ComputeTask implements Callable<Integer> {
		
		private int num;
		
		public ComputeTask(int num) {
			super();
			this.num = num;
		}

		@Override
		public Integer call() throws Exception {
			System.out.println(new Date() + " " + Thread.currentThread().getName() + " task with num " + num + " has started exec ");
			try {
				Thread.sleep(new Random().nextLong(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new Date() + " " + Thread.currentThread().getName() + " task with num " + num + " has finished exec ");
			// TODO Auto-generated method stub
			return num * num;
		}
		
	}
	
	static ExecutorService pool = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Set<Future<Integer>> futures = new HashSet<>();
		
		for (int i = 0; i < TASKS_NUM; i ++) {
			Future<Integer> f = pool.submit(new ComputeTask(i));
			futures.add(f);
		}
		
		//do other staff
		
		int done = 0;
		
		while (done < TASKS_NUM) {
			
			Set<Future<Integer>> finished = new HashSet<>();
			for (Future<Integer> f: futures) {
				if (f.isDone()) {
					finished.add(f);
					int res = f.get();
					System.out.println(new Date() + " " + "task is completed with result " + res);
					done ++;
				}
			}
			
			futures.removeAll(finished);
			
		}
		
		
	}

}
