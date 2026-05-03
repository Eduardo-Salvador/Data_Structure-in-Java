package Trees.BinarySearchTree;
import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.Node;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(T value) {
        root = new Node<>(value);
        size = 1;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }

        int compareResult = value.compareTo(current.getValue());

        if (compareResult < 0) {
            current.setLeft(insert(current.getLeft(), value));
        } else if (compareResult > 0) {
            current.setRight(insert(current.getRight(), value));
        }

        return current;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getValue());
        inOrder(current.getRight());
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getValue());
        preOrder(current.getLeft());
        preOrder(current.getRight());
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        postOrder(current.getLeft());
        postOrder(current.getRight());
        System.out.println(current.getValue());
    }

    public boolean contains(T value) {
        return search(root, value);
    }

    private boolean search(Node<T> current, T value) {
        if (current == null) return false;

        int compareResult = value.compareTo(current.getValue());

        if (compareResult == 0) return true;
        if (compareResult < 0) return search(current.getLeft(), value);

        return search(current.getRight(), value);
    }

    public T findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Node<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }

    public T findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Node<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getValue();
    }
}