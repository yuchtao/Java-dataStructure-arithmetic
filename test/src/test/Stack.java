package test;

import java.util.Arrays;

public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	
	@Override
	public String toString() {
		return "Stack [maxSize=" + maxSize + ", stackArray="
				+ Arrays.toString(stackArray) + ", top=" + top + "]";
	}

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		stackArray =new long[maxSize];
		top = -1;
	}
	
	public void push(long arrayLong){
		stackArray[++top] = arrayLong;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public static void main(String[] args) {
		Stack stacktest = new Stack(10);
		stacktest.push(10l);
		stacktest.push(20l);
		stacktest.push(30l);
		stacktest.push(40l);
		System.out.println(stacktest.pop());
		System.out.println(stacktest.pop());
		System.out.println(stacktest.pop());
		System.out.println(stacktest.pop());
		System.out.println(stacktest.isEmpty());
		System.out.println(stacktest.isFull());
	}
}
