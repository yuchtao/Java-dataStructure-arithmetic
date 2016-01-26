package shellSort;

/**
 * 希尔排序
 * @author chenj
 *
 */
public class ArraySh {
	private long[] theArray;
	private int nElems;
	
	public boolean isContain(long temp){
		for (long tempLong : theArray) {
			if (tempLong == temp) {
				return true;
			}
		}
		return false;
	}
	
	public ArraySh(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		theArray[nElems++] = value;
	}
	
	public void display(){
		System.out.println("A=");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println(" ");
	}
	
	public void shellSort(){
		int inner,outer;
		long temp;
		int h = 1;
		
		while (h <= nElems/3) {
			h = h*3 + 1;
		}
		
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;
				
				while (inner > h-1 && theArray[inner-h] >= temp) {
					theArray[inner] = theArray[inner-h];
					inner-=h;
				}
				theArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
	
	public static void main(String[] args) {
		ArraySh arr = new ArraySh(100);
		
		int i = 0;
		while(true){
			long n = (int)(Math.random()*100);
			if (!arr.isContain(n)) {
				arr.insert(n);
				i++;
			}
			if (i == 99) {
				break;
			}
		}
		arr.display();
		long time = System.currentTimeMillis();
		arr.shellSort();
		System.err.println("用到的时间是："+(System.currentTimeMillis() - time));
		arr.display();
	}
}
