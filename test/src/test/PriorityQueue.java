package test;

import java.util.Arrays;

public class PriorityQueue {
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public PriorityQueue(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}

	public void insert(long item) {
		int j;
		if (nItems == 0) {
			queArray[nItems++] = item;
		} else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queArray[j]) {
					queArray[j + 1] = queArray[j];
				} else {
					break;
				}
			}
			queArray[j + 1] = item;
			nItems++;
		}
	}
	
	public long remove(){
		return queArray[--nItems];
	}
	
	public long peekMin(){
		return queArray[nItems-1];
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	
	@Override
	public String toString() {
		return "PriorityQueue [maxSize=" + maxSize + ", queArray="
				+ Arrays.toString(queArray) + ", nItems=" + nItems + "]";
	}

	public static void main(String[] args) {
		PriorityQueue prique = new PriorityQueue(5);
		prique.insert(30);
		prique.insert(10);
		prique.insert(20);
		prique.insert(50);
		prique.insert(40);
		System.out.println(prique);
		while(!prique.isEmpty()){
			long item = prique.remove();
			System.out.println(item+" ");
		}
			
	}
}
