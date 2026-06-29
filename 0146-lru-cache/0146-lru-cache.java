import java.util.*;

class LRUCache {

    private final int capacity;

    private LinkedHashMap<Integer,Integer> map;

    public LRUCache(int capacity) {

        this.capacity=capacity;

        map=new LinkedHashMap<>(capacity,0.75f,true){
            protected boolean removeEldestEntry(
                    Map.Entry<Integer,Integer> eldest){

                return size()>LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key,-1);
    }

    public void put(int key,int value) {
        map.put(key,value);
    }
}