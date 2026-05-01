package Trees.BinaryTree;

public class BinaryTree {
    private Node node;
    private int size;

    public BinaryTree(int value) {
        this.node = new Node(value);
    }

    public BinaryTree(){}

    public BinaryTree(Node root){
        this.node = root;
    }

    public boolean isEmpty(){
        return node == null;
    }

    public int size(){
        return size;
    }

    public void insert(int value) {
        node = insert(node, value);
    }

    private Node insert(Node current, int value) {
        if (current == null) {
            size++;
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeft(insert(current.getLeft(), value));
        } else {
            current.setRight(insert(current.getRight(), value));
        }
        return current;
    }


}
