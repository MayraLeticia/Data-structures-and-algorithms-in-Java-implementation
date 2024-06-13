package Entidades;

public class ArrayList extends StaticList {

    public ArrayList(){
        staticList = new int[5];
    }

    private void recreateStaticList(){
        int[] newStaticList = new int[staticList.length*2];
        for(int i = 0; i < size; i++){
            newStaticList[i] = staticList[i];
        }
        staticList = newStaticList;
    }

    @Override
    public void add(int value) {
        if(size == staticList.length){
            recreateStaticList();
        }

        staticList[size] = value;
        size++;   
    }

    @Override
    public void insert(int value) {
        super.insert(value);
    }

    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        super.insert(index, value);
    }
    
}
