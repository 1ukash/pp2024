package ru.spbstu.pp2023.lecture5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Exceptions {
	
	public static void main(String[] args) {
		
		foo();
		try {
			bar();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(tryFinallyReturn()[0]);
		
		try {
			uncheckedExample(null);
		} catch (MyAppException e) {
			e.printStackTrace();
		}
		
		myRuntimeExcpetion();
		
	}

	private static void myRuntimeExcpetion() {
		throw new MyAppRuntimeException();
	}

	private static int[] tryFinallyReturn() {
		int[] arr = new int[1];
		arr[0] = 0;
		try {
			arr[0]++;
			return arr;
		} finally {
			arr[0]++;
		}
		
	}

	private static void uncheckedExample(Object obj) throws MyAppException {
		
		try {
			obj.toString();
		} catch (NullPointerException e) {
			throw new MyAppException("something is null somehow", e);
		}
	}

	private static void bar() throws IOException {
		File f = new File("/tmp/x");
		
		FileInputStream fis = new FileInputStream(f);
		fis.read();

	}

	private static void foo() {
		
		File f = new File("/tmp/x");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			fis.read();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
