package ru.spbstu.pp2023.lecture6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		FileOutputStream fos = new FileOutputStream("/tmp/objects");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new DataClass(1, "test", 2L));
		oos.close();
		
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/objects"));
		DataClass dt = (DataClass) ois.readObject();

	}
}
