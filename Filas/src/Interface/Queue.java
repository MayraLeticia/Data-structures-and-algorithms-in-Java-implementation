package Interface; 

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E first();
    int size();
    boolean isEmpty();
}
