package lowleveldesign.lrucache;

public class DoublyLinkedList<K, V> {

    private final Node<K, V> head;

    private final Node<K, V> tail;

    public DoublyLinkedList() {
        this.head = new Node<>(null,null); // dummy nodes
        this.tail = new Node<>(null,null); // dummy nodes

        head.nextNode = tail;
        tail.prevNode = head;
    }

    public void addFirst(Node<K, V> node) {

        node.nextNode = head.nextNode;
        node.prevNode = head;

        head.nextNode.prevNode = node;
        head.nextNode = node;

    }

    public void remove(Node<K, V> node) {

        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
    }

    public void moveToFront(Node<K, V> node) {
        remove(node);
        addFirst(node);
    }

    public Node<K, V> removeLast() {

        if (tail.prevNode == head) return null;

        Node<K, V> last = tail.prevNode;

        remove(last);
        return last;
    }


}
