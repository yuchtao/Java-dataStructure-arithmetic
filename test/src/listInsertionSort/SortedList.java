package listInsertionSort;


public class SortedList {
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	@Override
	public String toString() {
		return "SortedList [first=" + first + "]";
	}

	public SortedList(Link[] linkArr){
		first = null;
		for (int i = 0; i < linkArr.length; i++) {
			insert(linkArr[i]);
		}
	}
	
	public void insert(Link k){
		Link previous = null;
		Link current = first;
		
		while(current != null && k.dData > current.dData){
			previous = current;
			current = current.next;
		}
		
		if (previous == null) {
			first = k;
		}else {
			previous.next = k;
		}
		k.next = current;
	}
	
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArray = new Link[size];
		for (int i = 0; i < size; i++) {
			int n = (int)(Math.random()*99);
			Link newLink = new Link(n);
			linkArray[i] = newLink;
		}
		System.out.println("Unsorted array: ");
		for (int j = 0; j < size; j++) {
			System.out.print(linkArray[j].dData + " ");
		}
		System.out.println(" ");
		
		SortedList theSortedList = new SortedList(linkArray);
		for (int i = 0; i < size; i++) {
			linkArray[i] = theSortedList.remove();
		}
		System.err.println("sorted array: ");
		for (int j = 0; j < size; j++) {
			System.out.print(linkArray[j].dData + " ");
		}
	}
}
