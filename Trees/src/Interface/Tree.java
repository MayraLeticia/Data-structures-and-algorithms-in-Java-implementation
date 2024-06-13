package Interface;

public interface Tree<E> {
    void insert(E value); //
    boolean contains(E value);
    E get(E value);
    E delete(E value); //
    int size();
    boolean isEmpty(); //
    void clear();
    void treeTraversal(); //

}
