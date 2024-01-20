package ru.spbstu.pp2023.lecture6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 10000);
		DataClass data = new DataClass(10, "DDD", 20L);
		ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
		dos.writeObject(data);
		s.close();
	}

}
