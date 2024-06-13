package Entidades;

import Exceptions.EmptyStackException;
import Interface.Stack;

public class DynamicStack<E> implements Stack<E> {


    //Node 

    class Node{
        E value;
        Node next;
        public Node(E value) {
            this.value = value;
        }
        
    }


    //atributos e contructor

    private Node top;
    private int height;

    //Cirillo kd o constructor?


    //Basic tools

    @Override
    public int height() {  
        return height;
    }

    @Override
    public boolean isEmpty() {       
        return top == null;
    }

    @Override
    public E top() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!");
        }
        return top.value;
    }



    //REMOVE e retorna o value presente no topo da pilha.

    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!");
        }
        E value = top.value;
        top = top.next;
        return value;
    }



    //realiza o EMPILHAMENTO do elemento value no topo da pilha

    @Override
    public void push(E value) {
        Node newNode = new Node(value);
        if(!isEmpty()){            
            newNode.next = top;
        }        
        top = newNode;
        height++;        
    }


    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        Node auxNode = top;
        while(auxNode!=null){
            sb.append(auxNode.value);
            if(auxNode == top){
                sb.append(" <- top");
            }
            sb.append("\n");


            auxNode = auxNode.next;
        }
        return sb.toString();
    }

    
    

}
