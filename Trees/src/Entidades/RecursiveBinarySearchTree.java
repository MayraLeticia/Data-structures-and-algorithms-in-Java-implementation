package Entidades;

public class RecursiveBinarySearchTree<E> extends AbstractTree<E> {


    //remove de 3 maneiras
    @Override
    public E delete(E value) {
        int previousSize = size;
        root = delete(value, root);
        if(previousSize!=size){
            return value;
        }
        return null;
    }

    private Node delete(E value, Node current) {
        if (current == null) {
            return null;
        }
        //buscar o nó
        if (compare(value, current) < 0) {
            current.left = delete(value, current.left);
        } else if (compare(value, current) > 0) {
            current.right = delete(value, current.right);
        } else {
            //se for folha -> apenas remova (a fazer com que seu pai aponte para null)
            if (current.left == null && current.right == null) {
                size--;
                current = null;

            //se tiver 2 filhos -> troque o nó a ser removido pelo nó de menor valor na subárvore à direita do nó e remova o da ponta
            } else if (current.left != null && current.right != null) {
                current.value = minNode(current.right).value;
                current.right = delete(current.value, current.right);
            
            //se só tiver 1 filho -> fazeça com que o target.parent aponte para o filho deste mesmo nó    
            } else {
                size--;
                current = current.left != null ? current.left : current.right;
            }
        }
        
        return current;
    }

    private Node minNode(Node current){
        if(current.left == null){
            return current;
        }
        return minNode(current.left);
    }



    //insere na árvore de modo q: (newNode > auxNode) ? (auxNode.right = newNode) : (auxNode.left = newNode)
    //1° insere (valor) -> chama o outro metodo passando o valor e a root
    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    private Node insert(E value, Node current) {
        //-> se a root for nula (ou seja, a tree está vazia) adicione o novo nó
        if (current == null) {
            size++;
            return new Node(value);
        }
        //-> se não compara a root com o valor dado -> se for maior compara com o da direita, repete o processo e adiciona
        if (compare(value, current) < 0) {
            current.left = insert(value, current.left);
        
        //-> se for menor compara com o da direita, repete o processo e adiciona
        } else if (compare(value, current) > 0) {
            current.right = insert(value, current.right);
        }

        //se for igual só repete???
        return current;
    }


 

    //basic tools
    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    @Override
    public E get(E value) {
        return contains(value, root).value;
    }
    


    @Override
    public boolean contains(E value) {
        return contains(value, root) != null;
    }

    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) < 0) {
            current = contains(value, current.left);
        } else if (compare(value, current) > 0) {
            current = contains(value, current.right);
        }
        return current;
    }






    //toString
    @Override
    public String toString() {
        return "RecursiveBinarySearchTree []";
    }


    @Override
    public void treeTraversal() {
        preOrder(root);

    }

    public void treeTraversal(String type){
        if(type.equals("inOrder")){
            inOrder(root);
        }else if(type.equals("postOrder")){
            postOrder(root);
        }else{
            treeTraversal();
        }
    }

    private void preOrder(Node current){
        if(current!=null){
            System.out.print(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);
            
        }
    }

    private void postOrder(Node current){
        if(current!=null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.value + " ");
            
        }
    }

    private void inOrder(Node current){
        if(current!=null){
            inOrder(current.right);
            System.out.print(current.value + " ");            
            inOrder(current.left);
        }
    }


    

}
