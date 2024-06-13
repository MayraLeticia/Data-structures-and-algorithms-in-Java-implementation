package Entidades;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;
import Interface.Stack;

public class StaticStack<E> implements Stack<E> {

    //atributos e contructor

    private int height;
    private E[] stack;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxHeight){
        stack = (E[])new Object[maxHeight];
    }


    //Basic tools

    @Override
    public int height() {        
        return height;
    }


    @Override
    public E top() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!");
        }
        return stack[height-1];
    }


    @Override
    public boolean isEmpty() {        
        return height==0;
    }


    public boolean isFull() {        
        return height==stack.length;
    }



    //REMOVE e retorna o value presente no topo da pilha.

    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!");
        }
        // height--;
        return stack[--height];       
    }


    //realiza o EMPILHAMENTO do elemento value no topo da pilha

    @Override
    public void push(E value) {
        if(isFull()){
            throw new FullStackException("Stack is full!");
        }

        stack[height] = value;
        height++;        
    }
    


    //toString
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for(int i = height-1; i>=0; i--){
            sb.append(stack[i]);
            if(i==height-1){
                sb.append(" -> top");
            }
            
                sb.append("\n");
            
        }

        return sb.toString();
    }

    
    
}
