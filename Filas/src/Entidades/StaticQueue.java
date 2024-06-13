package Entidades;

import Interface.Queue;
import Services.Entidades.ArrayList;

public class StaticQueue<E> implements Queue<E> {

    //atributos e constructor

    private ArrayList<E> queue;
    // protected int size;
    // protected E[] queue;

    public StaticQueue(){
        queue = new ArrayList<>();
        
    }

    // @SuppressWarnings("unchecked")
    // public StaticQueue(int maxHeight){
    //     queue = (E[])new Object[maxHeight];
    // }

    //remover do inicio da Fila

    @Override
    public E dequeue() {        
        return queue.removeFirst();

        // if(isEmpty()){
        //     throw new EmptyQueueException("Queue is Empty");
        // }
        // E dequeue = queue[0];
        // for (int i = 1; i < queue.length; i++) {
        //     queue[--i] = queue[i];
        // }
        // size--;
        // return dequeue;
    }

    //adiciona no final da Fila

    @Override
    public void enqueue(E value) {
        queue.add(value);

        //  if(isFull()){
        //     throw new FullQueueException("Queue is Full!");
        // }
        // queue[size] = value;
        // size++;
        
    }

    //basic tools

    @Override
    public E first() {
        // return queue[0];
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {

        return queue.isEmpty();
        // return size == 0;
    }

    @Override
    public int size() {
        
        return queue.size();
        // return size;
    }

    //toString

    @Override
    public String toString() {
        
        return " first\n  \\/ \n" + queue.toString();
    }


    
    
}
