package Entidades;

import Exceptions.EmptyListException;
import Exceptions.FullListException;
import Interface.List;

public class StaticList implements List{

    //atributos e contructor
    
    protected int size;
    protected int[] staticList;
    private final int MAX_SIZE = 5;

    public StaticList(){
        staticList = new int[MAX_SIZE];
    }

    //Basic tools

    @Override
    public int size() {
        return size;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    @Override
    public boolean isEmpty() {
        
        return size == 0;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return staticList[index];
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        staticList[index] = value;
        
    }

    private void checkIndex(int index, int referenceIndex){
        if(index < 0 || index>=referenceIndex){
            throw new IndexOutOfBoundsException("Index "+index+" is not valid!");
        }
    }


    // ADICIONAR ao final(add), ao começo(insert), onde quiser (insert( index, value))

    @Override
    public void add(int value) {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }
        staticList[size] = value;
        size++;            
    }
  

    @Override
    public void insert(int value) {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }

        for(int i = size ; i > 0 ; i--){
            staticList[i] = staticList[i-1];
        }
        staticList[0] = value;
        size++;
        
    }


    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }

        checkIndex(index,MAX_SIZE);

        if(index>=size){
            add(value);
        }else{

            for(int i = size ; i > index ; i--){
                staticList[i] = staticList[i-1];
            }
            staticList[index] = value;
            size++;

        }

        
    }

    //REMOVER

    @Override
    public int removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Static List is Empty");
        }
        checkIndex(index, size);


        int value = staticList[index];
        for(int i = index; i < size-1; i++){
            staticList[i] = staticList[i+1];
        }
        size--;

        return value;
    }

    @Override
    public int removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Static List is Empty");
        }
        int value = staticList[0];
        for(int i = 0; i < size-1;i++){
            staticList[i] = staticList[i+1];
        }
        size--;
        return value;
    }

    @Override
    public int removeLast() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Static List is Empty");
        }
        return staticList[--size];
    }

    
    //toString

    @Override
    public String toString() {
        String data = "[";
        
        for(int i = 0; i < size; i++){
            if(i==size-1){
                data = data + staticList[i];
            }else{
                data = data + staticList[i]+", ";

            }
        }
        
        return data + "]";
    }

}
