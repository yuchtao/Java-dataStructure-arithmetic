package recQuickSort;

public class ArrayPar {
	private long[] theArray;
	private int nElems;
	
	public ArrayPar(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	
	public int size(){
		return nElems;
	}
	
	public void display(){
		System.out.println("A=");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println(" ");
	}
	
	public void swap(int dex1,int dex2){
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
	
	public int partitionIt(int Left, int right, long pivot){
		int leftPtr = Left - 1;
		int rightPtr = right;
		while (true) {
			while (theArray[++leftPtr] < pivot);
			while (rightPtr > 0 && theArray[--rightPtr] > pivot);
			if (leftPtr >= rightPtr) {
				break;
			}else {
				swap(leftPtr, rightPtr);
/*				display();
*/			}
		}
		//这个是和枢纽交换位置，他的位置已经定了
		swap(leftPtr, right);
		return leftPtr;
	}
	
	public void quickSort(){
		recQuickSort(0, nElems - 1);
	}
	
	public void recQuickSort(int left, int right){
		if (right - left <= 0) {
			return;
		}else {
			long pivot = theArray[right];
			
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition+1, right);
		}
	}
	
	public static void main(String[] args) {
		int maxSize = 3;
		ArrayPar arr;
		arr = new ArrayPar(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int)(Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		/*long pivot = 99;
		int size = arr.size();
		
		int partDex = arr.partitionIt(0, size-1, pivot);
		System.out.println("Pivot is " + pivot);
		System.out.println(", Partition is at index " + partDex);*/
		arr.quickSort();
		arr.display();
	}
}
