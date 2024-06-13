package Entidades;

import Interface.Queue;
import Services.Entidades.LinkedList;

public class DynamicQueue<E> implements Queue<E> {

    //atributos e constructor

    LinkedList<E> queue;

    public DynamicQueue(){
        queue = new LinkedList<>();
    }




    //remover do inicio da Fila

    @Override
    public E dequeue() {
        
        return queue.removeFirst();
    }

    //adiciona no final da Fila

    @Override
    public void enqueue(E value) {
        queue.add(value);
        
    }



    //basic tools

    @Override
    public E first() {
        
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        
        return queue.isEmpty();
    }

    @Override
    public int size() {
        
        return queue.size();
    }
    

    //toString
    
    @Override
    public String toString() {
        
        return " first\n  \\/ \n"+queue.toString();
    }
}
