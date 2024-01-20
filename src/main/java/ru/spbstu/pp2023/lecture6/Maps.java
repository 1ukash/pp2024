package ru.spbstu.pp2023.lecture6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Maps {
	public static void main(String[] args) {
		
		Map<String, String> data = new HashMap<>();
		
		data.put("A", "B");
		
		Map<String, String> s = Collections.singletonMap("X", "Y");
		s.put("Z", "A");
		
		
	}
}
