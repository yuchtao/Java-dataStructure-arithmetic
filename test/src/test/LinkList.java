package test;
/**
 * 单链表
 * @author chenj
 *
 */
public class LinkList {
	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(int id, double dd){
		Link newLink = new Link(id,dd);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
	public Link find(int key){
		Link retuLink = null;
		Link current = first;
		while (current != null) {
			if (current.iData == key) {
				retuLink = current;
				break;
			}
			if (current.next != null) {
				current = current.next;
			}
		}
		return retuLink;
	}
	
	public void delete(int key){
		Link current = first;
		Link previous = first;
		while (current != null ) {
			if (current.iData == key) {
				if (current != first) {
					previous.next = current.next;
				}else {
					//如果是第一元素就删除要匹配一下
					first = current.next;
				}
				break;
			}
			if (current.next != null) {
				previous = current;
				current = current.next;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		LinkList list = new LinkList();
		list.insertFirst(1,1.0);
		list.insertFirst(2,2.0);
		list.insertFirst(3,3.0);
		list.insertFirst(4,4.0);
		/*list.displayList();*/
		
		/*while (!list.isEmpty()) {
			Thread.sleep(1000);
			Link temp = list.deleteFirst();
			System.err.println("删除的链表");
			temp.displayLink();
		}*/
		
		System.err.println(list.isEmpty());
		list.delete(4);
		list.displayList();
	}
}
