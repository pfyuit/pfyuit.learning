package com.pfyuit.java.util.concurrent;

import java.util.Deque;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeTest {

	private Deque<Integer> deque = new ConcurrentLinkedDeque<Integer>();

	public Deque<Integer> getDeque() {
		return deque;
	}

	public void setDeque(Deque<Integer> deque) {
		this.deque = deque;
	}

	public static class MyReadThread extends Thread {

		private Deque<Integer> deque;

		public MyReadThread(Deque<Integer> deque) {
			this.deque = deque;
		}

		public void run() {
			while (true) {
				Integer i = deque.pollFirst();
				System.out.println(Thread.currentThread().getName() + " pollFirst => " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class MyWriteThread extends Thread {

		private Deque<Integer> deque;

		public MyWriteThread(Deque<Integer> deque) {
			this.deque = deque;
		}

		public void run() {
			while (true) {
				Integer i = new Random().nextInt();
				deque.addLast(i);
				System.out.println(Thread.currentThread().getName() + " addLast => " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		ConcurrentLinkedDequeTest test = new ConcurrentLinkedDequeTest();
		new MyReadThread(test.getDeque()).start();
		new MyWriteThread(test.getDeque()).start();
	}
}
