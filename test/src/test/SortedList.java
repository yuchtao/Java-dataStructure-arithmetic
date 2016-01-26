package test;

public class SortedList {
	private SortLink first;
	
	public SortedList() {
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insert(int key){
		SortLink sortLink = new SortLink(key);
		SortLink previous = null;
		SortLink current = first;
		
		while (current != null && key > current.dData) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			first = sortLink;
		}else {
			previous.next = sortLink;
		}
		sortLink.next = current;
	}
	
	public SortLink remove(){
		SortLink temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		SortLink current = first;
		while (current != null) {
			current.dispalyLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		SortedList sortedList = new SortedList();
		sortedList.insert(20);
		sortedList.insert(40);
		
		sortedList.displayList();
		sortedList.insert(10);
		sortedList.insert(30);
		sortedList.insert(50);
		
		sortedList.displayList();
		System.out.println("=================");
		sortedList.remove();
		sortedList.displayList();
	}
}
