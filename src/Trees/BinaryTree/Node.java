package Trees.BinaryTree;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;
    private int height;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public T getValue() { return value; }
    public Node<T> getLeft() { return left; }
    public Node<T> getRight() { return right; }
    public int getHeight() { return height; }

    public void setValue(T value) { this.value = value; }
    public void setLeft(Node<T> left) { this.left = left; }
    public void setRight(Node<T> right) { this.right = right; }
    public void setHeight(int height) {
        this.height = height;
    }
}