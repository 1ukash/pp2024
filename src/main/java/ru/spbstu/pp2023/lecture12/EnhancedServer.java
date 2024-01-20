package ru.spbstu.pp2023.lecture12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ru.spbstu.pp2023.lecture6.DataClass;

public class EnhancedServer {
	
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
		
		while(true) {
			
			Socket s = server.accept();
			System.out.println(s);
			new Thread(new ClientHandler(s)).start();
		}
		
	}

}
