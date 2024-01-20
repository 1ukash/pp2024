package ru.spbstu.pp2023.lecture12;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Completables {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		CompletableFuture<Void> f = CompletableFuture.runAsync(
										() -> System.out.println("Hi from " + Thread.currentThread().getName())
									);
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(
				() -> Thread.currentThread().getName());
		
		f.get();
		System.out.println(f2.get());
		
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(
				() -> Thread.currentThread().getName());
		f3.thenAccept(name -> System.out.println(name  + "-> " + Thread.currentThread().getName()));
		f3.get();
		
		
		CompletableFuture<String> f4 = CompletableFuture.supplyAsync(
				() -> Thread.currentThread().getName());
		
		for (int i = 0; i < 5; i++) {
			f4 = f4.thenApplyAsync(name -> name  + "-> " + Thread.currentThread().getName());
		}
		System.out.println(f4.get());
		
	}

}
