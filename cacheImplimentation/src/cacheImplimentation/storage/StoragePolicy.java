package cacheImplimentation.storage;

import cacheImplimentation.customException.StorageFullException;

public interface StoragePolicy<Key,Value> {

	public void add(Key key,Value value) throws StorageFullException;
	public Value get(Key key);
	public void remove(Key key);
}
