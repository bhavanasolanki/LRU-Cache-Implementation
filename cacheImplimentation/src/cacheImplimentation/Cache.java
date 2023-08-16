package cacheImplimentation;

import cacheImplimentation.customException.StorageFullException;
import cacheImplimentation.eviction.EvictionPolicy;
import cacheImplimentation.storage.StoragePolicy;

public class Cache<Key,Value> {
	
	private final StoragePolicy<Key,Value> storage;
	private final EvictionPolicy<Key> eviction;
	
	public Cache(StoragePolicy<Key, Value> storage, EvictionPolicy<Key> eviction) {
		this.storage = storage;
		this.eviction = eviction;
	}

	public Value get(Key key) {
		Value value= storage.get(key);
		eviction.keyAccessed(key);
		return value;
	}
	
	public void put(Key key, Value value) {
		try {
		storage.add(key,value);
		eviction.keyAccessed(key);
		System.out.println("Added key into cache!");
		} catch(StorageFullException sfe) {
			System.out.println("Storage is full, trying to evict from cache!");
			Key evictedkey=eviction.evictKey();
			storage.remove(evictedkey);
			System.out.println("Evicted key-"+evictedkey+" from cache..now inserting into cache");
			put(key,value);
		}
	}
}
