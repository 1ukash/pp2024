package ru.spbstu.pp2023.lecture6;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IO {
	
	public static void main(String[] args) throws IOException {
		
		OutputStream fos = new FileOutputStream("/tmp/data");
		BufferedOutputStream buf = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(buf);
		
		String toWrite = "Abc xyz";
		
		dos.writeUTF(toWrite);
		dos.writeInt(10);
		dos.writeDouble(0.01);
		
		dos.close();
		
		
		DataInputStream dis = new DataInputStream(new FileInputStream("/tmp/data"));
		
		String readS = dis.readUTF();
		int readI = dis.readInt();
		double readD = dis.readDouble();
		
		dis.close();
		
		
	}

}
