package cacheImplimentation;

public class DoubleLinkedListNode<E> {

	E element;
	DoubleLinkedListNode<E> prv;
	DoubleLinkedListNode<E> next;
	
	public DoubleLinkedListNode(E element) {
		this.element = element;
		this.prv = null;
		this.next = null;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public DoubleLinkedListNode<E> getPrv() {
		return prv;
	}

	public void setPrv(DoubleLinkedListNode<E> prv) {
		this.prv = prv;
	}

	public DoubleLinkedListNode<E> getNext() {
		return next;
	}

	public void setNext(DoubleLinkedListNode<E> next) {
		this.next = next;
	}
	
	
}
