package cacheImplimentation.storage;

import java.util.Map;

import cacheImplimentation.customException.StorageFullException;

import java.util.HashMap;

public class HashMapStoragePolicy<Key, Value> implements StoragePolicy<Key,Value>{
	Map<Key,Value> storageMap;
	int max_size;
	
	public HashMapStoragePolicy(int max_size) {
		this.storageMap = new HashMap<>();
		this.max_size = max_size;
	}
	
	@Override
	public void add(Key key,Value value) throws StorageFullException {
		if(storageMap.size()==max_size)
			throw new StorageFullException("Capacity Reached!");
		storageMap.put(key, value);
	}
	
	@Override
	public Value get(Key key) {
		return storageMap.get(key);
	}
	
	@Override
	public void remove(Key key) {
		storageMap.remove(key);
	}

}
