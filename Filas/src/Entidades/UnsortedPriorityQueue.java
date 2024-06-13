package Entidades;

import Interface.Entry;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {


    //adiciona no FINAL da Fila de maneira DESORDENADA

    @Override
    public void insert(K key, V value) {
        Node newNode = new Node(key, value);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;

    }

    //basic tools


    private Node findMaxPriorityNode(){
        Node minNode = last; //ultimo a ser inserido
        Node auxNode = last.previous;

        while(auxNode!=null){
            int comp = compare(auxNode.entry, minNode.entry); //compara o ultimo com o seu antecessor
            if(comp<=0){ //se aux <= min, o min passa a ser o aux, pois o que entrou primeiro e de menor indice tem prioridade de saida.
                minNode = auxNode;
            }
            auxNode = auxNode.previous;
        }
        return minNode; //retorna um node
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new RuntimeException("PriorityQueue is empty!");
        return findMaxPriorityNode().entry; //retorna uma entry
    }

    //remover de forma ORDENADA baseada no indice(KEY) de prioridade

    @Override
    public Entry<K, V> remove() {
        if(isEmpty()) throw new RuntimeException("PriorityQueue is empty!");

        Node maxPriorityNode = findMaxPriorityNode(); //achar o node de maior prioridade

        if(size == 1){
            first = null;
            last = null;
        }else{
            if(maxPriorityNode == first){
                first = first.next;
                first.previous = null;
            }else if(maxPriorityNode == last){
                last = last.previous;
                last.next = null;
            }else{
                maxPriorityNode.next.previous = maxPriorityNode.previous;
                maxPriorityNode.previous.next = maxPriorityNode.next;                
            }
        }
        size--;
        return maxPriorityNode.entry;
    }

    



}
