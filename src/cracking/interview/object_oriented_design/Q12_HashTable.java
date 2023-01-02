package cracking.interview.object_oriented_design;

import java.util.ArrayList;

public class Q12_HashTable<K, V> {

    private ArrayList<Node<K, V>> items;

    public Q12_HashTable(int capacity) {
        this.items = new ArrayList<>();
        items.ensureCapacity(capacity);
        // ??
        for (int i = 0; i < capacity; i++) {
            items.add(null);
        }
    }

    public void put(K key, V value) {
        Node<K, V> node = getNodeForKey(key);
        if (node != null) {
            node.value = value;
            return;
        }

        node = new Node<>(key, value);
        int index = getIndexForKey(key);
        if (items.get(index) != null) {
            node.next = items.get(index);
            node.next.prev = node;
        }
        items.set(index, node);
    }

    public void remove(K key) {
        Node<K, V> node = getNodeForKey(key);
        if (node == null) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int index = getIndexForKey(key);
            items.set(index, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public V get(K key) {
        Node<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    private Node<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        Node<K, V> current = items.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % items.size());
    }

    private static class Node<K, V> {
        public Node<K, V> prev;
        public Node<K, V> next;
        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
