package Entidades;
import java.util.Comparator;

import Interface.Entry;
import Interface.PriorityQueue;
import Services.Entidades.DefaultComparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {


    //implementação da entry
    class  PriorityQueueEntry implements Entry<K,V>{
        K key;
        V value;        

        public PriorityQueueEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + " - " + value + ")";
        }        
        
    }

    //implementação do node (nesse caso com uma entry dentro)
    class Node{
        Node next;
        Node previous;
        Entry<K,V> entry;

        public Node(Entry<K, V> entry) {
            this.entry = entry;
        }
        public Node(K key, V value){
            entry = new PriorityQueueEntry(key, value);
        }        
    }

    //atributos e constructor


    private Comparator<K> comparator; //comparador de tipo Comparator (interface do java.util)
    protected int size;
    protected Node first;
    protected Node last;
    

    public AbstractPriorityQueue() {
        comparator = new DefaultComparator<>();
    }

    //basic tools

    public int compare(Node n1, Node n2){  //recebe 2 Node e compara suas entrys
        return compare(n1.entry, n2.entry);    // (0,=) (-1,<) (1,>)
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2){  //recebe 2 Entry e compara suas K key
        return comparator.compare(e1.getKey(), e2.getKey());   // (0,=) (-1,<) (1,>)
    }

    @Override
    public boolean isEmpty() {        
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }



    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = first;
        while(auxNode!=null){
            sb.append(auxNode.entry);
            if(auxNode.next!=null){
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }

        sb.append("]");
        return sb.toString();
    }


    

    

}
