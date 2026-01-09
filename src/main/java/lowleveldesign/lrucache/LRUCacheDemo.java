package lowleveldesign.lrucache;

public class LRUCacheDemo {

    public static void main(String[] args) {

        LruCache<String,Integer> lruCache = new LruCache<>(3);

        lruCache.put("hello",5);
        lruCache.put("bye",3);
        lruCache.put("gm",2);

        lruCache.printState();


        lruCache.get("gm");

        lruCache.printState();

        lruCache.put("gdn",3);

        lruCache.printState();


        lruCache.get("bye");

        lruCache.printState();

    }
}
