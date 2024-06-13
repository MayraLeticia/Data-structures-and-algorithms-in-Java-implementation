package Entidades;

import Interface.Entry;

public class Heap<K,V> extends AbstractHeap<K,V>{


    //basic tools

    private void swap(int index1, int index2){
        Entry<K,V> auxEntry = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2,auxEntry);
    }

    private int parent(int child){
        return (child-1)/2;
    }

    private int leftChild(int parent){
        return parent*2+1;
    }

    private int rightChild(int parent){
        return leftChild(parent)+1;
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new RuntimeException("Heap is Empty!");
        return heap.get(0);
    }


    //adiciona na heap e faz o e bubbling-up
    @Override
    public void insert(K key, V value) {
        Entry<K,V> newEntry = new HeapEntry(key, value);
        heap.add(newEntry);

        int current = size()-1;
        int parent = parent(current);

        while(current > 0 && compare(current, parent)==-1){
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
        
    }


    //remove o nó de maior prioridade e reorganiza a heap
    @Override
    public Entry<K, V> remove() {
        
        Entry<K,V> entry = maxPriority();

        if(size()==1){
            heap.removeLast();
        }else{            
            heap.set(0, heap.removeLast());
            sinkDown();
        }

        return entry;
    }

    private void sinkDown(){
        int min = 0, current;
        int leftChild, rightChild;
        do{
            current = min;
            leftChild = leftChild(current);
            rightChild = rightChild(current);

            if(leftChild < size() && compare(leftChild, min)==-1){
                min = leftChild;
            }

            if(rightChild < size() && compare(rightChild, min)==-1){
                min = rightChild;
            }
            if(min!=current){
                swap(min,current);
            }
        }while(current!=min);

    }

}
