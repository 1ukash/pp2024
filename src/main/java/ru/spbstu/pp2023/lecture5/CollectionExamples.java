package ru.spbstu.pp2023.lecture5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionExamples {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.println(i);
		}
		
		for (Integer i: list) {
			System.out.println(i);
		}
		
		Set<String> s = new HashSet<>();
		s.add("A");
		s.add("B");
		s.add("B");
		System.out.println(s.toString());
		
		
		Set<CompObj> sorted = getCurrentSet();
		System.out.println(sorted.toString());
		
		sorted.add(new CompObj(1001, "Y"));

		
	}
	
	public static Set<CompObj> getCurrentSet() {
		Set<CompObj> sorted = new TreeSet<>();
		for (int i = 10; i > 0; i--) {
			sorted.add(new CompObj(i, "x." + i));
		}
		return Collections.unmodifiableSet(sorted);
	}

}
