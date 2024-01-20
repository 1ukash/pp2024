package ru.spbstu.pp2023.lecture8;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCenter {
	
	static class Accountable {
		private int account;
		private int goodsNum;
		
		public Accountable(int account, int goodsNum) {
			super();
			this.account = account;
			this.goodsNum = goodsNum;
		}

		public int getAccount() {
			return account;
		}

		public void setAccount(int account) {
			this.account = account;
		}

		public int getGoodsNum() {
			return goodsNum;
		}

		public void buyGoods(int goodsNum) {
			this.goodsNum += goodsNum;
			this.account -= PRICE * goodsNum;
		}
		
		public void sellGoods(int goodsNum) {
			this.goodsNum -= goodsNum;
			this.account += PRICE * goodsNum;
		}
		
	}
	
	
	static class Buyer extends Accountable implements Runnable {
		private Seller seller;
		
		public Buyer(Seller seller) {
			super(INITIAL_VAL, 0);
			this.seller = seller;
		}

		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted() ) {
				
				if (getAccount() < PRICE) {
					break;
				}
				
				synchronized (seller) {
					
					if (seller.goodsNum == 0) {
						break;
					}
					
					seller.sellGoods(1);
				}
				
				buyGoods(1);
			}
		}
		
	}
	
	static class Seller extends Accountable {
		
		public Seller() {
			super(0, GOODS_VAL);
		}
		private int account = 0;
		private int goodsNum = GOODS_VAL;
		
	}

	private static final int INITIAL_VAL = 1000000;
	private static final int GOODS_VAL = 1000000;
	private static final int BUYERS_NUM = 10;
	private static final int PRICE = 1;
	
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Before we started we had " + INITIAL_VAL * BUYERS_NUM + " monets and goods value is " + GOODS_VAL);
		Seller seller = new Seller();
		List<Buyer> buyers = new LinkedList<>();
		
		List<Thread> buyersThreads = new LinkedList<>();
		for (int i = 0; i < BUYERS_NUM; i++) {
			Buyer b = new Buyer(seller);
			Thread t = new Thread(b);
			t.start();
			buyers.add(b);
			buyersThreads.add(t);
		}
		
		for (Thread t: buyersThreads)
			t.join();
		
		// count results
		int val = seller.account;
		int goods = seller.goodsNum;
		for (Buyer b: buyers) {
			val += b.getAccount();
			goods += b.getGoodsNum();
		}
		
		System.out.println("After we started we have " + val + " monets and " + goods + " goods.");
	}

}
