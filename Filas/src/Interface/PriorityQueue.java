package Interface;

public interface PriorityQueue<K,V> {
    void insert(K key, V value);
    Entry<K,V> maxPriority();
    Entry<K,V> remove();
    int size();
    boolean isEmpty();
}

