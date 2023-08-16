package cacheImplimentation.eviction;

import java.util.Map;
import java.util.HashMap;

import cacheImplimentation.DoubleLinkedList;
import cacheImplimentation.DoubleLinkedListNode;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
	
	DoubleLinkedList<Key> dll;
	Map<Key,DoubleLinkedListNode<Key>> mapper;
	
	public LRUEvictionPolicy() {
		dll=new DoubleLinkedList<>();
		mapper=new HashMap<>();
	}
	
    @Override
	public void keyAccessed(Key key) {
		DoubleLinkedListNode<Key>node=mapper.get(key);
		if(node==null)
		{   node=new DoubleLinkedListNode<Key>(key);
			dll.insertNodeAtEnd(node);
		    mapper.put(key, node);
		}
		else {
			dll.detachNode(node);
			dll.insertNodeAtEnd(node);	
		}
	}
	
    @Override
	public Key evictKey() {
		if(dll.isEmpty())
			return null;
		DoubleLinkedListNode<Key>node=dll.getFirstNode();
		dll.detachNode(node);
		mapper.remove(node.getElement());
		return node.getElement();
	}
	
}
