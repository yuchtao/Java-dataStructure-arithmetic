package erchatree;

public class Tree {
	private Node root;
	
	public Node find(int key){
		Node curNode = root;
		while (curNode.iData != key) {
			if (key <curNode.iData) {
				curNode = curNode.leftChild;
			}else {
				curNode = curNode.rightChild;
			}
			if (curNode == null) {
				return null;
			}
		}
		return curNode;
	}
	
	public void insert(int id, double dd){
		Node newNode = new Node();
		newNode.iData = id;
		newNode.fData = dd;
		if (root == null) {
			root = newNode;
		}else{
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				}else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;	
					}
				}
			}
		}
	}
	
	public void inOrder(Node localRoot){
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public Node minimum(){
		Node current,last = null;
		current = root;
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}
	
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		}
		
		//删除没有子节点的及节点
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			}else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			} 
		}else if (current.rightChild == null) {//删除 有一个子节点的节点
			if (current == root) {
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else {
				parent.rightChild = current.leftChild;
			}
		}else if (current.leftChild == null) {
			if (current == root) {
				root = current.rightChild;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else {
				parent.rightChild = current.rightChild;
			}
		}else{ //删除有两个子节点的节点
			Node successor =getSuccessor(current);
			if (current == root) {
				root = successor;
			}else if (isLeftChild) {
				parent.leftChild =successor;
			}else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	//找后继节点
	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
		
}
