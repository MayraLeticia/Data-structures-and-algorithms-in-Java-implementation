package Entidades;

public class AVLTree<E> extends AbstractTree<E> {

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

        //atualiza a altura e rebalanceia a árvore
        updateHeight(current);
        current = balance(current);        
        return current;
    }

   


    
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
                // return current;

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

        //atualiza a altura e rebalanceia a árvore se a arvore não estiver vazia
        if(current!=null){
            updateHeight(current);
            current = balance(current); 
        }
        
        return current;
    }

    private Node minNode(Node current){
        if(current.left == null){
            return current;
        }
        return minNode(current.left);
    }



    //basic tools


    //compara dois valores (normalmente a altura) e retorna o maior deles.
    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }


    //atualiza a altura dos nós após ser chamado.
    private void updateHeight(Node current){
        current.height = 1 + max(height(current.left), height(current.right));
        //a altura de current é a maior altura dentre os seus filhos + 1.
    }



    //compultagm e retorno da altura
    private int height(Node current) {
        if (current == null) {
            return 0;
        }
        return current.height; 
    }

    public int height() {
        return height(root);
    }



    
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



    //faz o balanceamento do nó
    private Node balance(Node current){
        int difference1 = height(current.right) - height(current.left); //diferença das alturas dos filhos gera o indice de balanceamento.
        if (difference1 > 1) { //2 ou 3 desbalaceado á direita  (lembrar plano cartesiano)
            System.out.println("Desbalanceado - Direita");
            int difference2 = height(current.right.right) - height(current.right.left); //indice de balaneamento do filho sentido do desbalanceamento (nesse caso á direita) determina o tipo de rotação
            if (difference2 == 0 || difference2 == 1) { //rotação simples
                //sempre -> rotação do current no sentido contrario do desbalanceamento
                current = leftRotation(current); 
            } else { //rotação composta/dupla
                //sempre -> 1° rotação do filho no sentido do desbalanceamento // depois rotação do current no sentido contrario do desbalanceamento
                current.right = rightRotation(current.right);
                current = leftRotation(current);
            }

        } else if (difference1 < -1) { //-2 ou -3 desbalaceado á direita  (lembrar plano cartesiano)
            System.out.println("Desbalanceado - Esquerda");
            int difference2 = height(current.left.right) - height(current.left.left);
            if (difference2 == 0 || difference2 == -1) {
                current = rightRotation(current);
            } else {
                current.left = leftRotation(current.left);
                current = rightRotation(current);
            }
        }
        return current; //pq retorna current e não current.heith?
    }

    //rotaciona pra direita
    private Node rightRotation(Node x) {
        Node y = x.left;
        Node T2 = y.right;
        y.right = x;
        x.left = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }
    
    //rotaciona pra esquerda
    private Node leftRotation(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }


    //toString

    @Override
    public String toString() {
        return preOrder(new StringBuilder(), root).toString();
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub

    }

    private StringBuilder preOrder(StringBuilder sb, Node current) {
        if (current != null) {
            sb.append(current).append("\n");
            preOrder(sb, current.left);
            preOrder(sb, current.right);

        }
        return sb;
    }


   
}
