package cacheImplimentation;

import cacheImplimentation.eviction.LRUEvictionPolicy;
import cacheImplimentation.storage.HashMapStoragePolicy;

public class CacheFactory<Key,Value> {
	
	public Cache<Key,Value> defaultCache(int Capacity){
		return new Cache<>(new HashMapStoragePolicy<>(Capacity),new LRUEvictionPolicy<>());
	}

}
