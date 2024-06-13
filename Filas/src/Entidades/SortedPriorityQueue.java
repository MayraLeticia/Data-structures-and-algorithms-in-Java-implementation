package Entidades;

import Interface.Entry;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {


    //adiciona na fila de maneira ORDENADA (menor Key maior prioridade)

    @Override
    public void insert(K key, V value) {
        Node newNode = new Node(key, value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            if(compare(newNode, first)<0){
                newNode.next = first;
                first.previous = newNode;
                first = newNode;
            }else if(compare(newNode, last)>=0){
                last.next = newNode;
                newNode.previous = last;
                last = newNode;
            }else{
                Node auxNode = first;
                while(compare(newNode, auxNode)>=0){
                    auxNode = auxNode.next;
                }
                newNode.next = auxNode;
                newNode.previous = auxNode.previous;
                auxNode.previous.next = newNode;
                auxNode.previous = newNode;
            }
        }


        size++;
        
    }

    //remover de forma ORDENADA baseada no indice(KEY) de prioridade

    
    @Override
    public Entry<K, V> remove() {
        if(isEmpty()) throw new RuntimeException("PQ is empty");
        Entry<K,V> entry = first.entry;
        if(size == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            first.previous = null;
        }
        size--;
        return entry;
    }

    //basic tools


    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new RuntimeException("PQ is empty");
        return first.entry;
    }

    

}
