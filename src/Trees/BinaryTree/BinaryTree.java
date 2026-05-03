package Trees.BinaryTree;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(T value) {
        this.root = new Node<T>(value);
    }

    public BinaryTree(Node<T> root){
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<T>(value);
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insert(current.getLeft(), value));
        } else {
            current.setRight(insert(current.getRight(), value));
        }
        return current;
    }
}