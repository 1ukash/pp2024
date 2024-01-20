package ru.spbstu.pp2023.lecture12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.spbstu.pp2023.lecture6.DataClass;

public class EnhancedServer2 {
	
	static class ClientHandler implements Runnable {
		
		private Socket s;

		public ClientHandler(Socket s) {
			super();
			this.s = s;
		}

		@Override
		public void run() {
			
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(s.getInputStream());
				DataClass cl = (DataClass) ois.readObject();
				System.out.println(cl);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket server = new ServerSocket(10000);
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		while(true) {
			
			Socket s = server.accept();
			System.out.println(s);
			Future<?> f = pool.submit(new ClientHandler(s));
		}
		
	}

}
