package lowleveldesign.lrucache;

import java.util.HashMap;
import java.util.Map;


/**
 * LRU uses the map to store the key value pairs as node to get them in O(1) TIME
 *
 * and in order to evict from cache , it used the doubly linked list for the order , so that lru can be removed
 * when capacity is full.
 * */
public class LruCache<K, V> {

    private final int capacity;

    private final Map<K, Node<K, V>> map;

    private final DoublyLinkedList<K, V> dll;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    public synchronized V get(K key) {

        Node<K, V> node = map.get(key);

        if (node == null) return null;

        dll.moveToFront(node);

        return node.value;
    }

    public synchronized void put(K key, V value) {

        if (map.containsKey(key)) {

            Node<K, V> node = map.get(key);

            node.value = value;

            dll.moveToFront(node);

        } else {

            if (map.size() == capacity) {
                Node<K, V> lru = dll.removeLast();
                if (lru != null) {
                    map.remove(lru.key);
                }
            }

            Node<K, V> node = new Node<>(key, value);
            dll.addFirst(node);
            map.put(key, node);

        }
    }

    public void printState(){

        map.forEach((key,value)-> System.out.printf("Key: %s, value:%s%n", key,value));
    }
}