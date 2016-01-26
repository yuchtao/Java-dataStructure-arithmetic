package test;

public class Solution {
	
	/**
	 * 递归
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || null == head.getNext()) {
			return head;
		}
		ListNode tem = head.getNext(); 
		ListNode node = reverseList(tem);
		//head.getNext().setNext(head);
		ListNode tem2 = head.getNext(); 
		tem2.setNext(head);
		head.setNext(null);
		return node;
	}
	
	 /**  
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针  
     */  
    public static ListNode reverse2(ListNode head) {  
        if (null == head) {  
            return head;  
        }  
        ListNode pre = head;  
        ListNode cur = head.getNext();  
        ListNode next;  
        while (null != cur) {  
            next = cur.getNext();  
            cur.setNext(pre);  
            pre = cur;  
            cur = next;  
        }  
        head.setNext(null);  
        head = pre;  
          
        return head;  
    } 
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode tmp = null;  
		ListNode cur = null;  
        for (int i = 1; i < 10; i++) {  
            tmp = new ListNode(i);  
            if (1 == i) {  
                head.setNext(tmp);  
            } else {  
                cur.setNext(tmp);  
            }  
            cur = tmp;  
        }  
         
        //head = reverseList(head);
        head = reverse2(head);
        while (null != head) {  
            System.out.print(head.getVal() + " ");  
            head = head.getNext();  
        } 
	}
}
