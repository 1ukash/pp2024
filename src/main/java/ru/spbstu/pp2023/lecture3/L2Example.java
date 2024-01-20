package ru.spbstu.pp2023.lecture3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import ru.spbstu.pp2023.lecture3.VeryLargeImportantClass.AccessToPublicOnly;

// default
// final -- no inheritance
public class L2Example {
	
	//static belongs to class
	private static int val = 5;
	private int var = 7;
	
	class InnerClass {
		
		private int another;
		
		public InnerClass(int another) {
			super();
			this.another = another;
		}

		public int getVarPlusAnother() {
			return var + another;
		}
	}
	
	static class InnerStaticClass {
		
	}
	
	static {
		val = 4;
	}
	
	{
		var = 3;
	}
	
	public L2Example(int var) {
		super();
		this.var = var;
	}

	public L2Example() {
		super();
	}
	
	
	public static final void mutateVal(int v) {
		val = v;
	}

	public int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}
	
	private void foo() {
		
	}
	
	protected void bar() {
		InnerClass c = new InnerClass(10);
	}
	
	public static void main(String[] args) {
		Colored fig = new Rectangle();
		
		if (fig instanceof Rectangle) {
			
		}
		
		AbstractExample ex = new NonAbstractExample();
		
		L2Example ex2 = new  L2Example();
		InnerClass c = ex2.new InnerClass(10);
		
		
		VeryLargeImportantClass obj = new VeryLargeImportantClass();
		
		AccessToPublicOnly data = obj.giveOthersSomeData();
		data.getPublicData();
		
	}
	
	private void largeComputeMethod() {
		
		
		class Point {
			int x, y;
		}
		
		// use point
		
	}
	
	static class OKButtonListener implements MouseListener{

		@Override
		public void onClick() {
			System.out.println("OK");
		}
		
	}
	
	private void workWithUI() {
		Button ok = new Button();
		ok.setListener(new OKButtonListener());
		
		Button cancel = new Button();
		cancel.setListener(new MouseListener() {

			@Override
			public void onClick() {
				System.out.println("CANCEL");				
			}
			
		});
		
		JButton button = new JButton();
		button.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
