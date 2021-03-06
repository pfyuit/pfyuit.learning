package com.pfyuit.myalgorithm.datastructure.queue;

/**
 * @author yupengfei
 */
public class PriorityQueueByArray {

	private long[] data;
	private int size;
	private int maxSize;

	public PriorityQueueByArray(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		data = new long[maxSize];
	}

	/**
	 * Is priority queue empty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Is priority queue full
	 * @return
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	/**
	 * Insert data
	 * @param value
	 */
	public void insert(long value) {
		// something like insert sort
		int i;
		for (i = size - 1; i >= 0; i--) {
			if (data[i] < value) {
				data[i + 1] = data[i];
			} else {
				break;
			}
		}
		data[i + 1] = value;
		size++;
	}

	/**
	 * Remove data from tail (small one)
	 * @return
	 */
	public long remove() {
		long temp = data[size - 1];
		size--;
		return temp;
	}

	public static void main(String[] args) {
		PriorityQueueByArray queue = new PriorityQueueByArray(100);
		queue.insert(45);
		queue.insert(12);
		queue.insert(134);
		queue.insert(121);
		queue.insert(33);
		queue.insert(14);
		queue.insert(800);

		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + " ");
		}
	}

}
