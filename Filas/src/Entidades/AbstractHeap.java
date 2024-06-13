package Entidades;

import java.util.Comparator;

import Interface.Entry;
import Interface.PriorityQueue;
import Services.Entidades.ArrayList;
import Services.Entidades.DefaultComparator;
import Services.Interface.ListE;


public abstract class AbstractHeap<K,V> implements PriorityQueue<K,V> {
    
    //implementação da entry
    class HeapEntry implements Entry<K,V>{


        K key;
        V value;        

        public HeapEntry(K key, V value) {
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
            return "(" + key + ":" + value + ")";
        }
    }


    //atributos e constructor

    protected ListE<Entry<K,V>> heap;
    private Comparator<K> comparator;   

    public AbstractHeap() {
        heap = new ArrayList<>();
        comparator = new DefaultComparator<>();
    }


    //basic tools

    public int compare(int index1, int index2){
        return compare(heap.get(index1), heap.get(index2));
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2){
        return comparator.compare(e1.getKey(), e2.getKey());
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {        
        return heap.size();
    }


    //toString
    @Override
    public String toString() {
        return heap.toString();
    }    

    

}
