package test;


public class FirstLastList {
	public FirstLastLink first;
	public FirstLastLink last;
	
	public FirstLastList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(int dd){
		FirstLastLink newLink = new FirstLastLink(dd);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(int dd){
		FirstLastLink newLink = new FirstLastLink(dd);
		if (isEmpty()) {
			first = newLink;
		}else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	public int deleteFirst(){
		int temp = first.dData;
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		FirstLastLink current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		FirstLastList list = new FirstLastList();
		list.insertFirst(11);
		list.insertFirst(22);
		list.insertFirst(33);
		
		list.insertLast(44);
		list.insertLast(55);
		list.insertLast(66);
		
		list.deleteFirst();
		list.deleteFirst();
		
		list.displayList();
	}
}
