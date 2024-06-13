package Entidades;

import Exceptions.EmptyListException;
import Interface.ListE;

class LinkedList<E> implements ListE<E>{


    //Node

    private class Node{
        E value;
        Node next;
    
        public Node(E value){
            this.value = value;
            // next = null;
        }
    }

    //atributos e contructor

    private int size;
    private Node head;
    private Node tail;

    public LinkedList(){}

    public LinkedList(E value){
        add(value);
    }


    //Basic tools

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Illegal index "+index+". Availabe indexes are [0 - "+(size-1)+"]");
        }

        return getNode(index).value;
    }


    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Illegal index "+index+". Availabe indexes are [0 - "+(size-1)+"]");
        }

        getNode(index).value = value;

        
    }


    private Node getNode(int index){
        Node auxNode = head;
        for(int i = 0; i < index; i++){
            auxNode = auxNode.next;
        }
        return auxNode;
    }


    @Override
    public boolean isEmpty() {       
        return size == 0;
    }


    @Override
    public int size() {        
        return size;
    }


    // ADICIONAR ao final(add), ao começo(insert), onde quiser (insert( index, value))

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;            
        }else{
            tail.next = newNode;           
        }
        tail = newNode;
        size++;        
    }

   
    @Override
    public void insert(E value) {
        Node newNode = new Node(value);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }

        size++;
    }


    @Override
    public void insert(int index, E value)  {
        
        if(index<=0){
            insert(value);
        }else if(index>=size){
            add(value);
        }else{
            Node newNode = new Node(value);
            Node auxNode = getNode(index-1);
            newNode.next = auxNode.next;
            auxNode.next = newNode;
            size++;

        }
        
    }

    
    //REMOVER

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Illegal index "+index+". Availabe indexes are [0 - "+(size-1)+"]");
        }
        E value = null;
        if(index == 0){
            value = removeFirst();
        }else if(index == size-1){
            value = removeLast();
        }else{
            Node auxNode1 = getNode(index-1);
            Node auxNode2 = auxNode1.next;
            auxNode1.next = auxNode2.next;
            // auxNode2.next = null;
            value = auxNode2.value;
            size--;
        }

        return value;
    }


    @Override
    public E removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        Node auxNode = head;
        if(size == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            auxNode.next = null;
        }
        size--;
        return auxNode.value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        E value = tail.value;
        if(size == 1){
            head = null;
            tail = null;
        }else{
            Node auxNode = getNode(size-2);
            tail = auxNode;
            auxNode.next = null;
        }
        size--;
        return value;
    }

   
    //toString

    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = head;
        while(auxNode!=null){
            sb.append(auxNode.value);
            if(auxNode.next != null){
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }
        return sb.append("]").toString();
    }

    
}