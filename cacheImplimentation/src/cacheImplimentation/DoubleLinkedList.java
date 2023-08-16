package cacheImplimentation;

public class DoubleLinkedList<E> {
	
	DoubleLinkedListNode<E> dummyHead;
	DoubleLinkedListNode<E> dummyTail;
	
	public DoubleLinkedList() {
		this.dummyHead=new DoubleLinkedListNode<E>(null);
		this.dummyTail=new DoubleLinkedListNode<E>(null);
		this.dummyHead.next=dummyTail;
		this.dummyTail.prv=dummyHead;
	}
	
	public boolean isEmpty() {
		if(dummyHead.next==dummyTail)
			return true;
		else
			return false;
	}
	
	public void insertNodeAtEnd(DoubleLinkedListNode<E> node) {
		dummyTail.prv.next=node;
		node.prv=dummyTail.prv;
		dummyTail.prv=node;
		node.next=dummyTail;
	}

	public void detachNode(DoubleLinkedListNode<E> node) {
		node.prv.next=node.next;
		node.next.prv=node.prv;
	}
	
	public DoubleLinkedListNode<E> getFirstNode() {
		return dummyHead.next;
	}
	
	public DoubleLinkedListNode<E> getLastNode(){
		return dummyTail.prv;
	}
}
