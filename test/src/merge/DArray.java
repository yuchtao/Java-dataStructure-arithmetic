package merge;

public class DArray {
	private long[] theArray;
	private int nElens;
	int iii = 0;
	public DArray(int max){
		theArray = new long[max];
		nElens = 0;
	}
	
	public void insert(long value){
		theArray[nElens] = value;
		nElens++;
	}
	
	public void display(){
		for (int i = 0; i < nElens; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println(" ");
	}
	
	public void mergeSort(){
		long[] workSpace = new long[nElens];
		recMergeSort(workSpace, 0, nElens - 1);
	}
	
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
		if (lowerBound == upperBound) {
			return;
		}
		else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}
	
	private void merge(long[] workSpace,int lowPtr, int highPtr,int upperBound){
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;
		
		while (lowPtr <= mid && highPtr <= upperBound) {
			if (theArray[lowPtr] < theArray[highPtr]) {
				workSpace[j++] = theArray[lowPtr++];
			}else {
				workSpace[j++] = theArray[highPtr++];
			}
			
		}
		while (lowPtr <= mid) {
			workSpace[j++] = theArray[lowPtr++];
		}
		
		while (highPtr <= upperBound) {
			workSpace[j++] = theArray[highPtr++];
		}
		
		for (int i = 0; i < n; i++) {
			theArray[lowerBound+i] = workSpace[i];
		}
		
		System.out.println("µÚ¼¸´Î£º"+ iii++ +"  ");
		display();
	}
	
	public static void main(String[] args) {
		int maxSize = 100;
		DArray arr;
		arr = new DArray(maxSize);
		
		arr.insert(65);
		arr.insert(10);
		arr.insert(15);
		arr.insert(75);
		
		
		arr.display();
		arr.mergeSort();
		arr.display();
	}
	
}
