package ru.spbstu.pp2023.lecture2;

public class SomeFirstExamples {
	
	static int id = 5;
	
	static final int X = 3;
	static final PojoExample EX = new PojoExample(5, "x", 200);
	
	
	private String name;
	
	public SomeFirstExamples(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		foo();
		SomeFirstExamples sfe = new SomeFirstExamples("My name");
		sfe.bar();
		
		var ex1 = new PojoExample(5, "x", 200);
		EX.setAge(10);
		
		System.out.println(ex1);
		System.out.println(EX);
		
		ImmutableData data = new ImmutableData(10);
		data = data.setData(11);
		
	}
	
	static void foo() {
		id = 6;
	}
	
	private void bar() {
		
	}
}
