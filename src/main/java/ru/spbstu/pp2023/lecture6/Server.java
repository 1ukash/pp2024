package ru.spbstu.pp2023.lecture6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket server = new ServerSocket(10000);
		
		while(true) {
			Socket s = server.accept();
			System.out.println(s);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			DataClass cl = (DataClass) ois.readObject();
			System.out.println(cl);
			
		}
		
	}

}
