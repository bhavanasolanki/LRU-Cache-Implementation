package cacheImplimentation.eviction;

public interface EvictionPolicy<Key> {

	public void keyAccessed(Key key);
	public Key evictKey();
}
