package B_Trees.a_BinaryTree;

import B_Trees.e_RedBlackTree.Color;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;
    private int height;
    private Color color;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
        this.color = null;
    }

    public T getValue() { return value; }
    public Node<T> getLeft() { return left; }
    public Node<T> getRight() { return right; }
    public int getHeight() { return height; }
    public Color getColor() { return color; }

    public void setValue(T value) { this.value = value; }
    public void setLeft(Node<T> left) { this.left = left; }
    public void setRight(Node<T> right) { this.right = right; }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}