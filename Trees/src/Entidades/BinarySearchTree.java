package Entidades;

public class BinarySearchTree<E> extends AbstractTree<E> {
   

    //remove de 3 maneiras
    @Override
    public E delete(E value) {
        if(isEmpty()){
            throw new RuntimeException("Tree is empty!");
        }
        Node target = root, parent = null;

        //buscar o nó
        while(target!=null && compare(value, target)!=0){
            parent = target;
            if(compare(value,target)>0){
                target = target.right;
            }else{
                target = target.left;
            }
        }

        if(target == null){
            return null;
        }


        //se for folha -> apenas remova (a fazer com que seu pai aponte para null)
        if(target.left == null && target.right == null){

            if(target == root){
                root = null;
            }else{

                if(parent.left == target){
                    parent.left = null;
                }else{
                    parent.right = null;
                }

            }

        //se tiver 2 filhos -> troque o nó a ser removido pelo nó de menor valor na subárvore à direita do nó e remova o da ponta
        }else if(target.left != null && target.right != null){
            target.value = removeMinNode(target);

        //se só tiver 1 filho -> fazeça com que o target.parent aponte para o filho deste mesmo nó    
        }else{
            Node child = target.left != null ? target.left : target.right;

            if(target == root){
                root = child;
            }else{

                if(parent.left == target){
                    parent.left = child;
                }else{
                    parent.right = child;
                }

            }
        }

        size--;
        return target.value;
    }

    private E removeMinNode(Node parent){
        Node minNode = parent.right;
        while(minNode.left != null){
            parent = minNode;
            minNode = minNode.left;
        }

        if(minNode.right!=null){
            if(parent.left == minNode){
                parent.left = minNode.right;
            }else{
                parent.right =minNode.right;
            }
        }else{
            if(parent.left == minNode){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        return minNode.value;
    }

  


    //insere na árvore de modo q: (newNode > auxNode) ? (auxNode.right = newNode) : (auxNode.left = newNode)
    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            root = newNode;
        }else{
            Node auxNode = root;
            while(true){
                if(compare(newNode, auxNode)<0){
                    if(auxNode.left == null){
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                }else if(compare(newNode, auxNode)>0){
                    if(auxNode.right == null){
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                }else{
                    return;
                }
            }
        }
        size++;
    }


    
    //basic tools
    
    @Override
    public void clear() {
        root = null;
        size = 0;
        
    }

    @Override
    public boolean contains(E value) {
        return get(value) != null;
    }
    
    @Override
    public E get(E value) {
        Node current = root;
        while (current != null) {
            
            if (compare(value, current.value) < 0) {
                current = current.left;
            } else if (compare(value, current.value) > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }




    //toString

    @Override
    public String toString() {
        return "BinarySearchTree []";
    }


    //os metodos abaixo estão comentados porque não importei os serviçoes para essa pasta

    @Override
    public void treeTraversal() {
        // Queue<Node> queue = new DynamicQueue<>();
        // if(root != null){
        //     queue.enqueue(root);
        // }

        // while(queue.size()!=0){
        //     Node current = queue.dequeue();
        //     System.out.print(current.value+" ");
        //     if(current.left!=null){
        //         queue.enqueue(current.left);
        //     }
        //     if(current.right!=null){
        //         queue.enqueue(current.right);
        //     }


        // }
        
    }

    public void preOrder() {
        if (isEmpty()) {
            return;
        }
        
        // DynamicStack<Node> stack = new DynamicStack<>();
        // stack.push(root);
    
        // while (!stack.isEmpty()) {
        //     Node current = stack.pop();
        //     System.out.print(current.value + " ");
    
        //     // Push right child first, so left child is processed first (LIFO)
        //     if (current.right != null) {
        //         stack.push(current.right);
        //     }
        //     if (current.left != null) {
        //         stack.push(current.left);
        //     }
        // }
        // System.out.println(); // Optionally, add a newline after traversal
    }
    
    
    public void inOrder() {
        // if (isEmpty()) {
        //     return;
        // }
        
        // DynamicStack<Node> stack = new DynamicStack<>();
        // Node current = root;
    
        // while (current != null || !stack.isEmpty()) {
        //     while (current != null) {
        //         stack.push(current);
        //         current = current.left;
        //     }
            
        //     current = stack.pop();
        //     System.out.print(current.value + " ");
        //     current = current.right;
        // }
        // System.out.println(); // Optionally, add a newline after traversal
    }
    
    
    public void postOrder() {
        // if (isEmpty()) {
        //     return;
        // }
        
        // DynamicStack<Node> stack1 = new DynamicStack<>();
        // DynamicStack<Node> stack2 = new DynamicStack<>();
        // stack1.push(root);
    
        // while (!stack1.isEmpty()) {
        //     Node current = stack1.pop();
        //     stack2.push(current);
    
        //     if (current.left != null) {
        //         stack1.push(current.left);
        //     }
        //     if (current.right != null) {
        //         stack1.push(current.right);
        //     }
        // }
    
        // while (!stack2.isEmpty()) {
        //     Node node = stack2.pop();
        //     System.out.print(node.value + " ");
        // }
        // System.out.println(); // Optionally, add a newline after traversal
    }
    


}
