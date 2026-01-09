package lowleveldesign.lrucache;

public class Node<K,V> {
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Node<K,V> prevNode;
    Node<K,V> nextNode;

}
