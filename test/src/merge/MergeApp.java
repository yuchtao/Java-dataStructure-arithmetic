package merge;

public class MergeApp {
	public static void main(String[] args) {
		int[] arrayA = {23,34,43,78};
		int[] arrayB = {1,32,48,65,94,98};
		int[] arrayC = new int[arrayA.length+arrayB.length];
		
		merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
		display(arrayC);
	}
	
	private void recMergeSort(long[] workSpace,int lowerBound,int upperBound){
		if (lowerBound == upperBound) {
			return;
		}else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			/*merge(arrayA, sizeA, arrayB, sizeB, arrayC);*/
		}
	}
	
	public static void merge(int[] arrayA,int sizeA, int[] arrayB,int sizeB,int[] arrayC){
		int aDex=0, bDex=0,cDex = 0;
		while (aDex < sizeA && bDex <sizeB) {
			if (arrayA[aDex] < arrayB[bDex]) {
				arrayC[cDex++] = arrayA[aDex++];
			}else {
				arrayC[cDex++] = arrayB[bDex++];
			}
		}
		
		while (aDex < sizeA) {
			arrayC[cDex++] = arrayA[aDex++];
		}
		
		while (bDex < sizeB) {
			arrayC[cDex++] = arrayB[bDex++];
		}
	}
	
	public static void display(int[] theArray){
		for (int i = 0; i < theArray.length; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println(" ");
	}
}
