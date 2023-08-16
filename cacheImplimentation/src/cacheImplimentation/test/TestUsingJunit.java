package cacheImplimentation.test;

import org.junit.Test;
import static org.junit.Assert.*;  

import cacheImplimentation.Cache;
import cacheImplimentation.CacheFactory;

public class TestUsingJunit {
	
	// imported junit4.jar and hamcrest-core.jar into classpath

	@Test
	public void cacheTestOne() {
		CacheFactory<String,String> cf=new CacheFactory<>();
    	Cache<String,String> cache=cf.defaultCache(5);
    	cache.put("key1", "value1");
    	cache.put("key2", "value2");
    	cache.put("key3", "value3");
    	cache.put("key4", "value4");
    	cache.put("key5", "value5");
    	assertEquals("value1",cache.get("key1"));
    	assertNull(cache.get("key9"));
    	cache.put("key6", "value6");
    	assertEquals("value1",cache.get("key1"));
    	assertNull(cache.get("key2"));
	}
	
	@Test
	public void cacheTestTwo() {
		CacheFactory<String,String> cf=new CacheFactory<>();
    	Cache<String,String> cache=cf.defaultCache(2);
    	cache.put("key1", "value1");
    	cache.put("key2", "value2");
    	cache.put("key3", "value3");
    	cache.put("key4", "value4");
    	cache.put("key5", "value5");
    	assertEquals("value4",cache.get("key4"));
    	assertNull(cache.get("key9"));
    	cache.put("key6", "value6");
    	assertEquals("value4",cache.get("key4"));
    	assertNull(cache.get("key5"));
	}
}
